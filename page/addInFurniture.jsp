<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 进货单添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="inFurniture_save" method="post" namespace="/" id="saveForm" theme="simple">

<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>进货单号：</td>
<td><s:textfield name="in_no" /></td>
<td>进货时间：</td>
<td><input type="date" name="in_time" /></td>
<td>备注：</td>
<td><s:textfield name="iremark" /></td>
</tr>

</table>
</s:form>

</body>
</html>