<%--
  Created by IntelliJ IDEA.
  User: tranvantrong
  Date: 31/03/2022
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Create Email</h3>
<form:form method="POST" action="create" modelAttribute="mailbox">
    <table>
        <tr>
            <td><form:label path="mailAddress">MailAddress: </form:label></td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><form:label path="langueges">Langueges: </form:label></td>
                <%--      <td><select  items="${languegesList}"  path="langueges"></select></td>--%>
            <td>
                <select>
                    <option value="1">Vietnamese</option>
                    <option value="2">Japanese</option>
                    <option value="3">Enghlish</option>
                    <option value="4">Chinese</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td>
                <select>
                    <option value="1">5</option>
                    <option value="2">10</option>
                    <option value="3">15</option>
                    <option value="4">20</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamrfilter">Spamrfilter: </form:label></td>
            <td><input type="checkbox"></td>
        </tr>
        <tr>
            <td><form:label path="singnatune">Singnatune: </form:label></td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><input type="submit" value="create"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
