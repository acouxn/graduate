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
<td align="center" style="font-size:24px; color:#666"> 仓库列表
 </td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">仓库名称</td>
<td align="center">操作</td>
</tr>
</thead>
<tbody>
<s:iterator value="list" var="s">
<tr>
<td align="center"><s:property value="#s.sname" /></td>


<td align="center">
	<a href="${pageContext.request.contextPath}/inFurnitureDetail_findAllBySid.action?sid=<s:property value="#s.sid" />&sname=<s:property value="#s.sname" />">查看库存</a>
</td>
</tr>
</s:iterator>
</tbody>
</table>
<br/>
</body>
</html>