package com.aco.mana.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.InFurnitureDetail;
import com.aco.mana.domain.PageBean;
import com.aco.mana.domain.Storehouse;
import com.aco.mana.service.FurnitureService;
import com.aco.mana.service.InFurnitureDetailService;
import com.aco.mana.service.InFurnitureService;
import com.aco.mana.service.StorehouseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ������������Action��
 * 
 * @author Administrator
 * 
 */
public class InFurnitureDetailAction extends ActionSupport implements
		ModelDriven<InFurnitureDetail>{

	// ģ�Ͷ���ʹ�õĶ���
	InFurnitureDetail inFurnitureDetail = new InFurnitureDetail();
	// ע��ҵ�����
	private InFurnitureDetailService inFurnitureDetailService;
	private InFurnitureService inFurnitureService;
	private FurnitureService furnitureService;
	private StorehouseService storehouseService;

	
	public void setInFurnitureDetailService(
			InFurnitureDetailService inFurnitureDetailService) {
		this.inFurnitureDetailService = inFurnitureDetailService;
	}

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
	public InFurnitureDetail getModel() {
		// TODO Auto-generated method stub
		return inFurnitureDetail;
	}

	// ���յ�ǰҳ��
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	

	/**
	 * ��ҳ��ѯ�������鵥��ִ�з���
	 */
	public String findAll() {

		PageBean<InFurnitureDetail> pageBean = inFurnitureDetailService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		
		//��ѯ���мҾ�
		//List<Furniture> flist = furnitureService.findAllByInid(inFurniture);
		//System.out.println("�����Ҿ�����"+flist.size());
		//ActionContext.getContext().getValueStack().set("flist", flist);
		return "findAll";
	}
	
	
	private String in_fid;//����id
	public String getIn_fid() {
		return in_fid;
	}
	public void setIn_fid(String in_fid) {
		this.in_fid = in_fid;
	}
	

	/**
	 * ���ݽ�����id��ѯ�����굥��ִ�з���
	 */
	public String findAllByInfid(){
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
		System.out.println("in_fidin_fidin_fidin_fid��ֵ:"+in_fid);
		List<InFurnitureDetail> inflist = inFurnitureDetailService.findAllByInfid(in_fid);
		ActionContext.getContext().getValueStack().set("inflist",inflist);
		return "findAllByInfid";
	}
	
	/**
	 * ���ݲֿ�id��ѯ�����굥��ִ�з���
	 */
	public String findAllBySid(){
		String sid = ServletActionContext.getRequest().getParameter("sid");
		String sname = ServletActionContext.getRequest().getParameter("sname");
		try {
			sname = new String(sname.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SnameSnameSnameSnameSname"+sname);
	    ActionContext.getContext().getSession().put("sname", sname);
		List<InFurnitureDetail> list = inFurnitureDetailService.findAllBySid(sid);
		ActionContext.getContext().getValueStack().set("list", list);
		return "findAllBySid";
	}
	
	/**
	 * ��ת��������鵥ҳ���ִ�з���
	 */
	public String saveUI(){
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
		//��ѯ���мҾ�
		List<Furniture> flist = furnitureService.findAll();
		//��ѯ���н�������
		List<InFurniture> inflist = inFurnitureService.findAll();
		//��ѯ���вֿ�
		List<Storehouse> slist = storehouseService.findAll();
		ActionContext.getContext().getValueStack().set("flist", flist);
		ActionContext.getContext().getValueStack().set("inflist", inflist);
		ActionContext.getContext().getValueStack().set("slist", slist);	
		//inFurnitureDetail = inFurnitureDetailService.findById(inFurnitureDetail.getIn_fdid());
		return "saveUI";
	}
	
	/**
	 * ����������鵥��ִ�з���
	 */
	public String save() {
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
		inFurnitureDetailService.save(inFurnitureDetail);
		return "saveSuccess";
	}

	/**
	 * �༭�������鵥��ִ�з���
	 */
	public String edit() {
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
		//��ѯ���мҾ�
		List<Furniture> flist = furnitureService.findAll();
		//��ѯ���н�������
		List<InFurniture> inflist = inFurnitureService.findAll();
		//��ѯ���вֿ�
		List<Storehouse> slist = storehouseService.findAll();
	
		ActionContext.getContext().getValueStack().set("flist", flist);
		ActionContext.getContext().getValueStack().set("inflist", inflist);
		ActionContext.getContext().getValueStack().set("slist", slist);
		inFurnitureDetail = inFurnitureDetailService.findById(inFurnitureDetail.getIn_fdid());
		System.out.println("fffff"+inFurnitureDetail.getInFurniture().getIn_fid());
		return "editSuccess";
	}

	/**
	 * �޸Ľ������鵥��ִ�з���
	 */
	public String update() {
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
	    //inFurnitureDetail = inFurnitureDetailService.findById(inFurnitureDetail.getIn_fdid());
		inFurnitureDetailService.update(inFurnitureDetail);
		return "updateSuccess";
	}

	/**
	 * ɾ���������鵥��ִ�з���
	 */
	public String delete() {
		inFurnitureDetail = inFurnitureDetailService.findById(inFurnitureDetail.getIn_fdid());
		inFurnitureDetailService.delete(inFurnitureDetail);
		return "deleteSuccess";

	}

}
