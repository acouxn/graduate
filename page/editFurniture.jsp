<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 货物添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="furniture_update" method="post" namespace="/" id="saveForm" theme="simple">

<s:hidden name="fid" value="%{model.fid}"></s:hidden>
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>名称：</td>
<td><s:textfield name="fname" value="%{model.fname}"/></td>
<td>型号：</td>
<td><s:textfield name="ftype" value="%{model.ftype}"/></td>
</tr>
<tr>
<td>规格：</td>
<td><s:textfield name="fsize" value="%{model.fsize}"/> </td>
<td>颜色：</td>
<td><s:textfield name="fcolor" value="%{model.fcolor}"/></td>
</tr>

<tr>
<td>品牌：</td>
<td><s:textfield name="fbrand" value="%{model.fbrand}"/> </td>
<td>厂商：</td>
<td><s:textfield name="fsupply" value="%{model.fsupply}"/></td>
</tr>

<tr>
<td>厂商电话：</td>
<td><s:textfield name="su_phone" value="%{model.su_phone}"/></td>
<td>厂商地址：</td>
<td><s:textfield name="su_address" value="%{model.su_address}"/></td>
</tr>
<tr>
<td>进货价格：</td>
<td><s:textfield name="finprice" value="%{model.finprice}"/> </td>
</tr>
<tr>
<td>详情：</td>
<td><s:textarea rows="5" cols="30" name="fexplain" value="%{model.fexplain}"/></td>
</tr>

</table>
</s:form>

</body>
</html>