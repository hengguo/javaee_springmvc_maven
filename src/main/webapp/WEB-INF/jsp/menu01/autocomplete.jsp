<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%@ include file="../inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights List.</title>
</head>
<script type="text/javascript">
	$().ready(function() {
		$("#username").autocomplete('${ctx}/user/getDynamicUsers',{
			minChars: 0,
			max: 5,
			autoFill: true,
			mustMatch: true,
			matchContains: true,
			scrollHeight: 220,
			formatItem: function(data, i, total) {
				return "<I>"+data[0]+"</I>";
			},
			formatMatch: function(data, i, total) {
				return data[0];
			},
			formatResult: function(data) {
				return data[0];
			}
		});
	});
</script>
<body>
	<div>
		<input type="text" name="username" id="username">
p	</div>
</body>
</html>