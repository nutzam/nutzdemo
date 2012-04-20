package yhp.module;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

import yhp.bean.Filter;
import yhp.bean.Item;
import yhp.bean.Sorter;
import yhp.bean.SummationItem;

@At("/Item")
@IocBean(fields={"dao"})
public class ItemModule extends EntityService<Item>{

    private static final Log log = Logs.get();
    SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
	
	@At
	public Object list(@Param("page") int page ,@Param("start") int start,@Param("limit") int limit,@Param("filter") Filter[] filters,@Param("sort") Sorter[] sorters){
		Pager pager = dao().createPager(page, limit - start);
		Cnd cnd = Utils.filter2Cnd(filters,sorters);
		List<Item> list = dao().query(Item.class, cnd.desc("id"), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(Item.class,cnd));
			map.put("pager", pager);
		}
		map.put("list", list);
		map.put("filter", filters);
		map.put("sort", sorters);
		
		return map;
	}
	
	@At
	public boolean add(@Param("..") Item obj){
		try{
			int id = dao().getMaxId(Item.class) + 1;
			obj.setId(id);
			dao().insert(obj);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	@At
	public boolean batchadd(@Param("name") String name,
			@Param("version") String version,
			@Param("count") int count,
			@Param("price") int price,
			@Param("comment") String comment){
		try{
			List<Item> items = new ArrayList<Item>();
			
			for(int i = 1; i <= count; i++){
				Item item = new Item();
				item.setName(name);
				item.setVersion(version);
				item.setPrice(price);
				item.setComment(comment);
				int id = dao().getMaxId(Item.class) + i;
				item.setId(id);
				items.add(item);
			}
			dao().insert(items);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	
	@At
	public boolean delete(@Param("items") String items){
		try{
			
			dao().clear(Item.class, Cnd.where("id", "in", items));
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	
	@At
	public boolean update(@Param("..") Item obj){
		try{
			if(dao().fetch(Item.class, obj.getId()).isDestroyed() != obj.isDestroyed()){
				if(obj.isDestroyed()){//报废
					obj.setDestroydate(new Date());
				}else{
					obj.setDestroydate(null);
				}
			}
			dao().update(obj);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	@At
	public boolean use(@Param("items") String items,
			@Param("department") String department,
			@Param("user") String user,
			@Param("principal") String principal,
			@Param("place") String place,
			@Param("usetime") Date usetime,
			@Param("comment") String comment){
		List<Item> list = dao().query(Item.class, Cnd.where("id", "in", items),null);
		for(int i = 0; i < list.size();i++){
			list.get(i).setComment(comment);
			list.get(i).setDepartment(department);
			list.get(i).setPlace(place);
			list.get(i).setPrincipal(principal);
			list.get(i).setUser(user);
			list.get(i).setUsetime(usetime);
			dao().update(list.get(i));
		}
		return true;
	}
	@At
	@Ok("jsp")
	public Object useprint(@Param("items") String items){
		return groupItems(items);
	}
	@At
	@Ok("jsp")
	public Object insertprint(@Param("items") String items){
		return groupItems(items);
	}
	@At
	@Ok("jsp")
	public Object tagprint(@Param("item") int items){
		return dao().fetch(Item.class,items);
	}
	@At
	public boolean destoryed(@Param("items") String items,
			@Param("destroyreason") String destroyreason,
			@Param("destroydate") Date destroydate,
			@Param("conditions") String conditions){
		List<Item> list = dao().query(Item.class, Cnd.where("id", "in", items),null);
		for(int i = 0; i < list.size();i++){
			list.get(i).setDestroyed(true);
			list.get(i).setDestroydate(destroydate);
			list.get(i).setDestroyreason(destroyreason);
			list.get(i).setConditions(conditions);
			dao().update(list.get(i));
		}
		return true;
	}
	@At
	@Ok("jsp")
	public Object destoryedprint(@Param("items") String items){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Item> list = dao().query(Item.class, Cnd.where("id", "in", items),null);
		Map<String, ArrayList<Item>> group = new HashMap<String, ArrayList<Item>>();
		for(int i = 0; i < list.size();i++){
			String uid = list.get(i).getName() + list.get(i).getVersion() + list.get(i).getPrice();
			if(group.containsKey(uid)){
				group.get(uid).add(list.get(i));
			}else{
				List<Item> l = new ArrayList<Item>();
				l.add(list.get(i));
				group.put(uid,(ArrayList<Item>) l);
			}
		}
		List<SummationItem> destoryedItems = new ArrayList<SummationItem>();
		int index = 1;
		for(ArrayList<Item> _items : group.values()){
			SummationItem ui = new SummationItem();
			ui.setId(index);
			ui.setName(_items.get(0).getName());
			ui.setPrice(_items.get(0).getPrice());
			ui.setUnit(_items.get(0).getUnit() == null ? "" : _items.get(0).getUnit());
			ui.setVersion(_items.get(0).getVersion());
			ui.setSummation(ui.getPrice() * _items.size());
			ui.setDestroyreason(_items.get(0).getDestroyreason());
			ui.setConditions(_items.get(0).getConditions());
			ui.setCount(_items.size());
			destoryedItems.add(ui);
			index ++;
		}
		map.put("destoryedItems", destoryedItems);
		map.put("department", list.get(0).getDepartment());
		map.put("date",df.format(new Date()) );
		
		return map;
	}
	@At
	@Ok("raw:stream")
	public FileInputStream export(HttpServletResponse response,@Param("filter") Filter[] filters,@Param("sort") Sorter[] sorters) throws RowsExceededException, WriteException, IOException{
		List<Item> list = dao().query(Item.class,Utils.filter2Cnd(filters,sorters),null);
		List<String> listHeader = new ArrayList<String>();
		listHeader.add("序号");
		listHeader.add("名称");
		listHeader.add("价格");
		listHeader.add("单位");
		listHeader.add("规格型号");
		listHeader.add("部门");
		listHeader.add("存放地点");
		listHeader.add("领用人");
		listHeader.add("负责人");
		listHeader.add("领用时间");
		listHeader.add("是否报废");
		listHeader.add("报废时间");
		listHeader.add("报废原因");
		listHeader.add("现场查看情况");
		listHeader.add("备注");
		
        WritableWorkbook wwb = null; 
        File tempFile = File.createTempFile("export","xls");
        FileOutputStream os = new FileOutputStream(tempFile);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");  
        wwb = Workbook.createWorkbook(os);
        if (wwb != null) {  
            WritableSheet ws = wwb.createSheet("低值易耗品台账", 0);  
            for (int n = 0; n < listHeader.size(); n++) {  
                Label labelC = new Label(n, 0, listHeader.get(n)); 
                ws.addCell(labelC);
            }  
            for (int i = 0; i < list.size(); i++) {
            	Item item = (Item) list.get(i); 
            	int j = i + 1;
            	Label labelId = new Label(0, j, item.getId() + "");  
				ws.addCell(labelId);
				Label labelName = new Label(1, j, item.getName() + "");  
				ws.addCell(labelName);
				Label labelPrice = new Label(2, j, item.getPrice() + "");  
				ws.addCell(labelPrice);
				Label labelUnit = new Label(3, j, item.getUnit() == null? "":item.getUnit());  
				ws.addCell(labelUnit);
				Label labelVersion = new Label(4, j, item.getVersion() + "");  
				ws.addCell(labelVersion);
				Label labelDepartment = new Label(5, j, item.getDepartment() + "");  
				ws.addCell(labelDepartment);
				Label labelPlace = new Label(6, j, item.getPlace() + "");  
				ws.addCell(labelPlace);
				Label labelUser = new Label(7, j, item.getUser() + "");  
				ws.addCell(labelUser);
				Label labelPrincipal = new Label(8, j, item.getPrincipal() + "");  
				ws.addCell(labelPrincipal);
				Label labelUsetime = new Label(9, j, item.getUsetime() == null?"" : f.format(item.getUsetime()));  
				ws.addCell(labelUsetime);
				Label labelDestroyed = new Label(10, j, item.isDestroyed() ? "已报废" : "");  
				ws.addCell(labelDestroyed);
				Label labelDestroydate = new Label(11, j, item.getDestroydate() == null ? "" : f.format(item.getDestroydate()));  
				ws.addCell(labelDestroydate);
				Label labelDestroyreason = new Label(12, j, item.getDestroyreason() == null?"":item.getDestroyreason()); 
				ws.addCell(labelDestroyreason);
				Label labelConditions = new Label(13, j, item.getConditions() == null ? "" : item.getConditions()); 
				ws.addCell(labelConditions);
				Label labelComment = new Label(14, j, item.getComment() + "");  
				ws.addCell(labelComment);
            }   
            wwb.write();  
            wwb.close();
        }
        response.setHeader("content-type", "application/vnd.ms-excel; charset=utf8");
        response.setHeader("content-disposition", "attachment; filename=export.xls"); 
        FileInputStream input=new FileInputStream(tempFile);
        return input;
	}
	private Map<String, Object> groupItems( String items){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Item> list = dao().query(Item.class, Cnd.where("id", "in", items),null);
		Map<String, ArrayList<Item>> group = new HashMap<String, ArrayList<Item>>();
		for(int i = 0; i < list.size();i++){
			String uid = list.get(i).getName() + list.get(i).getVersion() + list.get(i).getPrice();
			if(group.containsKey(uid)){
				group.get(uid).add(list.get(i));
			}else{
				List<Item> l = new ArrayList<Item>();
				l.add(list.get(i));
				group.put(uid,(ArrayList<Item>) l);
			}
		}
		List<SummationItem> useItems = new ArrayList<SummationItem>();
		int index = 1;
		int sum = 0;
		int total = 0;
		for(ArrayList<Item> _items : group.values()){
			SummationItem ui = new SummationItem();
			ui.setId(index);
			ui.setName(_items.get(0).getName());
			ui.setPrice(_items.get(0).getPrice());
			ui.setUnit(_items.get(0).getUnit() == null ? "" : _items.get(0).getUnit());
			ui.setVersion(_items.get(0).getVersion());
			ui.setComment(_items.get(0).getComment());
			ui.setSummation(ui.getPrice()*_items.size());
			ui.setCount(_items.size());
			useItems.add(ui);
			index ++;
			sum += ui.getSummation();
			total += ui.getCount();
		}
		map.put("useItems", useItems);
		map.put("department", list.get(0).getDepartment());
		map.put("user", list.get(0).getUser());
		map.put("principal", list.get(0).getPrincipal());
		map.put("place", list.get(0).getPlace());
		map.put("sum", sum);
		map.put("total", total);
		map.put("date",df.format(new Date()) );

		return map;
	}
}