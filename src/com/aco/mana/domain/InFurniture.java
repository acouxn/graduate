package com.aco.mana.domain;

import java.util.Date;
import java.util.HashMap;
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
	private int num;//�Ҿ�����
	private Double in_fprice;//�����۸�
	private Double in_transprice;//�˷�
	private Integer sid;//�ֿ�id
	private Date in_time;//����ʱ��
	private String iremark;//��������ע

	//�Ҿ߼���
	public Set<Furniture> furniture = new HashSet<Furniture>();
	
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

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Double getIn_fprice() {
		return in_fprice;
	}
	public void setIn_fprice(Double in_fprice) {
		this.in_fprice = in_fprice;
	}
	public Double getIn_transprice() {
		return in_transprice;
	}
	public void setIn_transprice(Double in_transprice) {
		this.in_transprice = in_transprice;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
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
	public Set<Furniture> getFurniture() {
		return furniture;
	}
	public void setFurniture(Set<Furniture> furniture) {
		this.furniture = furniture;
	}
	
	
}
