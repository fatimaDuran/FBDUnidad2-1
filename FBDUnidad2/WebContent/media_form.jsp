<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="MediaController">
   <label>X_uuid:</label><br />
  	<input type="text" name="x_uuid" value="${media.x_uuid}"/><br />
  <label>Url:</label></br>
  	<input type="text" name="url" value="${media.url}"/></br>
  	<label>media_type:</label></br>
  	<input type="text" name="media_type" value="${media.media_type}"/></br>
<input type="submit" name="btn_save" value="save"/>
  </form>

</body>
</html>