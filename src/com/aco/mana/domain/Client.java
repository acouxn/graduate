package com.aco.mana.domain;

import java.util.HashSet;
import java.util.Set;

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
	
	private Set<OutFurniture> outFurniture = new HashSet<OutFurniture>();//�������۵�����
	
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
	public Set<OutFurniture> getOutFurniture() {
		return outFurniture;
	}
	public void setOutFurniture(Set<OutFurniture> outFurniture) {
		this.outFurniture = outFurniture;
	}
	
	
}
