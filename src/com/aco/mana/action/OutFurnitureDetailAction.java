package com.aco.mana.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.aco.mana.domain.Furniture;
import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.InFurnitureDetail;
import com.aco.mana.domain.OutFurniture;
import com.aco.mana.domain.OutFurnitureDetail;
import com.aco.mana.domain.PageBean;
import com.aco.mana.domain.Storehouse;
import com.aco.mana.service.ClientService;
import com.aco.mana.service.FurnitureService;
import com.aco.mana.service.InFurnitureDetailService;
import com.aco.mana.service.OutFurnitureDetailService;
import com.aco.mana.service.InFurnitureService;
import com.aco.mana.service.OutFurnitureService;
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
public class OutFurnitureDetailAction extends ActionSupport implements
		ModelDriven<OutFurnitureDetail>{

	// ģ�Ͷ���ʹ�õĶ���
	OutFurnitureDetail outFurnitureDetail = new OutFurnitureDetail();
	// ע��ҵ�����
	private OutFurnitureDetailService outFurnitureDetailService;
	private OutFurnitureService outFurnitureService;
	private FurnitureService furnitureService;
	private StorehouseService storehouseService;
	private InFurnitureDetailService inFurnitureDetailService;


	public void setOutFurnitureDetailService(
			OutFurnitureDetailService outFurnitureDetailService) {
		this.outFurnitureDetailService = outFurnitureDetailService;
	}

	public void setOutFurnitureService(OutFurnitureService outFurnitureService) {
		this.outFurnitureService = outFurnitureService;
	}

	public void setFurnitureService(FurnitureService furnitureService) {
		this.furnitureService = furnitureService;
	}

	public void setStorehouseService(StorehouseService storehouseService) {
		this.storehouseService = storehouseService;
	}
	
	public void setInFurnitureDetailService(
			InFurnitureDetailService inFurnitureDetailService) {
		this.inFurnitureDetailService = inFurnitureDetailService;
	}

	@Override
	public OutFurnitureDetail getModel() {
		// TODO Auto-generated method stub
		return outFurnitureDetail;
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

		PageBean<OutFurnitureDetail> pageBean = outFurnitureDetailService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		
		//��ѯ���мҾ�
		//List<Furniture> flist = furnitureService.findAllByInid(inFurniture);
		//System.out.println("�����Ҿ�����"+flist.size());
		//ActionContext.getContext().getValueStack().set("flist", flist);
		return "findAll";
	}
	
	
	private String out_fdid;//����id


	public String getOut_fdid() {
		return out_fdid;
	}

	public void setOut_fdid(String out_fdid) {
		this.out_fdid = out_fdid;
	}

	/**
	 * �������۵�id��ѯ�����굥��ִ�з���
	 */
	public String findAllByOutfid(){
	    out_fdid = ServletActionContext.getRequest().getParameter("out_fdid");
	    ActionContext.getContext().getSession().put("out_fdid", out_fdid);
		//System.out.println("in_fidin_fidin_fidin_fid��ֵ:"+out_fid);
		List<OutFurnitureDetail> outflist = outFurnitureDetailService.findAllByOutfid(out_fdid);
		ActionContext.getContext().getValueStack().set("outflist",outflist);
		return "findAllByOutfid";
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
		//System.out.println("SnameSnameSnameSnameSname"+sname);
	    ActionContext.getContext().getSession().put("sname", sname);
		List<OutFurnitureDetail> list = outFurnitureDetailService.findAllBySid(sid);
		ActionContext.getContext().getValueStack().set("list", list);
		return "findAllBySid";
	}
	
	
	/**
	 * ��ת��������鵥ҳ���ִ�з���
	 */
	public String saveUI(){
		out_fdid = ServletActionContext.getRequest().getParameter("out_fid");
	    ActionContext.getContext().getSession().put("out_fid", out_fdid);
		//��ѯ���п��
		List<InFurnitureDetail> list = inFurnitureDetailService.findAll();
		//��ѯ�������ۻ���
		List<OutFurniture> outflist = outFurnitureService.findAll();

		ActionContext.getContext().getValueStack().set("list", list);
		ActionContext.getContext().getValueStack().set("outflist", outflist);
		//outFurnitureDetail = outFurnitureDetailService.findById(outFurnitureDetail.getIn_fdid());
		return "saveUI";
	}
	
	/**
	 * �����������鵥��ִ�з���
	 */
	public String save() {
		out_fdid = ServletActionContext.getRequest().getParameter("out_fdid");
	    ActionContext.getContext().getSession().put("out_fdid", out_fdid);
	    String fid = ServletActionContext.getRequest().getParameter("furniture.fid");//��ȡ�Ҿ�id��ֵ
	    String num = ServletActionContext.getRequest().getParameter("out_fdnum");//��ȡ�Ҿ�����
	    String sid = ServletActionContext.getRequest().getParameter("storehouse.sid");//��ȡ�Ҿߴ�ŵĲֿ�
	    String flag = ServletActionContext.getRequest().getParameter("flag");//��ȡ�Ҿ��Ƿ��˻���״̬
	  /*
	    try {
			flag = new String(flag.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	    //System.out.println("flag��ֵ"+flag+"-----fid��ֵ"+fid+"------����"+num+"------sid��ֵ"+sid);
	    if(flag.equals("��")){
	    	InFurnitureDetail inFurnitureDetail = inFurnitureDetailService.findBySidAndFid(sid,fid);
	 	    int b = Integer.parseInt(num);
	 	    int temp = inFurnitureDetail.getIn_fdnum();
	 	    inFurnitureDetail.setIn_fdnum(temp-b);
	 	    inFurnitureDetailService.update(inFurnitureDetail);
	    }  
		outFurnitureDetailService.save(outFurnitureDetail);
		return "saveSuccess";
	}

	/**
	 * �༭�������鵥��ִ�з���
	 */
	public String edit() {
		out_fdid = ServletActionContext.getRequest().getParameter("out_fdid");
	    ActionContext.getContext().getSession().put("out_fdid", out_fdid);
		//��ѯ���мҾ�
		List<Furniture> flist = furnitureService.findAll();
		//��ѯ�������ۻ���
		List<OutFurniture> outflist = outFurnitureService.findAll();
		//��ѯ���вֿ�
		List<Storehouse> slist = storehouseService.findAll();
	
		ActionContext.getContext().getValueStack().set("flist", flist);
		ActionContext.getContext().getValueStack().set("outflist", outflist);
		ActionContext.getContext().getValueStack().set("slist", slist);
		outFurnitureDetail = outFurnitureDetailService.findById(outFurnitureDetail.getOut_fdid());
		System.out.println("fffff"+outFurnitureDetail.getOutFurniture().getOut_fid());
		return "editSuccess";
	}

	/**
	 * �޸��������鵥��ִ�з���
	 */
	public String update() {
		out_fdid = ServletActionContext.getRequest().getParameter("out_fdid");
	    ActionContext.getContext().getSession().put("out_fdid", out_fdid);
	    String fid = ServletActionContext.getRequest().getParameter("furniture.fid");//��ȡ�Ҿ�id��ֵ
	    String exist_num = ServletActionContext.getRequest().getParameter("exist_num");//��ȡ�Ҿ�����
	    String num = ServletActionContext.getRequest().getParameter("out_fdnum");//��ȡ�޸ĺ�ļҾ�����
	    String sid = ServletActionContext.getRequest().getParameter("storehouse.sid");//��ȡ�Ҿߴ�ŵĲֿ�
	    String flag = ServletActionContext.getRequest().getParameter("flag");//��ȡ�޸ĺ�Ҿߵ��˻�״̬
	    String flag1 = ServletActionContext.getRequest().getParameter("flag1");//��ȡ�Ѵ��ڵ��˻�״̬
	    System.out.println("flag��ֵ"+flag1+"�޸ĺ��flag��ֵ"+flag+"-----fid��ֵ"+fid+"--------��������"+exist_num+"------����"+num+"------sid��ֵ"+sid);
	   
	    InFurnitureDetail inFurnitureDetail = inFurnitureDetailService.findBySidAndFid(sid,fid);//���ݲֿ�id�ͼҾ�id��ѯ���
	    
	    int a = Integer.parseInt(exist_num);//ǿת��õļҾ�����
	    int b = Integer.parseInt(num);//ǿת�޸ĺ�ļҾ�����
	    if(a>b && flag.equals("��") && flag1.equals("��")){//���Ҿ����������Ҳ��˻�,��Ӧ�������
	    	int c = a - b;
	    	int temp = inFurnitureDetail.getIn_fdnum();//��ÿ������
	    	inFurnitureDetail.setIn_fdnum(temp+c);
	    	inFurnitureDetailService.update(inFurnitureDetail);
	    }else if(a<b && flag.equals("��") && flag1.equals("��")){//���Ҿ����������Ҳ��˻������Ӧ������
	    	int c = b - a;
	    	int temp = inFurnitureDetail.getIn_fdnum();//��ÿ������
	    	inFurnitureDetail.setIn_fdnum(temp-c);
	    	inFurnitureDetailService.update(inFurnitureDetail);
	    }else if(flag.equals("��") && flag1.equals("��")){
	    	int temp = inFurnitureDetail.getIn_fdnum();//��ÿ������
	    	inFurnitureDetail.setIn_fdnum(temp-b);
	    	inFurnitureDetailService.update(inFurnitureDetail);
	    }else if(flag.equals("��") && flag1.equals("��")){
	    	int temp = inFurnitureDetail.getIn_fdnum();//��ÿ������
	    	inFurnitureDetail.setIn_fdnum(temp+b);
	    	inFurnitureDetailService.update(inFurnitureDetail);
	    }
	    //outFurnitureDetail = outFurnitureDetailService.findById(outFurnitureDetail.getIn_fdid());
		outFurnitureDetailService.update(outFurnitureDetail);
		return "updateSuccess";
	}

	/**
	 * ɾ���������鵥��ִ�з���
	 */
	public String delete() {
		String fid = ServletActionContext.getRequest().getParameter("furniture.fid");//��ȡ�Ҿ�id��ֵ
		String num = ServletActionContext.getRequest().getParameter("out_fdnum");//��ȡ�޸ĺ�ļҾ�����
		String sid = ServletActionContext.getRequest().getParameter("storehouse.sid");//��ȡ�Ҿߴ�ŵĲֿ�id
		String flag = ServletActionContext.getRequest().getParameter("flag");//��ȡ�Ҿߵ��˻�״̬
		try {
			flag = new String(flag.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int b = Integer.parseInt(num);//ǿת�Ҿ�����
		 System.out.println("flag��ֵ"+flag+"-----fid��ֵ"+fid+"------����"+num+"------sid��ֵ"+sid);
		InFurnitureDetail inFurnitureDetail = inFurnitureDetailService.findBySidAndFid(sid,fid);//���ݲֿ�id�ͼҾ�id��ѯ���
		if(flag.equals("��")){
			int temp = inFurnitureDetail.getIn_fdnum();//��ÿ������
	    	inFurnitureDetail.setIn_fdnum(temp+b);
	    	inFurnitureDetailService.update(inFurnitureDetail);
		}
		outFurnitureDetail = outFurnitureDetailService.findById(outFurnitureDetail.getOut_fdid());
		outFurnitureDetailService.delete(outFurnitureDetail);
		return "deleteSuccess";

	}

}
