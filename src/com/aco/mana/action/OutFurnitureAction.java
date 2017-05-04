package com.aco.mana.action;


import java.util.List;

import com.aco.mana.domain.Client;
import com.aco.mana.domain.OutFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.ClientService;
import com.aco.mana.service.OutFurnitureService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 销售单管理的Action类 
 * @author Administrator
 *
 */
public class OutFurnitureAction extends ActionSupport implements ModelDriven<OutFurniture> {
	
	//模型对象使用的对象
	private OutFurniture outFurniture = new OutFurniture(); 
	//注入业务层类
	private OutFurnitureService outFurnitureService;
	private ClientService clientService;
	
	public void setOutFurnitureService(OutFurnitureService outFurnitureService) {
		this.outFurnitureService = outFurnitureService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public OutFurniture getModel() {
		// TODO Auto-generated method stub
		return outFurniture;
	}
	
	//接收当前页数
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * 分页查询销售单的执行方法
	 */
	public String findAll(){
		
		PageBean<OutFurniture> pageBean = outFurnitureService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 跳转到添加销售单页面的执行方法
	 */
	public String saveOutFurniture(){
		List<Client> clist = clientService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "saveOutFurniture";
	}
	
	/**
	 * 保存销售单的执行方法
	 */
	public String save(){
		outFurnitureService.save(outFurniture);
		return "saveSuccess";
	}
	
	/**
	 * 编辑销售单的执行方法
	 */
	public String edit(){
		List<Client> clist = clientService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		outFurniture = outFurnitureService.findById(outFurniture.getOut_fid());
		return "editSuccess";
	}
	
	/**
	 * 修改销售单的执行方法
	 */
	public String update(){
		outFurnitureService.update(outFurniture);
		return "updateSuccess";
	}
	
	/**
	 * 删除销售单的执行方法
	 */
	public String delete(){
		outFurniture = outFurnitureService.findById(outFurniture.getOut_fid());
		outFurnitureService.delete(outFurniture);
		return "deleteSuccess";

	}
}
