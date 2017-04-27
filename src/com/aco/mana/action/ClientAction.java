package com.aco.mana.action;

import com.aco.mana.domain.Client;
import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.ClientService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �ͻ������Action��
 * 
 * @author Administrator
 * 
 */
public class ClientAction extends ActionSupport implements ModelDriven<Client> {

	// ģ�Ͷ���ʹ�õĶ���
	Client client = new Client();
	// ע��ҵ�����
	ClientService clientService;

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public Client getModel() {
		// TODO Auto-generated method stub
		return client;
	}

	// ���յ�ǰҳ��
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * ��ҳ��ѯ�ͻ���Ϣ��ִ�з���
	 */
	public String findAll() {

		PageBean<Client> pageBean = clientService.findByPage(currPage);
		// ��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	/**
	 * ����ͻ���Ϣ��ִ�з���
	 */
	public String save() {
		clientService.save(client);
		return "saveSuccess";
	}

	/**
	 * �༭�ͻ���Ϣ��ִ�з���
	 */
	public String edit() {
		client = clientService.findById(client.getCid());
		return "editSuccess";
	}

	/**
	 * �޸Ŀͻ���Ϣ��ִ�з���
	 */
	public String update() {
		clientService.update(client);
		return "updateSuccess";
	}

	/**
	 * ɾ���ͻ���Ϣ��ִ�з���
	 */
	public String delete() {
		client = clientService.findById(client.getCid());
		clientService.delete(client);
		return "deleteSuccess";

	}
}
