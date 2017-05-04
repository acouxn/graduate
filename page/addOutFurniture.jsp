<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 销售单添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="outFurniture_save" method="post" namespace="/" id="saveForm" theme="simple">

<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>销售单号：</td>
<td><s:textfield name="out_no" /></td>
<td>销售时间：</td>
<td><input type="date" name="out_time" /></td>
</tr>
<tr>
<td>状态：</td>
<td><s:radio name="status" list="{'待送货','已完成'}" /></td>
<td>客户名称：</td>
<td><s:select name="client.cid" list="clist" listKey="cid" listValue="cname" headerKey="0" headerValue="--请选择--" /></td>
</tr>
<tr>
<td>备注：</td>
<td><s:textfield name="oremark" /></td>
</tr>
</table>
</s:form>

</body>
</html>