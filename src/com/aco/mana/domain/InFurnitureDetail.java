package com.aco.mana.domain;

/**
 * �����������bean
 * @author Administrator
 *
 */
public class InFurnitureDetail {
	private Integer in_fdid;//�����굥��id
	//private Integer in_fdinfid;//��������id
	//private Integer in_fdfid;//�Ҿߵ�id
	private Integer in_fdnum;//����������
	//private Integer in_fdsid;//��ŵĲֿ�id
	private Double in_fprice;//��������
	private Double in_ftransprice;//�˷�
	
	public Furniture furniture;//�Ҿ߼���

	private InFurniture inFurniture; //���鶩����������
	
	private Storehouse storehouse;//�����ֿ�
	public Integer getIn_fdid() {
		return in_fdid;
	}
	public void setIn_fdid(Integer in_fdid) {
		this.in_fdid = in_fdid;
	}

	public Integer getIn_fdnum() {
		return in_fdnum;
	}
	public void setIn_fdnum(Integer in_fdnum) {
		this.in_fdnum = in_fdnum;
	}
	

	public Double getIn_fprice() {
		return in_fprice;
	}
	public void setIn_fprice(Double in_fprice) {
		this.in_fprice = in_fprice;
	}
	public Double getIn_ftransprice() {
		return in_ftransprice;
	}
	public void setIn_ftransprice(Double in_ftransprice) {
		this.in_ftransprice = in_ftransprice;
	}


	public Furniture getFurniture() {
		return furniture;
	}
	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}
	public InFurniture getInFurniture() {
		return inFurniture;
	}
	public void setInFurniture(InFurniture inFurniture) {
		this.inFurniture = inFurniture;
	}
	public Storehouse getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(Storehouse storehouse) {
		this.storehouse = storehouse;
	}
	
	
}
