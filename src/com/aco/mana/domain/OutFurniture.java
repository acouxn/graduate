package com.aco.mana.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 销售单的bean
 * @author Administrator
 *
 */

public class OutFurniture {
	private Integer out_fid;//销售单id
	private String out_no;//销售单号
	private Date out_time;//销售时间
	private String oremark;//销售单备注
	private String status;//状态（完成or未完成）
	
	private Client client;
	public Set<OutFurnitureDetail> outFurnitureDetail = new HashSet<OutFurnitureDetail>();//所属销售详情单
	
	public Integer getOut_fid() {
		return out_fid;
	}
	public void setOut_fid(Integer out_fid) {
		this.out_fid = out_fid;
	}
	public String getOut_no() {
		return out_no;
	}
	public void setOut_no(String out_no) {
		this.out_no = out_no;
	}
	public Date getOut_time() {
		return out_time;
	}
	public void setOut_time(Date out_time) {
		this.out_time = out_time;
	}
	public String getOremark() {
		return oremark;
	}
	public void setOremark(String oremark) {
		this.oremark = oremark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<OutFurnitureDetail> getOutFurnitureDetail() {
		return outFurnitureDetail;
	}
	public void setOutFurnitureDetail(Set<OutFurnitureDetail> outFurnitureDetail) {
		this.outFurnitureDetail = outFurnitureDetail;
	}
	
}
