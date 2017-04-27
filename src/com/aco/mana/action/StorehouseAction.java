package com.aco.mana.action;

import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.domain.Storehouse;
import com.aco.mana.service.StorehouseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �ֿ�����Action��
 * @author Administrator
 *
 */
public class StorehouseAction extends ActionSupport implements ModelDriven<Storehouse>{
	
	//ģ�Ͷ���ʹ�õĶ���
	private Storehouse storehouse = new Storehouse();
	//ע��ҵ�����
	private StorehouseService storehouseService;

	public void setStorehouseService(StorehouseService storehouseService) {
		this.storehouseService = storehouseService;
	}

	@Override
	public Storehouse getModel() {
		// TODO Auto-generated method stub
		return storehouse;
	}
	
	//���յ�ǰҳ��
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * ��ҳ��ѯ�ֿ��ִ�з���
	 */
	public String findAll(){
		
		PageBean<Storehouse> pageBean = storehouseService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	

	/**
	 * ����ֿ��ִ�з���
	 */
	public String save(){
		storehouseService.save(storehouse);
		return "saveSuccess";
	}
	
	/**
	 * �༭�ֿ��ִ�з���
	 */
	public String edit(){
		storehouse = storehouseService.findById(storehouse.getSid());
		return "editSuccess";
	}
	
	/**
	 * �޸Ĳֿ��ִ�з���
	 */
	public String update(){
		storehouseService.update(storehouse);
		return "updateSuccess";
	}
	
	/**
	 * ɾ���ֿ��ִ�з���
	 */
	public String delete(){
		storehouse = storehouseService.findById(storehouse.getSid());
		storehouseService.delete(storehouse);
		return "deleteSuccess";

	}
}
