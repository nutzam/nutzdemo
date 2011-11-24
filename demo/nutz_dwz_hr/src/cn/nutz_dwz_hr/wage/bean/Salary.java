package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 薪资表 bean<br>
* 表名：HR_SALARY<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_SALARY")
public class Salary implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 员工 **/
	@Column("EMPLOYEE_ID")
	private String employeeId;
	/** 账套 **/
	@Column("ACCOUNT_ID")
	private String accountId;
	/** 薪资日期 **/
	@Column("SALARY_DATE")
	private String salaryDate;
	/** col00 **/
	@Column("COL00")
	private Double col00;
	/** col01 **/
	@Column("COL01")
	private Double col01;
	/** col02 **/
	@Column("COL02")
	private Double col02;
	/** col03 **/
	@Column("COL03")
	private Double col03;
	/** col04 **/
	@Column("COL04")
	private Double col04;
	/** col05 **/
	@Column("COL05")
	private Double col05;
	/** col06 **/
	@Column("COL06")
	private Double col06;
	/** col07 **/
	@Column("COL07")
	private Double col07;
	/** col08 **/
	@Column("COL08")
	private Double col08;
	/** col09 **/
	@Column("COL09")
	private Double col09;
	/** col10 **/
	@Column("COL10")
	private Double col10;
	/** col11 **/
	@Column("COL11")
	private Double col11;
	/** col12 **/
	@Column("COL12")
	private Double col12;
	/** col13 **/
	@Column("COL13")
	private Double col13;
	/** col14 **/
	@Column("COL14")
	private Double col14;
	/** col15 **/
	@Column("COL15")
	private Double col15;
	/** col16 **/
	@Column("COL16")
	private Double col16;
	/** col17 **/
	@Column("COL17")
	private Double col17;
	/** col18 **/
	@Column("COL18")
	private Double col18;
	/** col19 **/
	@Column("COL19")
	private Double col19;
	/** col20 **/
	@Column("COL20")
	private Double col20;
	/** col21 **/
	@Column("COL21")
	private Double col21;
	/** col22 **/
	@Column("COL22")
	private Double col22;
	/** col23 **/
	@Column("COL23")
	private Double col23;
	/** col24 **/
	@Column("COL24")
	private Double col24;
	/** col25 **/
	@Column("COL25")
	private Double col25;
	/** col26 **/
	@Column("COL26")
	private Double col26;
	/** col27 **/
	@Column("COL27")
	private Double col27;
	/** col28 **/
	@Column("COL28")
	private Double col28;
	/** col29 **/
	@Column("COL29")
	private Double col29;
	/** col30 **/
	@Column("COL30")
	private Double col30;
	/** col31 **/
	@Column("COL31")
	private Double col31;
	/** col32 **/
	@Column("COL32")
	private Double col32;
	/** col33 **/
	@Column("COL33")
	private Double col33;
	/** col34 **/
	@Column("COL34")
	private Double col34;
	/** col35 **/
	@Column("COL35")
	private Double col35;
	/** col36 **/
	@Column("COL36")
	private Double col36;
	/** col37 **/
	@Column("COL37")
	private Double col37;
	/** col38 **/
	@Column("COL38")
	private Double col38;
	/** col39 **/
	@Column("COL39")
	private Double col39;
	/** col40 **/
	@Column("COL40")
	private Double col40;
	/** col41 **/
	@Column("COL41")
	private Double col41;
	/** col42 **/
	@Column("COL42")
	private Double col42;
	/** col43 **/
	@Column("COL43")
	private Double col43;
	/** col44 **/
	@Column("COL44")
	private Double col44;
	/** col45 **/
	@Column("COL45")
	private Double col45;
	/** col46 **/
	@Column("COL46")
	private Double col46;
	/** col47 **/
	@Column("COL47")
	private Double col47;
	/** col48 **/
	@Column("COL48")
	private Double col48;
	/** col49 **/
	@Column("COL49")
	private Double col49;
	/** col50 **/
	@Column("COL50")
	private Double col50;
	/** col51 **/
	@Column("COL51")
	private Double col51;
	/** col52 **/
	@Column("COL52")
	private Double col52;
	/** col53 **/
	@Column("COL53")
	private Double col53;
	/** col54 **/
	@Column("COL54")
	private Double col54;
	/** col55 **/
	@Column("COL55")
	private Double col55;
	/** col56 **/
	@Column("COL56")
	private Double col56;
	/** col57 **/
	@Column("COL57")
	private Double col57;
	/** col58 **/
	@Column("COL58")
	private Double col58;
	/** col59 **/
	@Column("COL59")
	private Double col59;
	/** col60 **/
	@Column("COL60")
	private Double col60;
	/** col61 **/
	@Column("COL61")
	private Double col61;
	/** col62 **/
	@Column("COL62")
	private Double col62;
	/** col63 **/
	@Column("COL63")
	private Double col63;
	/** col64 **/
	@Column("COL64")
	private Double col64;
	/** col65 **/
	@Column("COL65")
	private Double col65;
	/** col66 **/
	@Column("COL66")
	private Double col66;
	/** col67 **/
	@Column("COL67")
	private Double col67;
	/** col68 **/
	@Column("COL68")
	private Double col68;
	/** col69 **/
	@Column("COL69")
	private Double col69;
	/** col70 **/
	@Column("COL70")
	private Double col70;
	/** col71 **/
	@Column("COL71")
	private Double col71;
	/** col72 **/
	@Column("COL72")
	private Double col72;
	/** col73 **/
	@Column("COL73")
	private Double col73;
	/** col74 **/
	@Column("COL74")
	private Double col74;
	/** col75 **/
	@Column("COL75")
	private Double col75;
	/** col76 **/
	@Column("COL76")
	private Double col76;
	/** col77 **/
	@Column("COL77")
	private Double col77;
	/** col78 **/
	@Column("COL78")
	private Double col78;
	/** col79 **/
	@Column("COL79")
	private Double col79;
	/** col80 **/
	@Column("COL80")
	private Double col80;
	/** col81 **/
	@Column("COL81")
	private Double col81;
	/** col82 **/
	@Column("COL82")
	private Double col82;
	/** col83 **/
	@Column("COL83")
	private Double col83;
	/** col84 **/
	@Column("COL84")
	private Double col84;
	/** col85 **/
	@Column("COL85")
	private Double col85;
	/** col86 **/
	@Column("COL86")
	private Double col86;
	/** col87 **/
	@Column("COL87")
	private Double col87;
	/** col88 **/
	@Column("COL88")
	private Double col88;
	/** col89 **/
	@Column("COL89")
	private Double col89;
	/** col90 **/
	@Column("COL90")
	private Double col90;
	/** col91 **/
	@Column("COL91")
	private Double col91;
	/** col92 **/
	@Column("COL92")
	private Double col92;
	/** col93 **/
	@Column("COL93")
	private Double col93;
	/** col94 **/
	@Column("COL94")
	private Double col94;
	/** col95 **/
	@Column("COL95")
	private Double col95;
	/** col96 **/
	@Column("COL96")
	private Double col96;
	/** col97 **/
	@Column("COL97")
	private Double col97;
	/** col98 **/
	@Column("COL98")
	private Double col98;
	/** col99 **/
	@Column("COL99")
	private Double col99;
	/** 实发工资 **/
	@Column("TOTAL")
	private Double total;
	/** 状态 **/
	@Column("STATUS")
	private String status;
	/** 描述 **/
	@Column("DESCRIPTION")
	private String description;
	/** 部门 **/
	@Column("DEPTID")
	private String deptid;
	/** salarytext00 **/
	@Column("SALARYTEXT00")
	private String salarytext00;
	/** salarytext01 **/
	@Column("SALARYTEXT01")
	private String salarytext01;
	/** salarytext02 **/
	@Column("SALARYTEXT02")
	private String salarytext02;
	/** salarytext03 **/
	@Column("SALARYTEXT03")
	private String salarytext03;
	/** salarytext04 **/
	@Column("SALARYTEXT04")
	private String salarytext04;
	/** salarytext05 **/
	@Column("SALARYTEXT05")
	private String salarytext05;
	/** salarytext06 **/
	@Column("SALARYTEXT06")
	private String salarytext06;
	/** salarytext07 **/
	@Column("SALARYTEXT07")
	private String salarytext07;
	/** salarytext08 **/
	@Column("SALARYTEXT08")
	private String salarytext08;
	/** salarytext09 **/
	@Column("SALARYTEXT09")
	private String salarytext09;
	/** 创建人 **/
	@Column("CREATE_USER")
	private String createUser;
	/** 创建时间 **/
	@Column("CREATE_DATE")
	private String createDate;
	/** 修改人 **/
	@Column("MODIFY_USER")
	private String modifyUser;
	/** 修改时间 **/
	@Column("MODIFY_DATE")
	private String modifyDate;
	//columns END
	
	public Salary(){
	}

	public Salary(
		java.lang.String id
	){
		this.id = id;
	}

	/**
	 * 设置 id.
	 * 
	 * @param Id
	 *            id
	 */
	public void setId(java.lang.String value) {
		this.id = value;
	}
	/**
	 * 取得 id.
	 * 
	 * @return Id
	 */
	public java.lang.String getId() {
		return this.id;
	}
	/**
	 * 设置 员工.
	 * 
	 * @param EmployeeId
	 *            员工
	 */
	public void setEmployeeId(java.lang.String value) {
		this.employeeId = value;
	}
	/**
	 * 取得 员工.
	 * 
	 * @return EmployeeId
	 */
	public java.lang.String getEmployeeId() {
		return this.employeeId;
	}
	/**
	 * 设置 账套.
	 * 
	 * @param AccountId
	 *            账套
	 */
	public void setAccountId(java.lang.String value) {
		this.accountId = value;
	}
	/**
	 * 取得 账套.
	 * 
	 * @return AccountId
	 */
	public java.lang.String getAccountId() {
		return this.accountId;
	}
	/**
	 * 设置 薪资日期.
	 * 
	 * @param SalaryDate
	 *            薪资日期
	 */
	public void setSalaryDate(java.lang.String value) {
		this.salaryDate = value;
	}
	/**
	 * 取得 薪资日期.
	 * 
	 * @return SalaryDate
	 */
	public java.lang.String getSalaryDate() {
		return this.salaryDate;
	}
	/**
	 * 设置 col00.
	 * 
	 * @param Col00
	 *            col00
	 */
	public void setCol00(java.lang.Double value) {
		this.col00 = value;
	}
	/**
	 * 取得 col00.
	 * 
	 * @return Col00
	 */
	public java.lang.Double getCol00() {
		return this.col00;
	}
	/**
	 * 设置 col01.
	 * 
	 * @param Col01
	 *            col01
	 */
	public void setCol01(java.lang.Double value) {
		this.col01 = value;
	}
	/**
	 * 取得 col01.
	 * 
	 * @return Col01
	 */
	public java.lang.Double getCol01() {
		return this.col01;
	}
	/**
	 * 设置 col02.
	 * 
	 * @param Col02
	 *            col02
	 */
	public void setCol02(java.lang.Double value) {
		this.col02 = value;
	}
	/**
	 * 取得 col02.
	 * 
	 * @return Col02
	 */
	public java.lang.Double getCol02() {
		return this.col02;
	}
	/**
	 * 设置 col03.
	 * 
	 * @param Col03
	 *            col03
	 */
	public void setCol03(java.lang.Double value) {
		this.col03 = value;
	}
	/**
	 * 取得 col03.
	 * 
	 * @return Col03
	 */
	public java.lang.Double getCol03() {
		return this.col03;
	}
	/**
	 * 设置 col04.
	 * 
	 * @param Col04
	 *            col04
	 */
	public void setCol04(java.lang.Double value) {
		this.col04 = value;
	}
	/**
	 * 取得 col04.
	 * 
	 * @return Col04
	 */
	public java.lang.Double getCol04() {
		return this.col04;
	}
	/**
	 * 设置 col05.
	 * 
	 * @param Col05
	 *            col05
	 */
	public void setCol05(java.lang.Double value) {
		this.col05 = value;
	}
	/**
	 * 取得 col05.
	 * 
	 * @return Col05
	 */
	public java.lang.Double getCol05() {
		return this.col05;
	}
	/**
	 * 设置 col06.
	 * 
	 * @param Col06
	 *            col06
	 */
	public void setCol06(java.lang.Double value) {
		this.col06 = value;
	}
	/**
	 * 取得 col06.
	 * 
	 * @return Col06
	 */
	public java.lang.Double getCol06() {
		return this.col06;
	}
	/**
	 * 设置 col07.
	 * 
	 * @param Col07
	 *            col07
	 */
	public void setCol07(java.lang.Double value) {
		this.col07 = value;
	}
	/**
	 * 取得 col07.
	 * 
	 * @return Col07
	 */
	public java.lang.Double getCol07() {
		return this.col07;
	}
	/**
	 * 设置 col08.
	 * 
	 * @param Col08
	 *            col08
	 */
	public void setCol08(java.lang.Double value) {
		this.col08 = value;
	}
	/**
	 * 取得 col08.
	 * 
	 * @return Col08
	 */
	public java.lang.Double getCol08() {
		return this.col08;
	}
	/**
	 * 设置 col09.
	 * 
	 * @param Col09
	 *            col09
	 */
	public void setCol09(java.lang.Double value) {
		this.col09 = value;
	}
	/**
	 * 取得 col09.
	 * 
	 * @return Col09
	 */
	public java.lang.Double getCol09() {
		return this.col09;
	}
	/**
	 * 设置 col10.
	 * 
	 * @param Col10
	 *            col10
	 */
	public void setCol10(java.lang.Double value) {
		this.col10 = value;
	}
	/**
	 * 取得 col10.
	 * 
	 * @return Col10
	 */
	public java.lang.Double getCol10() {
		return this.col10;
	}
	/**
	 * 设置 col11.
	 * 
	 * @param Col11
	 *            col11
	 */
	public void setCol11(java.lang.Double value) {
		this.col11 = value;
	}
	/**
	 * 取得 col11.
	 * 
	 * @return Col11
	 */
	public java.lang.Double getCol11() {
		return this.col11;
	}
	/**
	 * 设置 col12.
	 * 
	 * @param Col12
	 *            col12
	 */
	public void setCol12(java.lang.Double value) {
		this.col12 = value;
	}
	/**
	 * 取得 col12.
	 * 
	 * @return Col12
	 */
	public java.lang.Double getCol12() {
		return this.col12;
	}
	/**
	 * 设置 col13.
	 * 
	 * @param Col13
	 *            col13
	 */
	public void setCol13(java.lang.Double value) {
		this.col13 = value;
	}
	/**
	 * 取得 col13.
	 * 
	 * @return Col13
	 */
	public java.lang.Double getCol13() {
		return this.col13;
	}
	/**
	 * 设置 col14.
	 * 
	 * @param Col14
	 *            col14
	 */
	public void setCol14(java.lang.Double value) {
		this.col14 = value;
	}
	/**
	 * 取得 col14.
	 * 
	 * @return Col14
	 */
	public java.lang.Double getCol14() {
		return this.col14;
	}
	/**
	 * 设置 col15.
	 * 
	 * @param Col15
	 *            col15
	 */
	public void setCol15(java.lang.Double value) {
		this.col15 = value;
	}
	/**
	 * 取得 col15.
	 * 
	 * @return Col15
	 */
	public java.lang.Double getCol15() {
		return this.col15;
	}
	/**
	 * 设置 col16.
	 * 
	 * @param Col16
	 *            col16
	 */
	public void setCol16(java.lang.Double value) {
		this.col16 = value;
	}
	/**
	 * 取得 col16.
	 * 
	 * @return Col16
	 */
	public java.lang.Double getCol16() {
		return this.col16;
	}
	/**
	 * 设置 col17.
	 * 
	 * @param Col17
	 *            col17
	 */
	public void setCol17(java.lang.Double value) {
		this.col17 = value;
	}
	/**
	 * 取得 col17.
	 * 
	 * @return Col17
	 */
	public java.lang.Double getCol17() {
		return this.col17;
	}
	/**
	 * 设置 col18.
	 * 
	 * @param Col18
	 *            col18
	 */
	public void setCol18(java.lang.Double value) {
		this.col18 = value;
	}
	/**
	 * 取得 col18.
	 * 
	 * @return Col18
	 */
	public java.lang.Double getCol18() {
		return this.col18;
	}
	/**
	 * 设置 col19.
	 * 
	 * @param Col19
	 *            col19
	 */
	public void setCol19(java.lang.Double value) {
		this.col19 = value;
	}
	/**
	 * 取得 col19.
	 * 
	 * @return Col19
	 */
	public java.lang.Double getCol19() {
		return this.col19;
	}
	/**
	 * 设置 col20.
	 * 
	 * @param Col20
	 *            col20
	 */
	public void setCol20(java.lang.Double value) {
		this.col20 = value;
	}
	/**
	 * 取得 col20.
	 * 
	 * @return Col20
	 */
	public java.lang.Double getCol20() {
		return this.col20;
	}
	/**
	 * 设置 col21.
	 * 
	 * @param Col21
	 *            col21
	 */
	public void setCol21(java.lang.Double value) {
		this.col21 = value;
	}
	/**
	 * 取得 col21.
	 * 
	 * @return Col21
	 */
	public java.lang.Double getCol21() {
		return this.col21;
	}
	/**
	 * 设置 col22.
	 * 
	 * @param Col22
	 *            col22
	 */
	public void setCol22(java.lang.Double value) {
		this.col22 = value;
	}
	/**
	 * 取得 col22.
	 * 
	 * @return Col22
	 */
	public java.lang.Double getCol22() {
		return this.col22;
	}
	/**
	 * 设置 col23.
	 * 
	 * @param Col23
	 *            col23
	 */
	public void setCol23(java.lang.Double value) {
		this.col23 = value;
	}
	/**
	 * 取得 col23.
	 * 
	 * @return Col23
	 */
	public java.lang.Double getCol23() {
		return this.col23;
	}
	/**
	 * 设置 col24.
	 * 
	 * @param Col24
	 *            col24
	 */
	public void setCol24(java.lang.Double value) {
		this.col24 = value;
	}
	/**
	 * 取得 col24.
	 * 
	 * @return Col24
	 */
	public java.lang.Double getCol24() {
		return this.col24;
	}
	/**
	 * 设置 col25.
	 * 
	 * @param Col25
	 *            col25
	 */
	public void setCol25(java.lang.Double value) {
		this.col25 = value;
	}
	/**
	 * 取得 col25.
	 * 
	 * @return Col25
	 */
	public java.lang.Double getCol25() {
		return this.col25;
	}
	/**
	 * 设置 col26.
	 * 
	 * @param Col26
	 *            col26
	 */
	public void setCol26(java.lang.Double value) {
		this.col26 = value;
	}
	/**
	 * 取得 col26.
	 * 
	 * @return Col26
	 */
	public java.lang.Double getCol26() {
		return this.col26;
	}
	/**
	 * 设置 col27.
	 * 
	 * @param Col27
	 *            col27
	 */
	public void setCol27(java.lang.Double value) {
		this.col27 = value;
	}
	/**
	 * 取得 col27.
	 * 
	 * @return Col27
	 */
	public java.lang.Double getCol27() {
		return this.col27;
	}
	/**
	 * 设置 col28.
	 * 
	 * @param Col28
	 *            col28
	 */
	public void setCol28(java.lang.Double value) {
		this.col28 = value;
	}
	/**
	 * 取得 col28.
	 * 
	 * @return Col28
	 */
	public java.lang.Double getCol28() {
		return this.col28;
	}
	/**
	 * 设置 col29.
	 * 
	 * @param Col29
	 *            col29
	 */
	public void setCol29(java.lang.Double value) {
		this.col29 = value;
	}
	/**
	 * 取得 col29.
	 * 
	 * @return Col29
	 */
	public java.lang.Double getCol29() {
		return this.col29;
	}
	/**
	 * 设置 col30.
	 * 
	 * @param Col30
	 *            col30
	 */
	public void setCol30(java.lang.Double value) {
		this.col30 = value;
	}
	/**
	 * 取得 col30.
	 * 
	 * @return Col30
	 */
	public java.lang.Double getCol30() {
		return this.col30;
	}
	/**
	 * 设置 col31.
	 * 
	 * @param Col31
	 *            col31
	 */
	public void setCol31(java.lang.Double value) {
		this.col31 = value;
	}
	/**
	 * 取得 col31.
	 * 
	 * @return Col31
	 */
	public java.lang.Double getCol31() {
		return this.col31;
	}
	/**
	 * 设置 col32.
	 * 
	 * @param Col32
	 *            col32
	 */
	public void setCol32(java.lang.Double value) {
		this.col32 = value;
	}
	/**
	 * 取得 col32.
	 * 
	 * @return Col32
	 */
	public java.lang.Double getCol32() {
		return this.col32;
	}
	/**
	 * 设置 col33.
	 * 
	 * @param Col33
	 *            col33
	 */
	public void setCol33(java.lang.Double value) {
		this.col33 = value;
	}
	/**
	 * 取得 col33.
	 * 
	 * @return Col33
	 */
	public java.lang.Double getCol33() {
		return this.col33;
	}
	/**
	 * 设置 col34.
	 * 
	 * @param Col34
	 *            col34
	 */
	public void setCol34(java.lang.Double value) {
		this.col34 = value;
	}
	/**
	 * 取得 col34.
	 * 
	 * @return Col34
	 */
	public java.lang.Double getCol34() {
		return this.col34;
	}
	/**
	 * 设置 col35.
	 * 
	 * @param Col35
	 *            col35
	 */
	public void setCol35(java.lang.Double value) {
		this.col35 = value;
	}
	/**
	 * 取得 col35.
	 * 
	 * @return Col35
	 */
	public java.lang.Double getCol35() {
		return this.col35;
	}
	/**
	 * 设置 col36.
	 * 
	 * @param Col36
	 *            col36
	 */
	public void setCol36(java.lang.Double value) {
		this.col36 = value;
	}
	/**
	 * 取得 col36.
	 * 
	 * @return Col36
	 */
	public java.lang.Double getCol36() {
		return this.col36;
	}
	/**
	 * 设置 col37.
	 * 
	 * @param Col37
	 *            col37
	 */
	public void setCol37(java.lang.Double value) {
		this.col37 = value;
	}
	/**
	 * 取得 col37.
	 * 
	 * @return Col37
	 */
	public java.lang.Double getCol37() {
		return this.col37;
	}
	/**
	 * 设置 col38.
	 * 
	 * @param Col38
	 *            col38
	 */
	public void setCol38(java.lang.Double value) {
		this.col38 = value;
	}
	/**
	 * 取得 col38.
	 * 
	 * @return Col38
	 */
	public java.lang.Double getCol38() {
		return this.col38;
	}
	/**
	 * 设置 col39.
	 * 
	 * @param Col39
	 *            col39
	 */
	public void setCol39(java.lang.Double value) {
		this.col39 = value;
	}
	/**
	 * 取得 col39.
	 * 
	 * @return Col39
	 */
	public java.lang.Double getCol39() {
		return this.col39;
	}
	/**
	 * 设置 col40.
	 * 
	 * @param Col40
	 *            col40
	 */
	public void setCol40(java.lang.Double value) {
		this.col40 = value;
	}
	/**
	 * 取得 col40.
	 * 
	 * @return Col40
	 */
	public java.lang.Double getCol40() {
		return this.col40;
	}
	/**
	 * 设置 col41.
	 * 
	 * @param Col41
	 *            col41
	 */
	public void setCol41(java.lang.Double value) {
		this.col41 = value;
	}
	/**
	 * 取得 col41.
	 * 
	 * @return Col41
	 */
	public java.lang.Double getCol41() {
		return this.col41;
	}
	/**
	 * 设置 col42.
	 * 
	 * @param Col42
	 *            col42
	 */
	public void setCol42(java.lang.Double value) {
		this.col42 = value;
	}
	/**
	 * 取得 col42.
	 * 
	 * @return Col42
	 */
	public java.lang.Double getCol42() {
		return this.col42;
	}
	/**
	 * 设置 col43.
	 * 
	 * @param Col43
	 *            col43
	 */
	public void setCol43(java.lang.Double value) {
		this.col43 = value;
	}
	/**
	 * 取得 col43.
	 * 
	 * @return Col43
	 */
	public java.lang.Double getCol43() {
		return this.col43;
	}
	/**
	 * 设置 col44.
	 * 
	 * @param Col44
	 *            col44
	 */
	public void setCol44(java.lang.Double value) {
		this.col44 = value;
	}
	/**
	 * 取得 col44.
	 * 
	 * @return Col44
	 */
	public java.lang.Double getCol44() {
		return this.col44;
	}
	/**
	 * 设置 col45.
	 * 
	 * @param Col45
	 *            col45
	 */
	public void setCol45(java.lang.Double value) {
		this.col45 = value;
	}
	/**
	 * 取得 col45.
	 * 
	 * @return Col45
	 */
	public java.lang.Double getCol45() {
		return this.col45;
	}
	/**
	 * 设置 col46.
	 * 
	 * @param Col46
	 *            col46
	 */
	public void setCol46(java.lang.Double value) {
		this.col46 = value;
	}
	/**
	 * 取得 col46.
	 * 
	 * @return Col46
	 */
	public java.lang.Double getCol46() {
		return this.col46;
	}
	/**
	 * 设置 col47.
	 * 
	 * @param Col47
	 *            col47
	 */
	public void setCol47(java.lang.Double value) {
		this.col47 = value;
	}
	/**
	 * 取得 col47.
	 * 
	 * @return Col47
	 */
	public java.lang.Double getCol47() {
		return this.col47;
	}
	/**
	 * 设置 col48.
	 * 
	 * @param Col48
	 *            col48
	 */
	public void setCol48(java.lang.Double value) {
		this.col48 = value;
	}
	/**
	 * 取得 col48.
	 * 
	 * @return Col48
	 */
	public java.lang.Double getCol48() {
		return this.col48;
	}
	/**
	 * 设置 col49.
	 * 
	 * @param Col49
	 *            col49
	 */
	public void setCol49(java.lang.Double value) {
		this.col49 = value;
	}
	/**
	 * 取得 col49.
	 * 
	 * @return Col49
	 */
	public java.lang.Double getCol49() {
		return this.col49;
	}
	/**
	 * 设置 col50.
	 * 
	 * @param Col50
	 *            col50
	 */
	public void setCol50(java.lang.Double value) {
		this.col50 = value;
	}
	/**
	 * 取得 col50.
	 * 
	 * @return Col50
	 */
	public java.lang.Double getCol50() {
		return this.col50;
	}
	/**
	 * 设置 col51.
	 * 
	 * @param Col51
	 *            col51
	 */
	public void setCol51(java.lang.Double value) {
		this.col51 = value;
	}
	/**
	 * 取得 col51.
	 * 
	 * @return Col51
	 */
	public java.lang.Double getCol51() {
		return this.col51;
	}
	/**
	 * 设置 col52.
	 * 
	 * @param Col52
	 *            col52
	 */
	public void setCol52(java.lang.Double value) {
		this.col52 = value;
	}
	/**
	 * 取得 col52.
	 * 
	 * @return Col52
	 */
	public java.lang.Double getCol52() {
		return this.col52;
	}
	/**
	 * 设置 col53.
	 * 
	 * @param Col53
	 *            col53
	 */
	public void setCol53(java.lang.Double value) {
		this.col53 = value;
	}
	/**
	 * 取得 col53.
	 * 
	 * @return Col53
	 */
	public java.lang.Double getCol53() {
		return this.col53;
	}
	/**
	 * 设置 col54.
	 * 
	 * @param Col54
	 *            col54
	 */
	public void setCol54(java.lang.Double value) {
		this.col54 = value;
	}
	/**
	 * 取得 col54.
	 * 
	 * @return Col54
	 */
	public java.lang.Double getCol54() {
		return this.col54;
	}
	/**
	 * 设置 col55.
	 * 
	 * @param Col55
	 *            col55
	 */
	public void setCol55(java.lang.Double value) {
		this.col55 = value;
	}
	/**
	 * 取得 col55.
	 * 
	 * @return Col55
	 */
	public java.lang.Double getCol55() {
		return this.col55;
	}
	/**
	 * 设置 col56.
	 * 
	 * @param Col56
	 *            col56
	 */
	public void setCol56(java.lang.Double value) {
		this.col56 = value;
	}
	/**
	 * 取得 col56.
	 * 
	 * @return Col56
	 */
	public java.lang.Double getCol56() {
		return this.col56;
	}
	/**
	 * 设置 col57.
	 * 
	 * @param Col57
	 *            col57
	 */
	public void setCol57(java.lang.Double value) {
		this.col57 = value;
	}
	/**
	 * 取得 col57.
	 * 
	 * @return Col57
	 */
	public java.lang.Double getCol57() {
		return this.col57;
	}
	/**
	 * 设置 col58.
	 * 
	 * @param Col58
	 *            col58
	 */
	public void setCol58(java.lang.Double value) {
		this.col58 = value;
	}
	/**
	 * 取得 col58.
	 * 
	 * @return Col58
	 */
	public java.lang.Double getCol58() {
		return this.col58;
	}
	/**
	 * 设置 col59.
	 * 
	 * @param Col59
	 *            col59
	 */
	public void setCol59(java.lang.Double value) {
		this.col59 = value;
	}
	/**
	 * 取得 col59.
	 * 
	 * @return Col59
	 */
	public java.lang.Double getCol59() {
		return this.col59;
	}
	/**
	 * 设置 col60.
	 * 
	 * @param Col60
	 *            col60
	 */
	public void setCol60(java.lang.Double value) {
		this.col60 = value;
	}
	/**
	 * 取得 col60.
	 * 
	 * @return Col60
	 */
	public java.lang.Double getCol60() {
		return this.col60;
	}
	/**
	 * 设置 col61.
	 * 
	 * @param Col61
	 *            col61
	 */
	public void setCol61(java.lang.Double value) {
		this.col61 = value;
	}
	/**
	 * 取得 col61.
	 * 
	 * @return Col61
	 */
	public java.lang.Double getCol61() {
		return this.col61;
	}
	/**
	 * 设置 col62.
	 * 
	 * @param Col62
	 *            col62
	 */
	public void setCol62(java.lang.Double value) {
		this.col62 = value;
	}
	/**
	 * 取得 col62.
	 * 
	 * @return Col62
	 */
	public java.lang.Double getCol62() {
		return this.col62;
	}
	/**
	 * 设置 col63.
	 * 
	 * @param Col63
	 *            col63
	 */
	public void setCol63(java.lang.Double value) {
		this.col63 = value;
	}
	/**
	 * 取得 col63.
	 * 
	 * @return Col63
	 */
	public java.lang.Double getCol63() {
		return this.col63;
	}
	/**
	 * 设置 col64.
	 * 
	 * @param Col64
	 *            col64
	 */
	public void setCol64(java.lang.Double value) {
		this.col64 = value;
	}
	/**
	 * 取得 col64.
	 * 
	 * @return Col64
	 */
	public java.lang.Double getCol64() {
		return this.col64;
	}
	/**
	 * 设置 col65.
	 * 
	 * @param Col65
	 *            col65
	 */
	public void setCol65(java.lang.Double value) {
		this.col65 = value;
	}
	/**
	 * 取得 col65.
	 * 
	 * @return Col65
	 */
	public java.lang.Double getCol65() {
		return this.col65;
	}
	/**
	 * 设置 col66.
	 * 
	 * @param Col66
	 *            col66
	 */
	public void setCol66(java.lang.Double value) {
		this.col66 = value;
	}
	/**
	 * 取得 col66.
	 * 
	 * @return Col66
	 */
	public java.lang.Double getCol66() {
		return this.col66;
	}
	/**
	 * 设置 col67.
	 * 
	 * @param Col67
	 *            col67
	 */
	public void setCol67(java.lang.Double value) {
		this.col67 = value;
	}
	/**
	 * 取得 col67.
	 * 
	 * @return Col67
	 */
	public java.lang.Double getCol67() {
		return this.col67;
	}
	/**
	 * 设置 col68.
	 * 
	 * @param Col68
	 *            col68
	 */
	public void setCol68(java.lang.Double value) {
		this.col68 = value;
	}
	/**
	 * 取得 col68.
	 * 
	 * @return Col68
	 */
	public java.lang.Double getCol68() {
		return this.col68;
	}
	/**
	 * 设置 col69.
	 * 
	 * @param Col69
	 *            col69
	 */
	public void setCol69(java.lang.Double value) {
		this.col69 = value;
	}
	/**
	 * 取得 col69.
	 * 
	 * @return Col69
	 */
	public java.lang.Double getCol69() {
		return this.col69;
	}
	/**
	 * 设置 col70.
	 * 
	 * @param Col70
	 *            col70
	 */
	public void setCol70(java.lang.Double value) {
		this.col70 = value;
	}
	/**
	 * 取得 col70.
	 * 
	 * @return Col70
	 */
	public java.lang.Double getCol70() {
		return this.col70;
	}
	/**
	 * 设置 col71.
	 * 
	 * @param Col71
	 *            col71
	 */
	public void setCol71(java.lang.Double value) {
		this.col71 = value;
	}
	/**
	 * 取得 col71.
	 * 
	 * @return Col71
	 */
	public java.lang.Double getCol71() {
		return this.col71;
	}
	/**
	 * 设置 col72.
	 * 
	 * @param Col72
	 *            col72
	 */
	public void setCol72(java.lang.Double value) {
		this.col72 = value;
	}
	/**
	 * 取得 col72.
	 * 
	 * @return Col72
	 */
	public java.lang.Double getCol72() {
		return this.col72;
	}
	/**
	 * 设置 col73.
	 * 
	 * @param Col73
	 *            col73
	 */
	public void setCol73(java.lang.Double value) {
		this.col73 = value;
	}
	/**
	 * 取得 col73.
	 * 
	 * @return Col73
	 */
	public java.lang.Double getCol73() {
		return this.col73;
	}
	/**
	 * 设置 col74.
	 * 
	 * @param Col74
	 *            col74
	 */
	public void setCol74(java.lang.Double value) {
		this.col74 = value;
	}
	/**
	 * 取得 col74.
	 * 
	 * @return Col74
	 */
	public java.lang.Double getCol74() {
		return this.col74;
	}
	/**
	 * 设置 col75.
	 * 
	 * @param Col75
	 *            col75
	 */
	public void setCol75(java.lang.Double value) {
		this.col75 = value;
	}
	/**
	 * 取得 col75.
	 * 
	 * @return Col75
	 */
	public java.lang.Double getCol75() {
		return this.col75;
	}
	/**
	 * 设置 col76.
	 * 
	 * @param Col76
	 *            col76
	 */
	public void setCol76(java.lang.Double value) {
		this.col76 = value;
	}
	/**
	 * 取得 col76.
	 * 
	 * @return Col76
	 */
	public java.lang.Double getCol76() {
		return this.col76;
	}
	/**
	 * 设置 col77.
	 * 
	 * @param Col77
	 *            col77
	 */
	public void setCol77(java.lang.Double value) {
		this.col77 = value;
	}
	/**
	 * 取得 col77.
	 * 
	 * @return Col77
	 */
	public java.lang.Double getCol77() {
		return this.col77;
	}
	/**
	 * 设置 col78.
	 * 
	 * @param Col78
	 *            col78
	 */
	public void setCol78(java.lang.Double value) {
		this.col78 = value;
	}
	/**
	 * 取得 col78.
	 * 
	 * @return Col78
	 */
	public java.lang.Double getCol78() {
		return this.col78;
	}
	/**
	 * 设置 col79.
	 * 
	 * @param Col79
	 *            col79
	 */
	public void setCol79(java.lang.Double value) {
		this.col79 = value;
	}
	/**
	 * 取得 col79.
	 * 
	 * @return Col79
	 */
	public java.lang.Double getCol79() {
		return this.col79;
	}
	/**
	 * 设置 col80.
	 * 
	 * @param Col80
	 *            col80
	 */
	public void setCol80(java.lang.Double value) {
		this.col80 = value;
	}
	/**
	 * 取得 col80.
	 * 
	 * @return Col80
	 */
	public java.lang.Double getCol80() {
		return this.col80;
	}
	/**
	 * 设置 col81.
	 * 
	 * @param Col81
	 *            col81
	 */
	public void setCol81(java.lang.Double value) {
		this.col81 = value;
	}
	/**
	 * 取得 col81.
	 * 
	 * @return Col81
	 */
	public java.lang.Double getCol81() {
		return this.col81;
	}
	/**
	 * 设置 col82.
	 * 
	 * @param Col82
	 *            col82
	 */
	public void setCol82(java.lang.Double value) {
		this.col82 = value;
	}
	/**
	 * 取得 col82.
	 * 
	 * @return Col82
	 */
	public java.lang.Double getCol82() {
		return this.col82;
	}
	/**
	 * 设置 col83.
	 * 
	 * @param Col83
	 *            col83
	 */
	public void setCol83(java.lang.Double value) {
		this.col83 = value;
	}
	/**
	 * 取得 col83.
	 * 
	 * @return Col83
	 */
	public java.lang.Double getCol83() {
		return this.col83;
	}
	/**
	 * 设置 col84.
	 * 
	 * @param Col84
	 *            col84
	 */
	public void setCol84(java.lang.Double value) {
		this.col84 = value;
	}
	/**
	 * 取得 col84.
	 * 
	 * @return Col84
	 */
	public java.lang.Double getCol84() {
		return this.col84;
	}
	/**
	 * 设置 col85.
	 * 
	 * @param Col85
	 *            col85
	 */
	public void setCol85(java.lang.Double value) {
		this.col85 = value;
	}
	/**
	 * 取得 col85.
	 * 
	 * @return Col85
	 */
	public java.lang.Double getCol85() {
		return this.col85;
	}
	/**
	 * 设置 col86.
	 * 
	 * @param Col86
	 *            col86
	 */
	public void setCol86(java.lang.Double value) {
		this.col86 = value;
	}
	/**
	 * 取得 col86.
	 * 
	 * @return Col86
	 */
	public java.lang.Double getCol86() {
		return this.col86;
	}
	/**
	 * 设置 col87.
	 * 
	 * @param Col87
	 *            col87
	 */
	public void setCol87(java.lang.Double value) {
		this.col87 = value;
	}
	/**
	 * 取得 col87.
	 * 
	 * @return Col87
	 */
	public java.lang.Double getCol87() {
		return this.col87;
	}
	/**
	 * 设置 col88.
	 * 
	 * @param Col88
	 *            col88
	 */
	public void setCol88(java.lang.Double value) {
		this.col88 = value;
	}
	/**
	 * 取得 col88.
	 * 
	 * @return Col88
	 */
	public java.lang.Double getCol88() {
		return this.col88;
	}
	/**
	 * 设置 col89.
	 * 
	 * @param Col89
	 *            col89
	 */
	public void setCol89(java.lang.Double value) {
		this.col89 = value;
	}
	/**
	 * 取得 col89.
	 * 
	 * @return Col89
	 */
	public java.lang.Double getCol89() {
		return this.col89;
	}
	/**
	 * 设置 col90.
	 * 
	 * @param Col90
	 *            col90
	 */
	public void setCol90(java.lang.Double value) {
		this.col90 = value;
	}
	/**
	 * 取得 col90.
	 * 
	 * @return Col90
	 */
	public java.lang.Double getCol90() {
		return this.col90;
	}
	/**
	 * 设置 col91.
	 * 
	 * @param Col91
	 *            col91
	 */
	public void setCol91(java.lang.Double value) {
		this.col91 = value;
	}
	/**
	 * 取得 col91.
	 * 
	 * @return Col91
	 */
	public java.lang.Double getCol91() {
		return this.col91;
	}
	/**
	 * 设置 col92.
	 * 
	 * @param Col92
	 *            col92
	 */
	public void setCol92(java.lang.Double value) {
		this.col92 = value;
	}
	/**
	 * 取得 col92.
	 * 
	 * @return Col92
	 */
	public java.lang.Double getCol92() {
		return this.col92;
	}
	/**
	 * 设置 col93.
	 * 
	 * @param Col93
	 *            col93
	 */
	public void setCol93(java.lang.Double value) {
		this.col93 = value;
	}
	/**
	 * 取得 col93.
	 * 
	 * @return Col93
	 */
	public java.lang.Double getCol93() {
		return this.col93;
	}
	/**
	 * 设置 col94.
	 * 
	 * @param Col94
	 *            col94
	 */
	public void setCol94(java.lang.Double value) {
		this.col94 = value;
	}
	/**
	 * 取得 col94.
	 * 
	 * @return Col94
	 */
	public java.lang.Double getCol94() {
		return this.col94;
	}
	/**
	 * 设置 col95.
	 * 
	 * @param Col95
	 *            col95
	 */
	public void setCol95(java.lang.Double value) {
		this.col95 = value;
	}
	/**
	 * 取得 col95.
	 * 
	 * @return Col95
	 */
	public java.lang.Double getCol95() {
		return this.col95;
	}
	/**
	 * 设置 col96.
	 * 
	 * @param Col96
	 *            col96
	 */
	public void setCol96(java.lang.Double value) {
		this.col96 = value;
	}
	/**
	 * 取得 col96.
	 * 
	 * @return Col96
	 */
	public java.lang.Double getCol96() {
		return this.col96;
	}
	/**
	 * 设置 col97.
	 * 
	 * @param Col97
	 *            col97
	 */
	public void setCol97(java.lang.Double value) {
		this.col97 = value;
	}
	/**
	 * 取得 col97.
	 * 
	 * @return Col97
	 */
	public java.lang.Double getCol97() {
		return this.col97;
	}
	/**
	 * 设置 col98.
	 * 
	 * @param Col98
	 *            col98
	 */
	public void setCol98(java.lang.Double value) {
		this.col98 = value;
	}
	/**
	 * 取得 col98.
	 * 
	 * @return Col98
	 */
	public java.lang.Double getCol98() {
		return this.col98;
	}
	/**
	 * 设置 col99.
	 * 
	 * @param Col99
	 *            col99
	 */
	public void setCol99(java.lang.Double value) {
		this.col99 = value;
	}
	/**
	 * 取得 col99.
	 * 
	 * @return Col99
	 */
	public java.lang.Double getCol99() {
		return this.col99;
	}
	/**
	 * 设置 实发工资.
	 * 
	 * @param Total
	 *            实发工资
	 */
	public void setTotal(java.lang.Double value) {
		this.total = value;
	}
	/**
	 * 取得 实发工资.
	 * 
	 * @return Total
	 */
	public java.lang.Double getTotal() {
		return this.total;
	}
	/**
	 * 设置 状态.
	 * 
	 * @param Status
	 *            状态
	 */
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	/**
	 * 取得 状态.
	 * 
	 * @return Status
	 */
	public java.lang.String getStatus() {
		return this.status;
	}
	/**
	 * 设置 描述.
	 * 
	 * @param Description
	 *            描述
	 */
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	/**
	 * 取得 描述.
	 * 
	 * @return Description
	 */
	public java.lang.String getDescription() {
		return this.description;
	}
	/**
	 * 设置 部门.
	 * 
	 * @param Deptid
	 *            部门
	 */
	public void setDeptid(java.lang.String value) {
		this.deptid = value;
	}
	/**
	 * 取得 部门.
	 * 
	 * @return Deptid
	 */
	public java.lang.String getDeptid() {
		return this.deptid;
	}
	/**
	 * 设置 salarytext00.
	 * 
	 * @param Salarytext00
	 *            salarytext00
	 */
	public void setSalarytext00(java.lang.String value) {
		this.salarytext00 = value;
	}
	/**
	 * 取得 salarytext00.
	 * 
	 * @return Salarytext00
	 */
	public java.lang.String getSalarytext00() {
		return this.salarytext00;
	}
	/**
	 * 设置 salarytext01.
	 * 
	 * @param Salarytext01
	 *            salarytext01
	 */
	public void setSalarytext01(java.lang.String value) {
		this.salarytext01 = value;
	}
	/**
	 * 取得 salarytext01.
	 * 
	 * @return Salarytext01
	 */
	public java.lang.String getSalarytext01() {
		return this.salarytext01;
	}
	/**
	 * 设置 salarytext02.
	 * 
	 * @param Salarytext02
	 *            salarytext02
	 */
	public void setSalarytext02(java.lang.String value) {
		this.salarytext02 = value;
	}
	/**
	 * 取得 salarytext02.
	 * 
	 * @return Salarytext02
	 */
	public java.lang.String getSalarytext02() {
		return this.salarytext02;
	}
	/**
	 * 设置 salarytext03.
	 * 
	 * @param Salarytext03
	 *            salarytext03
	 */
	public void setSalarytext03(java.lang.String value) {
		this.salarytext03 = value;
	}
	/**
	 * 取得 salarytext03.
	 * 
	 * @return Salarytext03
	 */
	public java.lang.String getSalarytext03() {
		return this.salarytext03;
	}
	/**
	 * 设置 salarytext04.
	 * 
	 * @param Salarytext04
	 *            salarytext04
	 */
	public void setSalarytext04(java.lang.String value) {
		this.salarytext04 = value;
	}
	/**
	 * 取得 salarytext04.
	 * 
	 * @return Salarytext04
	 */
	public java.lang.String getSalarytext04() {
		return this.salarytext04;
	}
	/**
	 * 设置 salarytext05.
	 * 
	 * @param Salarytext05
	 *            salarytext05
	 */
	public void setSalarytext05(java.lang.String value) {
		this.salarytext05 = value;
	}
	/**
	 * 取得 salarytext05.
	 * 
	 * @return Salarytext05
	 */
	public java.lang.String getSalarytext05() {
		return this.salarytext05;
	}
	/**
	 * 设置 salarytext06.
	 * 
	 * @param Salarytext06
	 *            salarytext06
	 */
	public void setSalarytext06(java.lang.String value) {
		this.salarytext06 = value;
	}
	/**
	 * 取得 salarytext06.
	 * 
	 * @return Salarytext06
	 */
	public java.lang.String getSalarytext06() {
		return this.salarytext06;
	}
	/**
	 * 设置 salarytext07.
	 * 
	 * @param Salarytext07
	 *            salarytext07
	 */
	public void setSalarytext07(java.lang.String value) {
		this.salarytext07 = value;
	}
	/**
	 * 取得 salarytext07.
	 * 
	 * @return Salarytext07
	 */
	public java.lang.String getSalarytext07() {
		return this.salarytext07;
	}
	/**
	 * 设置 salarytext08.
	 * 
	 * @param Salarytext08
	 *            salarytext08
	 */
	public void setSalarytext08(java.lang.String value) {
		this.salarytext08 = value;
	}
	/**
	 * 取得 salarytext08.
	 * 
	 * @return Salarytext08
	 */
	public java.lang.String getSalarytext08() {
		return this.salarytext08;
	}
	/**
	 * 设置 salarytext09.
	 * 
	 * @param Salarytext09
	 *            salarytext09
	 */
	public void setSalarytext09(java.lang.String value) {
		this.salarytext09 = value;
	}
	/**
	 * 取得 salarytext09.
	 * 
	 * @return Salarytext09
	 */
	public java.lang.String getSalarytext09() {
		return this.salarytext09;
	}
	/**
	 * 设置 创建人.
	 * 
	 * @param CreateUser
	 *            创建人
	 */
	public void setCreateUser(java.lang.String value) {
		this.createUser = value;
	}
	/**
	 * 取得 创建人.
	 * 
	 * @return CreateUser
	 */
	public java.lang.String getCreateUser() {
		return this.createUser;
	}
	/**
	 * 设置 创建时间.
	 * 
	 * @param CreateDate
	 *            创建时间
	 */
	public void setCreateDate(java.lang.String value) {
		this.createDate = value;
	}
	/**
	 * 取得 创建时间.
	 * 
	 * @return CreateDate
	 */
	public java.lang.String getCreateDate() {
		return this.createDate;
	}
	/**
	 * 设置 修改人.
	 * 
	 * @param ModifyUser
	 *            修改人
	 */
	public void setModifyUser(java.lang.String value) {
		this.modifyUser = value;
	}
	/**
	 * 取得 修改人.
	 * 
	 * @return ModifyUser
	 */
	public java.lang.String getModifyUser() {
		return this.modifyUser;
	}
	/**
	 * 设置 修改时间.
	 * 
	 * @param ModifyDate
	 *            修改时间
	 */
	public void setModifyDate(java.lang.String value) {
		this.modifyDate = value;
	}
	/**
	 * 取得 修改时间.
	 * 
	 * @return ModifyDate
	 */
	public java.lang.String getModifyDate() {
		return this.modifyDate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("EmployeeId",getEmployeeId())
			.append("AccountId",getAccountId())
			.append("SalaryDate",getSalaryDate())
			.append("Col00",getCol00())
			.append("Col01",getCol01())
			.append("Col02",getCol02())
			.append("Col03",getCol03())
			.append("Col04",getCol04())
			.append("Col05",getCol05())
			.append("Col06",getCol06())
			.append("Col07",getCol07())
			.append("Col08",getCol08())
			.append("Col09",getCol09())
			.append("Col10",getCol10())
			.append("Col11",getCol11())
			.append("Col12",getCol12())
			.append("Col13",getCol13())
			.append("Col14",getCol14())
			.append("Col15",getCol15())
			.append("Col16",getCol16())
			.append("Col17",getCol17())
			.append("Col18",getCol18())
			.append("Col19",getCol19())
			.append("Col20",getCol20())
			.append("Col21",getCol21())
			.append("Col22",getCol22())
			.append("Col23",getCol23())
			.append("Col24",getCol24())
			.append("Col25",getCol25())
			.append("Col26",getCol26())
			.append("Col27",getCol27())
			.append("Col28",getCol28())
			.append("Col29",getCol29())
			.append("Col30",getCol30())
			.append("Col31",getCol31())
			.append("Col32",getCol32())
			.append("Col33",getCol33())
			.append("Col34",getCol34())
			.append("Col35",getCol35())
			.append("Col36",getCol36())
			.append("Col37",getCol37())
			.append("Col38",getCol38())
			.append("Col39",getCol39())
			.append("Col40",getCol40())
			.append("Col41",getCol41())
			.append("Col42",getCol42())
			.append("Col43",getCol43())
			.append("Col44",getCol44())
			.append("Col45",getCol45())
			.append("Col46",getCol46())
			.append("Col47",getCol47())
			.append("Col48",getCol48())
			.append("Col49",getCol49())
			.append("Col50",getCol50())
			.append("Col51",getCol51())
			.append("Col52",getCol52())
			.append("Col53",getCol53())
			.append("Col54",getCol54())
			.append("Col55",getCol55())
			.append("Col56",getCol56())
			.append("Col57",getCol57())
			.append("Col58",getCol58())
			.append("Col59",getCol59())
			.append("Col60",getCol60())
			.append("Col61",getCol61())
			.append("Col62",getCol62())
			.append("Col63",getCol63())
			.append("Col64",getCol64())
			.append("Col65",getCol65())
			.append("Col66",getCol66())
			.append("Col67",getCol67())
			.append("Col68",getCol68())
			.append("Col69",getCol69())
			.append("Col70",getCol70())
			.append("Col71",getCol71())
			.append("Col72",getCol72())
			.append("Col73",getCol73())
			.append("Col74",getCol74())
			.append("Col75",getCol75())
			.append("Col76",getCol76())
			.append("Col77",getCol77())
			.append("Col78",getCol78())
			.append("Col79",getCol79())
			.append("Col80",getCol80())
			.append("Col81",getCol81())
			.append("Col82",getCol82())
			.append("Col83",getCol83())
			.append("Col84",getCol84())
			.append("Col85",getCol85())
			.append("Col86",getCol86())
			.append("Col87",getCol87())
			.append("Col88",getCol88())
			.append("Col89",getCol89())
			.append("Col90",getCol90())
			.append("Col91",getCol91())
			.append("Col92",getCol92())
			.append("Col93",getCol93())
			.append("Col94",getCol94())
			.append("Col95",getCol95())
			.append("Col96",getCol96())
			.append("Col97",getCol97())
			.append("Col98",getCol98())
			.append("Col99",getCol99())
			.append("Total",getTotal())
			.append("Status",getStatus())
			.append("Description",getDescription())
			.append("Deptid",getDeptid())
			.append("Salarytext00",getSalarytext00())
			.append("Salarytext01",getSalarytext01())
			.append("Salarytext02",getSalarytext02())
			.append("Salarytext03",getSalarytext03())
			.append("Salarytext04",getSalarytext04())
			.append("Salarytext05",getSalarytext05())
			.append("Salarytext06",getSalarytext06())
			.append("Salarytext07",getSalarytext07())
			.append("Salarytext08",getSalarytext08())
			.append("Salarytext09",getSalarytext09())
			.append("CreateUser",getCreateUser())
			.append("CreateDate",getCreateDate())
			.append("ModifyUser",getModifyUser())
			.append("ModifyDate",getModifyDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Salary == false) return false;
		if(this == obj) return true;
		Salary other = (Salary)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}