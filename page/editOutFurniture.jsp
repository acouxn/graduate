<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 编辑销售单</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="outFurniture_update" method="post" namespace="/" id="saveForm" theme="simple">

<s:hidden name="out_fid" value="%{model.out_fid}"></s:hidden>
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>销售单号：</td>
<td><s:textfield name="out_no" value="%{model.out_no}" /></td>
<td>销售时间：</td>
<td><input type="date" name="out_time" value="<s:date name="model.out_time" format="yyyy-MM-dd" />" /></td>
</tr>
<tr>
<td>状态：</td>
<td><s:radio name="status" list="{'待送货','已完成'}" value="%{model.status}" /></td>
<td>客户名称：</td>
<td><s:select name="client.cid" list="clist" value="%{model.client.cid}" listKey="cid" listValue="cname" headerKey="0" headerValue="---------" /></td>
</tr>
<tr>
<td>备注：</td>
<td><s:textfield name="oremark" value="%{model.oremark}" /></td>
</tr>
</table>
</s:form>

</body>
</html>