<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 编辑进货单</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="inFurniture_update" method="post" namespace="/" id="saveForm" theme="simple">
<s:hidden name="in_fid" value="%{model.in_fid}"></s:hidden>
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>进货单号：</td>
<td><s:textfield name="in_no" value="%{model.in_no}" /></td>
<td>进货时间：</td>
<td><input type="date" name="in_time" value="<s:date name="model.in_time" format="yyyy-MM-dd" />" /> </td>
<td>备注：</td>
<td><s:textfield name="iremark" value="%{model.iremark}" /></td>
</tr>

</table>
</s:form>

</body>
</html>