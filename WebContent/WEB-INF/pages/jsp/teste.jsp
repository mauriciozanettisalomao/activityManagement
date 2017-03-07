<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<pg:pager id="p" maxPageItems="10" maxIndexPages="10"
		export="offset,currentPageNumber=pageNumber" scope="request">
		<pg:param name="keywords" />

		<c:forEach var="item" items="${listActivityType}">
			<pg:item>
	
	- ${item}	<br>

			</pg:item>
		</c:forEach>

		<br>
		<br>

		<pg:index>
			<pg:prev>
				<a href="#">&lt;&lt; Anterior</a>
			</pg:prev>
			<pg:pages>
				<a href="#"><%=pageNumber%></a>
			</pg:pages>
			<pg:next>
				<a href="#">Próximo &gt;&gt;</a>
			</pg:next>
		</pg:index>
	</pg:pager>

</body>
</html>