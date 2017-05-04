package com.aco.mana.action;


import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.InFurnitureService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �����������Action�� 
 * @author Administrator
 *
 */
public class InFurnitureAction extends ActionSupport implements ModelDriven<InFurniture> {
	
	//ģ�Ͷ���ʹ�õĶ���
	private InFurniture inFurniture = new InFurniture(); 
	//ע��ҵ�����
	private InFurnitureService inFurnitureService;
	
	public void setInFurnitureService(InFurnitureService inFurnitureService) {
		this.inFurnitureService = inFurnitureService;
	}

	@Override
	public InFurniture getModel() {
		// TODO Auto-generated method stub
		return inFurniture;
	}
	
	//���յ�ǰҳ��
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * ��ҳ��ѯ��������ִ�з���
	 */
	public String findAll(){
		
		PageBean<InFurniture> pageBean = inFurnitureService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * �����������ִ�з���
	 */
	public String save(){
		inFurnitureService.save(inFurniture);
		return "saveSuccess";
	}
	
	/**
	 * �༭��������ִ�з���
	 */
	public String edit(){
		inFurniture = inFurnitureService.findById(inFurniture.getIn_fid());
		return "editSuccess";
	}
	
	/**
	 * �޸Ľ�������ִ�з���
	 */
	public String update(){
		inFurnitureService.update(inFurniture);
		return "updateSuccess";
	}
	
	/**
	 * ɾ����������ִ�з���
	 */
	public String delete(){
		inFurniture = inFurnitureService.findById(inFurniture.getIn_fid());
		inFurnitureService.delete(inFurniture);
		return "deleteSuccess";

	}
}
