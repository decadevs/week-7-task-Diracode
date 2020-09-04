<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02/09/2020
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Facebook Application</title>
</head>
<body>
<div style="text-align: center">
    <h1>Facebook User Management</h1>
    <h2>
        <a href="/new">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Users</a>

    </h2>
</div>
<div style="alignment: center">
    <table style="table-layout: auto">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>FIRSTNAME</th>
            <th>LASTNAME</th>
            <th>EMAIL</th>
            <th>DATE OF BIRTH</th>
            <th>GENDER</th>
            <th>ACTIONS</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.firstName}" /></td>
                <td><c:out value="${user.lastName}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:out value="${user.dob}" /></td>
                <td><c:out value="${user.gender}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${user.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
