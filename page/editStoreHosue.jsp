<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 编辑仓库</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="storehouse_update" method="post" namespace="/" id="saveForm" theme="simple">

<s:hidden name="sid" value="%{model.sid}"></s:hidden>
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>名称：</td>
<td><s:textfield name="sname" value="%{model.sname}"/></td>
<td>型号：</td>
<td><s:textfield name="saddress" value="%{model.saddress}"/></td>
</tr>
</table>
</s:form>

</body>
</html>