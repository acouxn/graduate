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
<td align="right" > <a href="${pageContext.request.contextPath}/page/addInFurniture.jsp">添加</a>
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">名称</td>
<td align="center">型号</td>
<td align="center">规格</td>
<td align="center">颜色</td>
<td align="center">品牌</td>
<td align="center">厂商</td>
<td align="center">厂商电话</td>
<td align="center">厂商地址</td>
<td align="center">进货价格</td>
<td align="center">备注</td>
<td align="center">操作</td>
</tr>
</thead>
<tbody>
<s:iterator value="flist" var="f" >

<tr>
<td align="center"><s:property value="#f.fname" /></td>
<td align="center"><s:property value="#f.ftype" /></td>
<td align="center"><s:property value="#f.fsize" /></td>
<td align="center"><s:property value="#f.fcolor" /></td>
<td align="center"><s:property value="#f.fbrand" /></td>
<td align="center"><s:property value="#f.fsupply" /></td>
<td align="center"><s:property value="#f.su_phone" /></td>
<td align="center"><s:property value="#f.su_address" /></td>
<td align="center"><s:property value="#f.finprice" /></td>
<td align="center"><s:property value="#f.fexplain" /></td>
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
 
</td>
</tr>
</table>
</body>
</html>