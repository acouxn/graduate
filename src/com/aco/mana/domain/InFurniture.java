package com.aco.mana.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ��������bean
 * @author Administrator
 *
 */
public class InFurniture {
	private Integer in_fid;//������id
	private String in_no;//��������
	private Date in_time;//����ʱ��
	private String iremark;//��������ע
	
	public  Set<InFurnitureDetail> inFurnitureDetail = new HashSet<InFurnitureDetail>();//�������������

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
