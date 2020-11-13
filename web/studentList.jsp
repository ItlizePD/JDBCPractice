<%--
  Created by IntelliJ IDEA.
  User: peiwendu
  Date: 11/13/20
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Show student</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/new">Add New Student</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/show">List All Student</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Student</h2></caption>
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <c:forEach var="student" items="${liststudent}">
            <tr>
                <td><c:out value="${student.name}" /></td>
                <td><c:out value="${student.age}" /></td>
                <td>
                    <a href="/updateFrom?id=<c:out value='${student.name}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${student.name}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
