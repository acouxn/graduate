package com.aco.mana.action;

import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.domain.Storehouse;
import com.aco.mana.service.StorehouseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 仓库管理的Action类
 * @author Administrator
 *
 */
public class StorehouseAction extends ActionSupport implements ModelDriven<Storehouse>{
	
	//模型对象使用的对象
	private Storehouse storehouse = new Storehouse();
	//注入业务层类
	private StorehouseService storehouseService;

	public void setStorehouseService(StorehouseService storehouseService) {
		this.storehouseService = storehouseService;
	}

	@Override
	public Storehouse getModel() {
		// TODO Auto-generated method stub
		return storehouse;
	}
	
	//接收当前页数
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * 分页查询仓库的执行方法
	 */
	public String findAll(){
		
		PageBean<Storehouse> pageBean = storehouseService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	

	/**
	 * 保存仓库的执行方法
	 */
	public String save(){
		storehouseService.save(storehouse);
		return "saveSuccess";
	}
	
	/**
	 * 编辑仓库的执行方法
	 */
	public String edit(){
		storehouse = storehouseService.findById(storehouse.getSid());
		return "editSuccess";
	}
	
	/**
	 * 修改仓库的执行方法
	 */
	public String update(){
		storehouseService.update(storehouse);
		return "updateSuccess";
	}
	
	/**
	 * 删除仓库的执行方法
	 */
	public String delete(){
		storehouse = storehouseService.findById(storehouse.getSid());
		storehouseService.delete(storehouse);
		return "deleteSuccess";

	}
}
