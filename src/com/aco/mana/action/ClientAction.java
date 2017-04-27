package com.aco.mana.action;

import com.aco.mana.domain.Client;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.ClientService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户管理的Action类
 * 
 * @author Administrator
 * 
 */
public class ClientAction extends ActionSupport implements ModelDriven<Client> {

	// 模型对象使用的对象
	Client client = new Client();
	// 注入业务层类
	ClientService clientService;

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public Client getModel() {
		// TODO Auto-generated method stub
		return client;
	}

	// 接收当前页数
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * 分页查询客户信息的执行方法
	 */
	public String findAll() {

		PageBean<Client> pageBean = clientService.findByPage(currPage);
		// 将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	/**
	 * 保存客户信息的执行方法
	 */
	public String save() {
		clientService.save(client);
		return "saveSuccess";
	}

	/**
	 * 编辑客户信息的执行方法
	 */
	public String edit() {
		client = clientService.findById(client.getCid());
		return "editSuccess";
	}

	/**
	 * 修改客户信息的执行方法
	 */
	public String update() {
		clientService.update(client);
		return "updateSuccess";
	}

	/**
	 * 删除客户信息的执行方法
	 */
	public String delete() {
		client = clientService.findById(client.getCid());
		clientService.delete(client);
		return "deleteSuccess";

	}
}
