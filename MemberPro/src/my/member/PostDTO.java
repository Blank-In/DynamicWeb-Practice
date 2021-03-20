package my.member;

import java.sql.Date;

public class PostDTO {
	private String title;
	private String lore;
	private String ID;
	private String fileName;
	private String originFileName;
	private Date createDate;
	private int number;
	
	public void inputAll(String title,String lore,String ID,String fileName,String originFileName) { //one time five function
		this.title=title;
		this.lore=lore;
		this.ID=ID;
		this.fileName=fileName;
		this.originFileName=originFileName;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getLore() {
		return lore;
	}
	public void setLore(String lore) {
		this.lore = lore;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
