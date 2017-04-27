package com.aco.mana.action;

import java.util.List;

import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.domain.Storehouse;
import com.aco.mana.service.FurnitureService;
import com.aco.mana.service.InFurnitureService;
import com.aco.mana.service.StorehouseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 进货管理的Action类
 * 
 * @author Administrator
 * 
 */
public class InFurnitureAction extends ActionSupport implements
		ModelDriven<InFurniture> {

	// 模型对象使用的对象
	InFurniture inFurniture = new InFurniture();
	// 注入业务层类
	private InFurnitureService inFurnitureService;
	private FurnitureService furnitureService;
	private StorehouseService storehouseService;

	public void setInFurnitureService(InFurnitureService inFurnitureService) {
		this.inFurnitureService = inFurnitureService;
	}

	public void setFurnitureService(FurnitureService furnitureService) {
		this.furnitureService = furnitureService;
	}

	public void setStorehouseService(StorehouseService storehouseService) {
		this.storehouseService = storehouseService;
	}

	@Override
	public InFurniture getModel() {
		// TODO Auto-generated method stub
		return inFurniture;
	}

	// 接收当前页数
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * 分页查询进货单的执行方法
	 */
	public String findAll() {

		PageBean<InFurniture> pageBean = inFurnitureService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		
		//查询所有家具
		//List<Furniture> flist = furnitureService.findAllByInid(inFurniture);
		//System.out.println("订单家具数量"+flist.size());
		//ActionContext.getContext().getValueStack().set("flist", flist);
		return "findAll";
	}
	
	/**
	 * 查询进货单详情的执行方法
	 */
	public String findFurniture(){
		//查询所有家具
		List<Furniture> flist = furnitureService.findAllByInid(inFurniture);
		System.out.println("订单家具数量"+flist.size());

		ActionContext.getContext().getValueStack().set("flist", flist);
		return "findFurniture";
	}
	
	/**
	 * 保存进货单的执行方法
	 */
	public String save() {
		//查询所有家具
		List<Furniture> flist = furnitureService.findAll();
		//查询所有仓库
		List<Storehouse> slist = storehouseService.findAll();
		ActionContext.getContext().getValueStack().set("flist", flist);
		ActionContext.getContext().getValueStack().set("slist", slist);
		System.out.println("添加员工"+flist.size());
		System.out.println("添加员工"+slist.size());
		inFurnitureService.save(inFurniture);
		return "saveSuccess";
	}

	/**
	 * 编辑进货单的执行方法
	 */
	public String edit() {
		inFurniture = inFurnitureService.findById(inFurniture.getIn_fid());
		return "editSuccess";
	}

	/**
	 * 修改进货单的执行方法
	 */
	public String update() {
		inFurnitureService.update(inFurniture);
		return "updateSuccess";
	}

	/**
	 * 删除进货单的执行方法
	 */
	public String delete() {
		inFurniture = inFurnitureService.findById(inFurniture.getIn_fid());
		inFurnitureService.delete(inFurniture);
		return "deleteSuccess";

	}

}
