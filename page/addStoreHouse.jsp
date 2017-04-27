<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 货物添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="storehouse_save" method="post" namespace="/" id="saveForm" theme="simple">

<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>仓库名称：</td>
<td><s:textfield name="sname" /></td>
<td>仓库地址：</td>
<td><s:textfield name="saddress" /></td>
</tr>
</table>
</s:form>

</body>
</html>