package dto;

import java.sql.Date;

public class Membership {
	private String id;
	private int mem_num;
	private String mem_name;
	private Date mem_date;
	private String mem_phone;
	private String mem_address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public Date getMem_date() {
		return mem_date;
	}
	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_address() {
		return mem_address;
	}
	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}
	
	@Override
	public String toString() {
		return "Membership [id=" + id + ", mem_num=" + mem_num + ", mem_name=" + mem_name + ", mem_date=" + mem_date
				+ ", mem_phone=" + mem_phone + ", mem_address=" + mem_address + "]";
	}
}
