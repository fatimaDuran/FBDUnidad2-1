<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
		<th>
			<form action="MediaController">
				<input type="submit" name="btn_new"
				value="New"/>
			</form>
		</th>
		<th>Id</th>
		<th>X_uuid</th>
		<th>url</th>
		<th>media_type</th>
		
		</tr>
		<d:forEach var="media" items="${medias}">
		<tr>
		<td>
		<form action="MediaController">
			<input type="hidden" name="id" value="${media.id}"/>
			<input type="submit" name="btn_edit" value="Edit"/>
			<input type="submit" name="btn_delete"value="Delete"/>
		</form>
		</td>
			<td>${media.id}</td>
			<td>${media.x_uuid}</td>
			<td>${media.url}</td>
			<td>${media.media_type}</td>
			
		</tr>
		</d:forEach> <!-- Etiqueta de la libreria jstl -->
	</table>
</body>
</html>