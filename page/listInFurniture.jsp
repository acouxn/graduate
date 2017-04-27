<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 进货订单管理 </td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/page/addInFurniture.jsp">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">进货单号</td>
<td align="center">家具名称</td>
<td align="center">家具型号</td>
<td align="center">规格</td>
<td align="center">颜色</td>
<td align="center">品牌</td>
<td align="center">数量</td>
<td align="center">价格</td>
<td align="center">运费</td>
<td align="center">存放仓库</td>
<td align="center">进货时间</td>
<td align="center">备注</td>
<td align="center">操作</td>
</tr>
</thead>
<tbody>
<s:iterator value="list" var="i">

<tr>
<td align="center"><s:property value="#i.in_no" /></td>
<td align="center"><s:property value="#i.furniture_id" /></td>
<td align="center"><s:property value="#f.ftype" /></td>
<td align="center"><s:property value="#i.furniture.fsize" /></td>
<td align="center"><s:property value="#i.furniture.fcolor" /></td>
<td align="center"><s:property value="#i.furniture.fbrand" /></td>
<td align="center"><s:property value="#i.num" /></td>
<td align="center"><s:property value="#i.in_fprice" /></td>
<td align="center"><s:property value="#i.in_transprice" /></td>
<td align="center"><s:property value="#i.storehouse.sname"  /></td>
<td align="center"><s:date name="#i.in_time" format="yyyy-MM-dd" /></td>
<td align="center"><s:property value="#i.inremark" /></td>
<td align="center"><a href="${pageContext.request.contextPath}/inFurniture_edit.action?cid=<s:property value="#i.iid" />">编辑 
	<a href="${pageContext.request.contextPath}/inFurniture_delete.action?cid=<s:property value="#i.iid" />">删除	</a>
    <a href="${pageContext.request.contextPath}/inFurniture_findFurniture.action?in_fid=<s:property value="#i.in_fid" />">详情</a>
    </td>
</tr>

</s:iterator>
</tbody>
</table>
<br/>

<table table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage" />/<s:property value="totalPage" />页</span>&nbsp;&nbsp;
   <span>总记录数<s:property value="totalCount" />&nbsp;&nbsp;每页显示<s:property value="pageSize" />页</span>
   <apan>
   	<s:if test="currPage != 1">
       <a href="${pageContext.request.contextPath}/inFurniture_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/inFurniture_findAll.action?currPage=<s:property value="currPage-1" />">[上一页]</a>&nbsp;&nbsp;
    </s:if>
    <s:if test="currPage != totalPage">
       <a href="${pageContext.request.contextPath}/inFurniture_findAll.action?currPage=<s:property value="currPage+1" />">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/inFurniture_findAll.action?currPage=<s:property value="totalPage" />">[尾页]</a>&nbsp;&nbsp;
    </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>