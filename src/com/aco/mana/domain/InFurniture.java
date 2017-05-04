package com.aco.mana.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 进货单的bean
 * @author Administrator
 *
 */
public class InFurniture {
	private Integer in_fid;//进货单id
	private String in_no;//进货单号
	private Date in_time;//进货时间
	private String iremark;//进货单备注
	
	public  Set<InFurnitureDetail> inFurnitureDetail = new HashSet<InFurnitureDetail>();//所属订单详情表

	public Integer getIn_fid() {
		return in_fid;
	}

	public void setIn_fid(Integer in_fid) {
		this.in_fid = in_fid;
	}

	public String getIn_no() {
		return in_no;
	}

	public void setIn_no(String in_no) {
		this.in_no = in_no;
	}

	public Date getIn_time() {
		return in_time;
	}

	public void setIn_time(Date in_time) {
		this.in_time = in_time;
	}

	public String getIremark() {
		return iremark;
	}

	public void setIremark(String iremark) {
		this.iremark = iremark;
	}

	public Set<InFurnitureDetail> getInFurnitureDetail() {
		return inFurnitureDetail;
	}

	public void setInFurnitureDetail(Set<InFurnitureDetail> inFurnitureDetail) {
		this.inFurnitureDetail = inFurnitureDetail;
	}
	
	
}
