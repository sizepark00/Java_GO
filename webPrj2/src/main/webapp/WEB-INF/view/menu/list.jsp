<%@page import="com.newlecture.web.entity.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	//List<Menu> menus= (List<Menu>)request.getAttribute("menus");
%>

<%-- <c:set var="path" value="/webprj"/> --%>
<c:url var="path" value="/upload"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>리스트 페이지 입니다!!!</h1>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>이름 </td>
			<td>가격</td>
			<td>등록일</td>
		</tr>
		
		<c:forEach var="m" items="${menus}" >
		<fmt:formatNumber var="price" pattern="#,###" value="${m.price}"/>
		<fmt:formatDate var="regDate" pattern="yyyy-MM-dd mm:ss" value="${m.regDate}"/>
		
		<tr>
			<td>${m.id }</td>
			<td>
			<td><%=((Menu)pageContext.getAttribute("m")).getName()%>/${m.name}</td>
			<td>${price}</td>
			<td>${regDate}</td>
			
			<tr>
				<td colspan="4">
					<c:forTokens begin="2" end="4" step="1" var="img" items="${m.images}" delims="," varStatus="st">
						<a download href="${path}/${img}">${img}</a>
						<c:if test="${!st.last }">|</c:if>						
						<c:if test="${st.last }">~~~</c:if>
					</c:forTokens>		
				</td>			
			</tr>
			
			<%-- <td><%=m.getId()%></td>
			<td><%=m.getName()%></td>
			<td><%=m.getPrice()%></td> --%>
		</tr>
		
		</c:forEach>
		
			
	</table>


</body>
</html>