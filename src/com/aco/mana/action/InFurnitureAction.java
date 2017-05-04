package com.aco.mana.action;


import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.InFurnitureService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 进货单管理的Action类 
 * @author Administrator
 *
 */
public class InFurnitureAction extends ActionSupport implements ModelDriven<InFurniture> {
	
	//模型对象使用的对象
	private InFurniture inFurniture = new InFurniture(); 
	//注入业务层类
	private InFurnitureService inFurnitureService;
	
	public void setInFurnitureService(InFurnitureService inFurnitureService) {
		this.inFurnitureService = inFurnitureService;
	}

	@Override
	public InFurniture getModel() {
		// TODO Auto-generated method stub
		return inFurniture;
	}
	
	//接收当前页数
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * 分页查询进货单的执行方法
	 */
	public String findAll(){
		
		PageBean<InFurniture> pageBean = inFurnitureService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 保存进货单的执行方法
	 */
	public String save(){
		inFurnitureService.save(inFurniture);
		return "saveSuccess";
	}
	
	/**
	 * 编辑进货单的执行方法
	 */
	public String edit(){
		inFurniture = inFurnitureService.findById(inFurniture.getIn_fid());
		return "editSuccess";
	}
	
	/**
	 * 修改进货单的执行方法
	 */
	public String update(){
		inFurnitureService.update(inFurniture);
		return "updateSuccess";
	}
	
	/**
	 * 删除进货单的执行方法
	 */
	public String delete(){
		inFurniture = inFurnitureService.findById(inFurniture.getIn_fid());
		inFurnitureService.delete(inFurniture);
		return "deleteSuccess";

	}
}
