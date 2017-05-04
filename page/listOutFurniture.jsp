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
<td align="center" style="font-size:24px; color:#666"> 销售订单管理 </td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/outFurniture_saveOutFurniture.action">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">销售单号</td>
<td align="center">销售时间</td>
<td align="center">客户名称</td>
<td align="center">联系电话</td>
<td align="center">送货地址</td>
<td align="center">备注</td>
<td align="center">状态</td>
<td align="center">操作</td>
</tr>
</thead>
<tbody>
<s:iterator value="list" var="i">

<tr>
<td align="center"><s:property value="#i.out_no" /></td>
<td align="center"><s:date name="#i.out_time" format="yyyy-MM-dd" /></td>
<td align="center"><s:property value="#i.client.cname" /></td>
<td align="center"><s:property value="#i.client.cphone" /></td>
<td align="center"><s:property value="#i.client.caddress" /></td>
<td align="center"><s:property value="#i.oremark" /></td>
<td align="center"><s:property value="#i.status" /></td>

<td align="center">
	<a href="${pageContext.request.contextPath}/outFurniture_edit.action?out_fid=<s:property value="#i.out_fid" />">编辑 
	<a href="${pageContext.request.contextPath}/outFurniture_delete.action?out_fid=<s:property value="#i.out_fid" />">删除	</a>
    <a href="${pageContext.request.contextPath}/outFurnitureDetail_findAllByOutfid.action?out_fdid=<s:property value="#i.out_fid" />">详情</a>
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
   <span>总记录数<s:property value="totalCount" />&nbsp;&nbsp;每页显示:<s:property value="pageSize" /></span>
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