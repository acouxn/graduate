 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:90%;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="90%">
<tr>
<td align="center" style="font-size:24px; color:#666"> 销售详情订单管理 </td>

</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/outFurnitureDetail_saveUI.action">添加</a>
		<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">家具名称</td>
<td align="center">家具型号</td>
<td align="center">规格</td>
<td align="center">颜色</td>
<td align="center">品牌</td>
<td align="center">数量</td>
<td align="center">价格</td>
<td align="center">合计费用</td>
<td align="center">存放仓库</td>
<td align="center">是否退货</td>
<td align="center">操作</td>
</tr>
</thead>
<tbody>
<s:set name="allprice" value="0"></s:set>
<s:iterator value="outflist" var="i">
<tr>
<td align="center"><s:property value="#i.furniture.fname" /></td>
<td align="center"><s:property value="#i.furniture.ftype" /></td>
<td align="center"><s:property value="#i.furniture.fsize" /></td>
<td align="center"><s:property value="#i.furniture.fcolor" /></td>
<td align="center"><s:property value="#i.furniture.fbrand" /></td>
<td align="center"><s:property value="#i.out_fdnum" /></td>
<td align="center"><s:property value="#i.out_fprice" /></td>
<td align="center"><s:property value="#i.out_fprice*#i.out_fdnum" />
<s:set name="allprice" value="#allprice+#i.out_fprice*#i.out_fdnum"></s:set>
</td>  
<td align="center"><s:property value="#i.storehouse.sname"  /></td>
<td align="center"><s:property value="#i.flag"  /></td>
<td align="center"><a href="${pageContext.request.contextPath}/outFurnitureDetail_edit.action?out_fdid=<s:property value="#i.out_fdid" />">编辑 
	<a href="${pageContext.request.contextPath}/outFurnitureDetail_delete.action?out_fdid=<s:property value="#i.out_fdid" />&furniture.fid=<s:property value="#i.furniture.fid" />&out_fdnum=<s:property value="#i.out_fdnum" />&storehouse.sid=<s:property value="#i.storehouse.sid" />&flag=<s:property value="#i.flag" />">删除	</a>
    </td>
    
</tr>
	
</s:iterator>
</tbody>
</table>
<a align="right">合计：<s:property value="allprice" />元</a>
<br/>
</body>
</html>