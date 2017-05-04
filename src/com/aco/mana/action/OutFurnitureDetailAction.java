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
 * 销售详情管理的Action类
 * 
 * @author Administrator
 * 
 */
public class OutFurnitureDetailAction extends ActionSupport implements
		ModelDriven<OutFurnitureDetail>{

	// 模型对象使用的对象
	OutFurnitureDetail outFurnitureDetail = new OutFurnitureDetail();
	// 注入业务层类
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

	// 接收当前页数
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	

	/**
	 * 分页查询销售详情单的执行方法
	 */
	public String findAll() {

		PageBean<OutFurnitureDetail> pageBean = outFurnitureDetailService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		
		//查询所有家具
		//List<Furniture> flist = furnitureService.findAllByInid(inFurniture);
		//System.out.println("订单家具数量"+flist.size());
		//ActionContext.getContext().getValueStack().set("flist", flist);
		return "findAll";
	}
	
	
	private String out_fdid;//订单id


	public String getOut_fdid() {
		return out_fdid;
	}

	public void setOut_fdid(String out_fdid) {
		this.out_fdid = out_fdid;
	}

	/**
	 * 根据销售单id查询销售详单的执行方法
	 */
	public String findAllByOutfid(){
	    out_fdid = ServletActionContext.getRequest().getParameter("out_fdid");
	    ActionContext.getContext().getSession().put("out_fdid", out_fdid);
		//System.out.println("in_fidin_fidin_fidin_fid的值:"+out_fid);
		List<OutFurnitureDetail> outflist = outFurnitureDetailService.findAllByOutfid(out_fdid);
		ActionContext.getContext().getValueStack().set("outflist",outflist);
		return "findAllByOutfid";
	}
	
	/**
	 * 根据仓库id查询销售详单的执行方法
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
	 * 跳转到添加详情单页面的执行方法
	 */
	public String saveUI(){
		out_fdid = ServletActionContext.getRequest().getParameter("out_fid");
	    ActionContext.getContext().getSession().put("out_fid", out_fdid);
		//查询所有库存
		List<InFurnitureDetail> list = inFurnitureDetailService.findAll();
		//查询所有销售货单
		List<OutFurniture> outflist = outFurnitureService.findAll();

		ActionContext.getContext().getValueStack().set("list", list);
		ActionContext.getContext().getValueStack().set("outflist", outflist);
		//outFurnitureDetail = outFurnitureDetailService.findById(outFurnitureDetail.getIn_fdid());
		return "saveUI";
	}
	
	/**
	 * 保存销售详情单的执行方法
	 */
	public String save() {
		out_fdid = ServletActionContext.getRequest().getParameter("out_fdid");
	    ActionContext.getContext().getSession().put("out_fdid", out_fdid);
	    String fid = ServletActionContext.getRequest().getParameter("furniture.fid");//获取家具id的值
	    String num = ServletActionContext.getRequest().getParameter("out_fdnum");//获取家具数量
	    String sid = ServletActionContext.getRequest().getParameter("storehouse.sid");//获取家具存放的仓库
	    String flag = ServletActionContext.getRequest().getParameter("flag");//获取家具是否退货的状态
	  /*
	    try {
			flag = new String(flag.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	    //System.out.println("flag的值"+flag+"-----fid的值"+fid+"------数量"+num+"------sid的值"+sid);
	    if(flag.equals("否")){
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
	 * 编辑销售详情单的执行方法
	 */
	public String edit() {
		out_fdid = ServletActionContext.getRequest().getParameter("out_fdid");
	    ActionContext.getContext().getSession().put("out_fdid", out_fdid);
		//查询所有家具
		List<Furniture> flist = furnitureService.findAll();
		//查询所有销售货单
		List<OutFurniture> outflist = outFurnitureService.findAll();
		//查询所有仓库
		List<Storehouse> slist = storehouseService.findAll();
	
		ActionContext.getContext().getValueStack().set("flist", flist);
		ActionContext.getContext().getValueStack().set("outflist", outflist);
		ActionContext.getContext().getValueStack().set("slist", slist);
		outFurnitureDetail = outFurnitureDetailService.findById(outFurnitureDetail.getOut_fdid());
		System.out.println("fffff"+outFurnitureDetail.getOutFurniture().getOut_fid());
		return "editSuccess";
	}

	/**
	 * 修改销售详情单的执行方法
	 */
	public String update() {
		out_fdid = ServletActionContext.getRequest().getParameter("out_fdid");
	    ActionContext.getContext().getSession().put("out_fdid", out_fdid);
	    String fid = ServletActionContext.getRequest().getParameter("furniture.fid");//获取家具id的值
	    String exist_num = ServletActionContext.getRequest().getParameter("exist_num");//获取家具数量
	    String num = ServletActionContext.getRequest().getParameter("out_fdnum");//获取修改后的家具数量
	    String sid = ServletActionContext.getRequest().getParameter("storehouse.sid");//获取家具存放的仓库
	    String flag = ServletActionContext.getRequest().getParameter("flag");//获取修改后家具的退货状态
	    String flag1 = ServletActionContext.getRequest().getParameter("flag1");//获取已存在的退货状态
	    System.out.println("flag的值"+flag1+"修改后的flag的值"+flag+"-----fid的值"+fid+"--------已有数量"+exist_num+"------数量"+num+"------sid的值"+sid);
	   
	    InFurnitureDetail inFurnitureDetail = inFurnitureDetailService.findBySidAndFid(sid,fid);//根据仓库id和家具id查询库存
	    
	    int a = Integer.parseInt(exist_num);//强转获得的家具数量
	    int b = Integer.parseInt(num);//强转修改后的家具数量
	    if(a>b && flag.equals("否") && flag1.equals("否")){//若家具数量减少且不退货,对应库存增加
	    	int c = a - b;
	    	int temp = inFurnitureDetail.getIn_fdnum();//获得库存数量
	    	inFurnitureDetail.setIn_fdnum(temp+c);
	    	inFurnitureDetailService.update(inFurnitureDetail);
	    }else if(a<b && flag.equals("否") && flag1.equals("否")){//若家具数量增加且不退货，则对应库存减少
	    	int c = b - a;
	    	int temp = inFurnitureDetail.getIn_fdnum();//获得库存数量
	    	inFurnitureDetail.setIn_fdnum(temp-c);
	    	inFurnitureDetailService.update(inFurnitureDetail);
	    }else if(flag.equals("否") && flag1.equals("是")){
	    	int temp = inFurnitureDetail.getIn_fdnum();//获得库存数量
	    	inFurnitureDetail.setIn_fdnum(temp-b);
	    	inFurnitureDetailService.update(inFurnitureDetail);
	    }else if(flag.equals("是") && flag1.equals("否")){
	    	int temp = inFurnitureDetail.getIn_fdnum();//获得库存数量
	    	inFurnitureDetail.setIn_fdnum(temp+b);
	    	inFurnitureDetailService.update(inFurnitureDetail);
	    }
	    //outFurnitureDetail = outFurnitureDetailService.findById(outFurnitureDetail.getIn_fdid());
		outFurnitureDetailService.update(outFurnitureDetail);
		return "updateSuccess";
	}

	/**
	 * 删除销售详情单的执行方法
	 */
	public String delete() {
		String fid = ServletActionContext.getRequest().getParameter("furniture.fid");//获取家具id的值
		String num = ServletActionContext.getRequest().getParameter("out_fdnum");//获取修改后的家具数量
		String sid = ServletActionContext.getRequest().getParameter("storehouse.sid");//获取家具存放的仓库id
		String flag = ServletActionContext.getRequest().getParameter("flag");//获取家具的退货状态
		try {
			flag = new String(flag.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int b = Integer.parseInt(num);//强转家具数量
		 System.out.println("flag的值"+flag+"-----fid的值"+fid+"------数量"+num+"------sid的值"+sid);
		InFurnitureDetail inFurnitureDetail = inFurnitureDetailService.findBySidAndFid(sid,fid);//根据仓库id和家具id查询库存
		if(flag.equals("否")){
			int temp = inFurnitureDetail.getIn_fdnum();//获得库存数量
	    	inFurnitureDetail.setIn_fdnum(temp+b);
	    	inFurnitureDetailService.update(inFurnitureDetail);
		}
		outFurnitureDetail = outFurnitureDetailService.findById(outFurnitureDetail.getOut_fdid());
		outFurnitureDetailService.delete(outFurnitureDetail);
		return "deleteSuccess";

	}

}
