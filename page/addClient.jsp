<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 增加客户信息</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="client_save" method="post" namespace="/" id="saveForm" theme="simple">

<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>姓名：</td>
<td><s:textfield name="cname" /></td>
<td>联系方式：</td>
<td><s:textfield name="cphone" /></td>
<td>送货地址：</td>
<td><s:textfield name="caddress" /></td>
<td>备注：</td>
<td><s:textfield name="cremark" /></td>
</tr>
</table>
</s:form>

</body>
</html>