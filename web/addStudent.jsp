<%--
  Created by IntelliJ IDEA.
  User: peiwendu
  Date: 11/13/20
  Time: 02:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/new">Add New Student</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/show">List All Student</a>
    </h2>
    <div align="center">
        <c:if test="${student != null}">
        <form action="update" method="post">
            </c:if>
            <c:if test="${student == null}">
            <form action="insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${student != null}">
                                Edit Student
                            </c:if>
                            <c:if test="${student == null}">
                                Add New Student
                            </c:if>
                        </h2>
                    </caption>
                    <tr>
                        <th>Name: </th>
                        <td>
                            <input type="text" name="sname" size="45"
                                   value="<c:out value='${student.name}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Age: </th>
                        <td>
                            <input type="number" name="sage" size="45"
                                   value="<c:out value='${student.age}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
            </form>
    </div>
</center>

</body>
</html>
