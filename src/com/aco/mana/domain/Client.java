package com.aco.mana.domain;

/**
 * �ͻ���Ϣ��bean
 * @author Administrator
 *
 */
public class Client {
	Integer cid;//�ͻ�ID
	String cname;//�ͻ�����
	String cphone;//�ͻ��绰
	String caddress;//�ͻ����ͻ���ַ
	String cremark;//�ͻ���ע
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
