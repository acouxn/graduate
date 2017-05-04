package com.aco.mana.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Administrator
 * 家具类的bean
 */
public class Furniture {
	private Integer fid;//家具的id
	private String fname;//家具的名称
	private String ftype;//家具的型号
	private String fsize;//家具的规格
	private String fcolor;//家具的颜色
	private String fbrand;//家具的品牌
	private String fsupply;//家具厂商
	private String su_phone;//进货厂商电话
	private String su_address;//进货厂商地址
	//private Double finprice;//家具的进货价
	//Double foutprice;//家具的售价
	private String fexplain;//家具的描述
	
	//进货单集合
	//private Set<InFurniture> inFurniture = new HashSet<InFurniture>();
	public  Set<InFurnitureDetail> inFurnitureDetail = new HashSet<InFurnitureDetail>();//进货详情单集合
	public  Set<OutFurnitureDetail> outFurnitureDetail = new HashSet<OutFurnitureDetail>();//销售详情单集合
	
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
