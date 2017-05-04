package com.aco.mana.domain;

/**
 * 进货单详情的bean
 * @author Administrator
 *
 */
public class InFurnitureDetail {
	private Integer in_fdid;//进货详单的id
	//private Integer in_fdinfid;//进货单的id
	//private Integer in_fdfid;//家具的id
	private Integer in_fdnum;//进货的数量
	//private Integer in_fdsid;//存放的仓库id
	private Double in_fprice;//进货单价
	private Double in_ftransprice;//运费
	
	public Furniture furniture;//家具集合

	private InFurniture inFurniture; //详情订单所属订单
	
	private Storehouse storehouse;//所属仓库
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
