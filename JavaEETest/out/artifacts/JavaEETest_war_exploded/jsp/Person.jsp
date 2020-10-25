<%--
  Created by IntelliJ IDEA.
  User: derokhin
  Date: 07.10.20
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>
</head>
<body>
    <h1>My the first use Bean</h1>
    <jsp:useBean id="Peson" class="jsp.PersonBean"  />
<%--    <% String name1 = "name"; %>--%>
<%--    <jsp:setProperty name="Peson" property="name" value="<%=request.getParameter(name1)%>"/>--%>

    <jsp:setProperty name="Peson" property="*" />

    <jsp:getProperty name="Peson" property="name"/>
    <jsp:getProperty name="Peson" property="age"/>

</body>
</html>
