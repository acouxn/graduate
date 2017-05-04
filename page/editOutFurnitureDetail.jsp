<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 编辑进货详单</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="outFurnitureDetail_update" method="post" namespace="/" id="saveForm" theme="simple">
<s:hidden name="out_fdid" value="%{model.out_fdid}"></s:hidden>
<s:hidden name="exist_num" value="%{model.out_fdnum}"></s:hidden>
<s:hidden name="flag1" value="%{model.flag}"></s:hidden>
<s:hidden name="outFurniture.out_fid" value="%{model.outFurniture.out_fid}"></s:hidden>
<table border='0' cellpadding="0"  cellspacing="10">

<tr>
<td>家具名称：</td>
<td><s:select name="furniture.fid" list="flist" value="%{model.furniture.fid}" listKey="fid" listValue="fname" headerKey="0" headerValue="------" /></td>
<td>存放仓库：</td>
<td><s:select name="storehouse.sid" list="slist" value="%{model.storehouse.sid}" listKey="sid" listValue="sname" headerKey="0" headerValue="------" /></td>
</tr>
<tr>
<td>数量：</td>
<td><s:textfield name="out_fdnum" value="%{model.out_fdnum}" /></td>
<td>价格：</td>
<td><s:textfield name="out_fprice" value="%{model.out_fprice}" /></td>
</tr>
<tr>
<td>是否退货：</td>
<td><s:radio name="flag" list="{'是','否'}" value="%{model.flag}" /></td>

</tr>

</table>
</s:form>

</body>
</html>