package com.aco.mana.domain;

/**
 * �������鵥��bean
 * @author Administrator
 *
 */
public class OutFurnitureDetail {
	private Integer out_fdid;//�������鵥id
	private Integer out_fdnum;//���ۼҾߵ�����
	private Double out_fprice;//���ۼҾߵĵ���
	private String flag;//�������鵥��Ӧ�Ҿߵ�״̬(����or�˻�)
	
	public Furniture furniture;//�Ҿ߼���
	private OutFurniture outFurniture;//�������鵥���������۵�
	private Storehouse storehouse;//�����ֿ�
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
