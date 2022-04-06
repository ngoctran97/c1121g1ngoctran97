<%--
  Created by IntelliJ IDEA.
  User: tranvantrong
  Date: 31/03/2022
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Mailbox List</h3>
<p><a href="/mailbox">create</a></p>
<form>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>mailAddress</th>
            <th>langueges</th>
            <th>pageSize</th>
            <th>spamrfilter</th>
            <th>singnatune</th>
            <th></th>
        </tr>
        <c:forEach var="mailbox" items="${mailboxList}">
            <tr>
                <td>${mailbox.id}</td>
                <td>${mailbox.mailAddress}</td>
                <td>${mailbox.langueges}</td>
                <td>${mailbox.pageSize}</td>
                <td>${mailbox.spamrfilter}</td>
                <td>${mailbox.singnatune}</td>
                <td><a href="#">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
