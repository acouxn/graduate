package com.aco.mana.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * �ֿ����Bean
 * @author Administrator
 *
 */
public class Storehouse {
	private Integer sid;//�ֿ�id
	private String sname;//�ֿ�����
	private String saddress;//�ֿ��ַ
	
	public  Set<InFurnitureDetail> inFurnitureDetail = new HashSet<InFurnitureDetail>();//�������鵥����
	public  Set<OutFurnitureDetail> outFurnitureDetail = new HashSet<OutFurnitureDetail>();//�������鵥����
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Set<InFurnitureDetail> getInFurnitureDetail() {
		return inFurnitureDetail;
	}
	public void setInFurnitureDetail(Set<InFurnitureDetail> inFurnitureDetail) {
		this.inFurnitureDetail = inFurnitureDetail;
	}
	public Set<OutFurnitureDetail> getOutFurnitureDetail() {
		return outFurnitureDetail;
	}
	public void setOutFurnitureDetail(Set<OutFurnitureDetail> outFurnitureDetail) {
		this.outFurnitureDetail = outFurnitureDetail;
	}

	
}
