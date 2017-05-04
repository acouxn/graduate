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
<td align="center" style="font-size:24px; color:#666"> 货物管理 </td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/page/addFurniture.jsp">添加</a></td>
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
<td align="center">详情</td>
<td align="center">操作</td>
</tr>
</thead>
<tbody>
<s:iterator value="list" var="f">
<tr>
<td align="center"><s:property value="#f.fname" /></td>
<td align="center"><s:property value="#f.ftype" /></td>
<td align="center"><s:property value="#f.fsize" /></td>
<td align="center"><s:property value="#f.fcolor" /></td>
<td align="center"><s:property value="#f.fbrand" /></td>
<td align="center"><s:property value="#f.fsupply" /></td>
<td align="center"><s:property value="#f.su_phone" /></td>
<td align="center"><s:property value="#f.su_address" /></td>
<td align="center"><s:property value="#f.fexplain" /></td>
<td align="center"><a href="${pageContext.request.contextPath}/furniture_edit.action?fid=<s:property value="#f.fid" />">编辑 <a href="${pageContext.request.contextPath}/furniture_delete.action?fid=<s:property value="#f.fid" />">删除</a></td>
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
       <a href="${pageContext.request.contextPath}/furniture_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/furniture_findAll.action?currPage=<s:property value="currPage-1" />">[上一页]</a>&nbsp;&nbsp;
    </s:if>
    <s:if test="currPage != totalPage">
       <a href="${pageContext.request.contextPath}/furniture_findAll.action?currPage=<s:property value="currPage+1" />">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/furniture_findAll.action?currPage=<s:property value="totalPage" />">[尾页]</a>&nbsp;&nbsp;
    </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>