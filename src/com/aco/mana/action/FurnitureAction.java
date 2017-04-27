package com.aco.mana.action;


import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.FurnitureService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 货物管理的Action类 
 * @author Administrator
 *
 */
public class FurnitureAction extends ActionSupport implements ModelDriven<Furniture> {
	
	//模型对象使用的对象
	private Furniture furniture = new Furniture(); 
	//注入业务层类
	private FurnitureService furnitureService;
	
	public void setFurnitureService(FurnitureService furnitureService) {
		this.furnitureService = furnitureService;
	}

	@Override
	public Furniture getModel() {
		// TODO Auto-generated method stub
		return furniture;
	}
	
	//接收当前页数
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * 分页查询货物的执行方法
	 */
	public String findAll(){
		
		PageBean<Furniture> pageBean = furnitureService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 保存货物的执行方法
	 */
	public String save(){
		furnitureService.save(furniture);
		return "saveSuccess";
	}
	
	/**
	 * 编辑货物的执行方法
	 */
	public String edit(){
		furniture = furnitureService.findById(furniture.getFid());
		return "editSuccess";
	}
	
	/**
	 * 修改货物的执行方法
	 */
	public String update(){
		furnitureService.update(furniture);
		return "updateSuccess";
	}
	
	/**
	 * 删除货物的执行方法
	 */
	public String delete(){
		furniture = furnitureService.findById(furniture.getFid());
		furnitureService.delete(furniture);
		return "deleteSuccess";

	}
}
