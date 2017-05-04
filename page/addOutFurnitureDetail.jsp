<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 添加销售详单</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="outFurnitureDetail_save" method="post" namespace="/" id="saveForm" theme="simple">

<table border='0' cellpadding="0"  cellspacing="10">

<tr>
<td>家具名称：</td>
<td><s:select name="furniture.fid" list="list" value="%{model.furniture.fid}" listKey="furniture.fid" listValue="furniture.fname" headerKey="0" headerValue="------" /></td>
<td>所属仓库：</td>
<td><s:select name="storehouse.sid" list="list" value="%{model.storehouse.sid}" listKey="storehouse.sid" listValue="storehouse.sname" headerKey="0" headerValue="------" /></td>
<td>所属订单：</td>
<td><s:select name="outFurniture.out_fid" list="outflist" value="%{model.outFurniture.out_fid}" listKey="out_fid" listValue="out_no" headerKey="0" headerValue="------" /></td>
</tr>
<tr>
<td>数量：</td>
<td><s:textfield name="out_fdnum" /></td>
<td>价格：</td>
<td><s:textfield name="out_fprice" /></td>
</tr>
<tr>
<td>是否退货：</td>
<td><s:radio name="flag" list="{'是','否'}" value="%{model.flag}" /></td>
</tr>
</table>
<s:hidden name="out_fid" value="%{model.outFurniture.out_fid}"></s:hidden>
</s:form>

</body>
</html>