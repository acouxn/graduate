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
 * ���۵������Action�� 
 * @author Administrator
 *
 */
public class OutFurnitureAction extends ActionSupport implements ModelDriven<OutFurniture> {
	
	//ģ�Ͷ���ʹ�õĶ���
	private OutFurniture outFurniture = new OutFurniture(); 
	//ע��ҵ�����
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
	
	//���յ�ǰҳ��
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * ��ҳ��ѯ���۵���ִ�з���
	 */
	public String findAll(){
		
		PageBean<OutFurniture> pageBean = outFurnitureService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * ��ת��������۵�ҳ���ִ�з���
	 */
	public String saveOutFurniture(){
		List<Client> clist = clientService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "saveOutFurniture";
	}
	
	/**
	 * �������۵���ִ�з���
	 */
	public String save(){
		outFurnitureService.save(outFurniture);
		return "saveSuccess";
	}
	
	/**
	 * �༭���۵���ִ�з���
	 */
	public String edit(){
		List<Client> clist = clientService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		outFurniture = outFurnitureService.findById(outFurniture.getOut_fid());
		return "editSuccess";
	}
	
	/**
	 * �޸����۵���ִ�з���
	 */
	public String update(){
		outFurnitureService.update(outFurniture);
		return "updateSuccess";
	}
	
	/**
	 * ɾ�����۵���ִ�з���
	 */
	public String delete(){
		outFurniture = outFurnitureService.findById(outFurniture.getOut_fid());
		outFurnitureService.delete(outFurniture);
		return "deleteSuccess";

	}
}
