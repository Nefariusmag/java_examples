<%--
  Created by IntelliJ IDEA.
  User: derokhin
  Date: 07.10.20
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="mvc.StudentBean" %>
<%--<%@ page isELIgnored="true" %>--%>


<html>
<head>
    <title>MVC example</title>
</head>
<body>
    <jsp:useBean id="Student" class="mvc.StudentBean" scope="request"/>
    <jsp:getProperty name="Student" property="name"/>

    <h3>Express language</h3>
    ${Student.name} - ${Student["age"]}
    <br>
    ${privateList[1]}
    <br>
    ${map["one"]}
    ${map.one}
    <br>
    ${map.two !=1 ? "true" : "false" }

</body>
</html>
