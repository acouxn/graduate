package com.aco.mana.action;

import java.util.List;

import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;
import com.aco.mana.domain.Storehouse;
import com.aco.mana.service.FurnitureService;
import com.aco.mana.service.InFurnitureService;
import com.aco.mana.service.StorehouseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ���������Action��
 * 
 * @author Administrator
 * 
 */
public class InFurnitureAction extends ActionSupport implements
		ModelDriven<InFurniture> {

	// ģ�Ͷ���ʹ�õĶ���
	InFurniture inFurniture = new InFurniture();
	// ע��ҵ�����
	private InFurnitureService inFurnitureService;
	private FurnitureService furnitureService;
	private StorehouseService storehouseService;

	public void setInFurnitureService(InFurnitureService inFurnitureService) {
		this.inFurnitureService = inFurnitureService;
	}

	public void setFurnitureService(FurnitureService furnitureService) {
		this.furnitureService = furnitureService;
	}

	public void setStorehouseService(StorehouseService storehouseService) {
		this.storehouseService = storehouseService;
	}

	@Override
	public InFurniture getModel() {
		// TODO Auto-generated method stub
		return inFurniture;
	}

	// ���յ�ǰҳ��
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * ��ҳ��ѯ��������ִ�з���
	 */
	public String findAll() {

		PageBean<InFurniture> pageBean = inFurnitureService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		
		//��ѯ���мҾ�
		//List<Furniture> flist = furnitureService.findAllByInid(inFurniture);
		//System.out.println("�����Ҿ�����"+flist.size());
		//ActionContext.getContext().getValueStack().set("flist", flist);
		return "findAll";
	}
	
	/**
	 * ��ѯ�����������ִ�з���
	 */
	public String findFurniture(){
		//��ѯ���мҾ�
		List<Furniture> flist = furnitureService.findAllByInid(inFurniture);
		System.out.println("�����Ҿ�����"+flist.size());

		ActionContext.getContext().getValueStack().set("flist", flist);
		return "findFurniture";
	}
	
	/**
	 * �����������ִ�з���
	 */
	public String save() {
		//��ѯ���мҾ�
		List<Furniture> flist = furnitureService.findAll();
		//��ѯ���вֿ�
		List<Storehouse> slist = storehouseService.findAll();
		ActionContext.getContext().getValueStack().set("flist", flist);
		ActionContext.getContext().getValueStack().set("slist", slist);
		System.out.println("���Ա��"+flist.size());
		System.out.println("���Ա��"+slist.size());
		inFurnitureService.save(inFurniture);
		return "saveSuccess";
	}

	/**
	 * �༭��������ִ�з���
	 */
	public String edit() {
		inFurniture = inFurnitureService.findById(inFurniture.getIn_fid());
		return "editSuccess";
	}

	/**
	 * �޸Ľ�������ִ�з���
	 */
	public String update() {
		inFurnitureService.update(inFurniture);
		return "updateSuccess";
	}

	/**
	 * ɾ����������ִ�з���
	 */
	public String delete() {
		inFurniture = inFurnitureService.findById(inFurniture.getIn_fid());
		inFurnitureService.delete(inFurniture);
		return "deleteSuccess";

	}

}
