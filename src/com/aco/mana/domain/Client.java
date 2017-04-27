package com.aco.mana.domain;

/**
 * 客户信息的bean
 * @author Administrator
 *
 */
public class Client {
	Integer cid;//客户ID
	String cname;//客户姓名
	String cphone;//客户电话
	String caddress;//客户的送货地址
	String cremark;//客户备注
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCremark() {
		return cremark;
	}
	public void setCremark(String cremark) {
		this.cremark = cremark;
	}
	
	
}
