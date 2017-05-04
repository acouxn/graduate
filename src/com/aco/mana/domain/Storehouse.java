package com.aco.mana.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 仓库类的Bean
 * @author Administrator
 *
 */
public class Storehouse {
	private Integer sid;//仓库id
	private String sname;//仓库名称
	private String saddress;//仓库地址
	
	public  Set<InFurnitureDetail> inFurnitureDetail = new HashSet<InFurnitureDetail>();//进货详情单集合
	public  Set<OutFurnitureDetail> outFurnitureDetail = new HashSet<OutFurnitureDetail>();//销售详情单集合
	
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
