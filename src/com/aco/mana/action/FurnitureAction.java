package com.aco.mana.action;


import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.service.FurnitureService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��������Action�� 
 * @author Administrator
 *
 */
public class FurnitureAction extends ActionSupport implements ModelDriven<Furniture> {
	
	//ģ�Ͷ���ʹ�õĶ���
	private Furniture furniture = new Furniture(); 
	//ע��ҵ�����
	private FurnitureService furnitureService;
	
	public void setFurnitureService(FurnitureService furnitureService) {
		this.furnitureService = furnitureService;
	}

	@Override
	public Furniture getModel() {
		// TODO Auto-generated method stub
		return furniture;
	}
	
	//���յ�ǰҳ��
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * ��ҳ��ѯ�����ִ�з���
	 */
	public String findAll(){
		
		PageBean<Furniture> pageBean = furnitureService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * ��������ִ�з���
	 */
	public String save(){
		furnitureService.save(furniture);
		return "saveSuccess";
	}
	
	/**
	 * �༭�����ִ�з���
	 */
	public String edit(){
		furniture = furnitureService.findById(furniture.getFid());
		return "editSuccess";
	}
	
	/**
	 * �޸Ļ����ִ�з���
	 */
	public String update(){
		furnitureService.update(furniture);
		return "updateSuccess";
	}
	
	/**
	 * ɾ�������ִ�з���
	 */
	public String delete(){
		furniture = furnitureService.findById(furniture.getFid());
		furnitureService.delete(furniture);
		return "deleteSuccess";

	}
}
