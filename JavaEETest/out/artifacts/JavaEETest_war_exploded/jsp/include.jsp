<%--
  Created by IntelliJ IDEA.
  User: derokhin
  Date: 07.10.20
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Include JSP</title>
</head>
<body>
    <jsp:include page="FirstJsp.jsp" />

    <h2>
        <jsp:include page="/WEB-INF/hello.txt" />
    </h2>

    <jsp:include page="/library" />


    <jsp:forward page="/names" />

</body>
</html>
