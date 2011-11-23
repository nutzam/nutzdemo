package org.nutz.website.pan.bean;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("tb_fileinfo")
public class FileInfo {

	/**
	 * 唯一id 
	 */
	@Id
	private long id;
	/**
	 * UUID
	 */
	@Column
	private String uuid;
	/**
	 * 上传文件的原名
	 */
	@Column
	private String srcFileName;
	/**
	 * 存放文件的路径
	 */
	@Column
	private String path;
	/**
	 * 上传者的ip
	 */
	@Column
	private String uploadIp;
	/**
	 * 创建时间
	 */
	@Column
	private Date createTime;
	/**
	 * 是否还有效
	 */
	@Column
	private boolean valid;
	/**
	 * 备注
	 */
	@Column
	private String note;
	
	//====================================================================
	//==Getter/Setter
	
	public long getId() {
		return id;
	}
	public String getUuid() {
		return uuid;
	}
	public String getSrcFileName() {
		return srcFileName;
	}
	public String getPath() {
		return path;
	}
	public String getUploadIp() {
		return uploadIp;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public boolean isValid() {
		return valid;
	}
	public String getNote() {
		return note;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setUploadIp(String uploadIp) {
		this.uploadIp = uploadIp;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
