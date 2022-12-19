<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%@include file="header.jsp"%>
  <div>
      <span>Content</span>
      <p>Size: ${requestScope.flights.size()}</p>
      <p>Id: ${requestScope.flights[1].id}</p>
      <p>JSESSION id: ${cookie["JSESSIONID"]}, unique identifier</p>
      <p>${header["Cookie"]}</p>
      <p>${param.id}</p>
      <p>${param.test}</p>
  </div>
<%@include file="footer.jsp"%>
</body>
</html>
