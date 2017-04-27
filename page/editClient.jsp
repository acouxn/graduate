<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 编辑客户信息</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="client_update" method="post" namespace="/" id="saveForm" theme="simple">

<s:hidden name="cid" value="%{model.cid}"></s:hidden>
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>姓名：</td>
<td><s:textfield name="cname" value="%{model.cname}"/></td>
<td>联系电话：</td>
<td><s:textfield name="cphone" value="%{model.cphone}"/></td>
<td>送货地址：</td>
<td><s:textfield name="caddress" value="%{model.caddress}"/></td>
<td>备注：</td>
<td><s:textfield name="cremark" value="%{model.cremark}"/></td>
</tr>
</table>
</s:form>

</body>
</html>