package dto;

import java.sql.Date;

public class Management {
	private String id;
	private int ment_num;
	private String ment_goods;
	private Date ment_date;
	private int ment_inven;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMent_num() {
		return ment_num;
	}
	public void setMent_num(int ment_num) {
		this.ment_num = ment_num;
	}
	public String getMent_goods() {
		return ment_goods;
	}
	public void setMent_goods(String ment_goods) {
		this.ment_goods = ment_goods;
	}
	public Date getMent_date() {
		return ment_date;
	}
	public void setMent_date(Date ment_date) {
		this.ment_date = ment_date;
	}
	public int getMent_inven() {
		return ment_inven;
	}
	public void setMent_inven(int ment_inven) {
		this.ment_inven = ment_inven;
	}
	
	@Override
	public String toString() {
		return "Management [id=" + id + ", ment_num=" + ment_num + ", ment_goods=" + ment_goods + ", ment_date="
				+ ment_date + ", ment_inven=" + ment_inven + "]";
	}
}
