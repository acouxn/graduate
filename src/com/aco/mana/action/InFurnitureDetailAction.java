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
 * 进货详情管理的Action类
 * 
 * @author Administrator
 * 
 */
public class InFurnitureDetailAction extends ActionSupport implements
		ModelDriven<InFurnitureDetail>{

	// 模型对象使用的对象
	InFurnitureDetail inFurnitureDetail = new InFurnitureDetail();
	// 注入业务层类
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

	// 接收当前页数
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	

	/**
	 * 分页查询进货详情单的执行方法
	 */
	public String findAll() {

		PageBean<InFurnitureDetail> pageBean = inFurnitureDetailService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		
		//查询所有家具
		//List<Furniture> flist = furnitureService.findAllByInid(inFurniture);
		//System.out.println("订单家具数量"+flist.size());
		//ActionContext.getContext().getValueStack().set("flist", flist);
		return "findAll";
	}
	
	
	private String in_fid;//订单id
	public String getIn_fid() {
		return in_fid;
	}
	public void setIn_fid(String in_fid) {
		this.in_fid = in_fid;
	}
	

	/**
	 * 根据进货单id查询进货详单的执行方法
	 */
	public String findAllByInfid(){
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
		System.out.println("in_fidin_fidin_fidin_fid的值:"+in_fid);
		List<InFurnitureDetail> inflist = inFurnitureDetailService.findAllByInfid(in_fid);
		ActionContext.getContext().getValueStack().set("inflist",inflist);
		return "findAllByInfid";
	}
	
	/**
	 * 根据仓库id查询进货详单的执行方法
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
	 * 跳转到添加详情单页面的执行方法
	 */
	public String saveUI(){
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
		//查询所有家具
		List<Furniture> flist = furnitureService.findAll();
		//查询所有进货货单
		List<InFurniture> inflist = inFurnitureService.findAll();
		//查询所有仓库
		List<Storehouse> slist = storehouseService.findAll();
		ActionContext.getContext().getValueStack().set("flist", flist);
		ActionContext.getContext().getValueStack().set("inflist", inflist);
		ActionContext.getContext().getValueStack().set("slist", slist);	
		//inFurnitureDetail = inFurnitureDetailService.findById(inFurnitureDetail.getIn_fdid());
		return "saveUI";
	}
	
	/**
	 * 保存进货详情单的执行方法
	 */
	public String save() {
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
		inFurnitureDetailService.save(inFurnitureDetail);
		return "saveSuccess";
	}

	/**
	 * 编辑进货详情单的执行方法
	 */
	public String edit() {
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
		//查询所有家具
		List<Furniture> flist = furnitureService.findAll();
		//查询所有进货货单
		List<InFurniture> inflist = inFurnitureService.findAll();
		//查询所有仓库
		List<Storehouse> slist = storehouseService.findAll();
	
		ActionContext.getContext().getValueStack().set("flist", flist);
		ActionContext.getContext().getValueStack().set("inflist", inflist);
		ActionContext.getContext().getValueStack().set("slist", slist);
		inFurnitureDetail = inFurnitureDetailService.findById(inFurnitureDetail.getIn_fdid());
		System.out.println("fffff"+inFurnitureDetail.getInFurniture().getIn_fid());
		return "editSuccess";
	}

	/**
	 * 修改进货详情单的执行方法
	 */
	public String update() {
	    in_fid = ServletActionContext.getRequest().getParameter("in_fid");
	    ActionContext.getContext().getSession().put("in_fid", in_fid);
	    //inFurnitureDetail = inFurnitureDetailService.findById(inFurnitureDetail.getIn_fdid());
		inFurnitureDetailService.update(inFurnitureDetail);
		return "updateSuccess";
	}

	/**
	 * 删除进货详情单的执行方法
	 */
	public String delete() {
		inFurnitureDetail = inFurnitureDetailService.findById(inFurnitureDetail.getIn_fdid());
		inFurnitureDetailService.delete(inFurnitureDetail);
		return "deleteSuccess";

	}

}
