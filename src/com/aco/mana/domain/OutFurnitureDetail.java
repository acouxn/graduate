package com.aco.mana.domain;

/**
 * 销售详情单的bean
 * @author Administrator
 *
 */
public class OutFurnitureDetail {
	private Integer out_fdid;//销售详情单id
	private Integer out_fdnum;//销售家具的数量
	private Double out_fprice;//销售家具的单价
	private String flag;//销售详情单对应家具的状态(正常or退货)
	
	public Furniture furniture;//家具集合
	private OutFurniture outFurniture;//销售详情单所属的销售单
	private Storehouse storehouse;//所属仓库
	public Integer getOut_fdid() {
		return out_fdid;
	}
	public void setOut_fdid(Integer out_fdid) {
		this.out_fdid = out_fdid;
	}
	public Integer getOut_fdnum() {
		return out_fdnum;
	}
	public void setOut_fdnum(Integer out_fdnum) {
		this.out_fdnum = out_fdnum;
	}
	public Double getOut_fprice() {
		return out_fprice;
	}
	public void setOut_fprice(Double out_fprice) {
		this.out_fprice = out_fprice;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Furniture getFurniture() {
		return furniture;
	}
	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

	public OutFurniture getOutFurniture() {
		return outFurniture;
	}
	public void setOutFurniture(OutFurniture outFurniture) {
		this.outFurniture = outFurniture;
	}
	public Storehouse getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(Storehouse storehouse) {
		this.storehouse = storehouse;
	}
	
}
