package com.aco.mana.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Administrator
 * �Ҿ����bean
 */
public class Furniture {
	private Integer fid;//�Ҿߵ�id
	private String fname;//�Ҿߵ�����
	private String ftype;//�Ҿߵ��ͺ�
	private String fsize;//�ҾߵĹ��
	private String fcolor;//�Ҿߵ���ɫ
	private String fbrand;//�Ҿߵ�Ʒ��
	private String fsupply;//�Ҿ߳���
	private String su_phone;//�������̵绰
	private String su_address;//�������̵�ַ
	//private Double finprice;//�ҾߵĽ�����
	//Double foutprice;//�Ҿߵ��ۼ�
	private String fexplain;//�Ҿߵ�����
	
	//����������
	//private Set<InFurniture> inFurniture = new HashSet<InFurniture>();
	public  Set<InFurnitureDetail> inFurnitureDetail = new HashSet<InFurnitureDetail>();//�������鵥����
	public  Set<OutFurnitureDetail> outFurnitureDetail = new HashSet<OutFurnitureDetail>();//�������鵥����
	
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getFsize() {
		return fsize;
	}
	public void setFsize(String fsize) {
		this.fsize = fsize;
	}
	public String getFcolor() {
		return fcolor;
	}
	public void setFcolor(String fcolor) {
		this.fcolor = fcolor;
	}
	public String getFbrand() {
		return fbrand;
	}
	public void setFbrand(String fbrand) {
		this.fbrand = fbrand;
	}
	public String getFsupply() {
		return fsupply;
	}
	public void setFsupply(String fsupply) {
		this.fsupply = fsupply;
	}
	public String getSu_phone() {
		return su_phone;
	}
	public void setSu_phone(String su_phone) {
		this.su_phone = su_phone;
	}
	public String getSu_address() {
		return su_address;
	}
	public void setSu_address(String su_address) {
		this.su_address = su_address;
	}

	public String getFexplain() {
		return fexplain;
	}
	public void setFexplain(String fexplain) {
		this.fexplain = fexplain;
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
