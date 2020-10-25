<%--
  Created by IntelliJ IDEA.
  User: derokhin
  Date: 27.09.20
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Hhao</title>
</head>
<body>


<%--    <%@ page import="cart.Cart"  %>--%>
<%--    <% Cart cart = (Cart) session.getAttribute("cart"); %>--%>
<%--    <p> Name: <%= cart.getName() %> </p>--%>
<%--    <p> Numbers: <%= cart.getQuantity() %> </p>--%>

    <h1>Nizemneyang? Really?</h1>
    <p>
        <%= new java.util.Date() %>
        <%
            String name = request.getParameter("name");
        %>
        <%= name %>

        <%
            for (int i = 0; i < 3; i++) {
                out.println("<p>" + "Xiexie " + i + "</p>");
            }
            java.util.Date now = new java.util.Date();
            String somestr = "Current date: " + now;
        %>
        <%= somestr %>
        <br>
        <%@ page import="java.util.Date, logic.TestClass" %>
        <%@ page import="cart.Cart" %>
        <% TestClass testClass = new TestClass(); %>

        <%= new Date() %>
        <%= "<p>" + testClass.getInfo() + "</p>" %>
    </p>
</body>
</html>
