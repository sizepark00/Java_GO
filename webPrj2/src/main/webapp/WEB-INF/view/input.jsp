<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="size" value="1000"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<a href="/input?p=1&q=hello&s=15">1</a>
	<br>
	<a href="/input?p=2&q=hello&s=15">2</a>
	<br>
	<a href="/input?p=3&q=hello&s=15">3</a>
	<br>
	<div>
		page :${page}, query:${query}, size:{size}<br>
		param size : ${param.s}<br>
		header:${header["User-Agent"]}<br>
		hb length : ${cnt}
		
	</div>

	<form action="/input" method="">
		<fieldset>
			<legend>쿼리 값</legend>
			<label>page:</label><br>
			<input type="text" name="p"><br>
			<label>검색어:<label><br> 
			<input type="text"	name="q"><br>
			<label>size:</label><br>
			<input type="text" name="s"><br>
		</fieldset>
		<fieldset>
			<legend>취미</legend>
			<input type="checkbox" name="hb" value="1">
			<label>탁구</label>
			<input type="checkbox" name="hb" value="2">
			<label>독서</label>
			<input type="checkbox" name="hb" value="3">
			<label>술</label>		
		</fieldset>
			<input type="submit" value="전송"><br>
	</form>

</body>
</html>