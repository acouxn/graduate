<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 添加进货详单</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="inFurnitureDetail_save" method="post" namespace="/" id="saveForm" theme="simple">

<table border='0' cellpadding="0"  cellspacing="10">

<tr>
<td>家具名称：</td>
<td><s:select name="furniture.fid" list="flist" value="%{model.furniture.fid}" listKey="fid" listValue="fname" headerKey="0" headerValue="------" /></td>
<td>所属仓库：</td>
<td><s:select name="storehouse.sid" list="slist" value="%{model.storehouse.sid}" listKey="sid" listValue="sname" headerKey="0" headerValue="------" /></td>
<td>所属订单：</td>
<td><s:select name="inFurniture.in_fid" list="inflist" value="%{model.inFurniture.in_fid}" listKey="in_fid" listValue="in_no" headerKey="0" headerValue="------" /></td>
</tr>
<tr>
<td>进货数量：</td>
<td><s:textfield name="in_fdnum" /></td>
<td>进货价格：</td>
<td><s:textfield name="in_fprice" /></td>
</tr>
<tr>
<td>运费：</td>
<td><s:textfield name="in_ftransprice" /></td>
</tr>

</table>
<s:hidden name="in_fid" value="%{model.inFurniture.in_fid}"></s:hidden>
</s:form>

</body>
</html>