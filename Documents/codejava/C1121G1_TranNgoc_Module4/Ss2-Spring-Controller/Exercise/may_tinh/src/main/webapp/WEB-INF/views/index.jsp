<%--
  Created by IntelliJ IDEA.
  User: tranvantrong
  Date: 30/03/2022
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form method="post" action="/Calculate">
  <fieldset>
    <legend>Calculator</legend>
    <table>

      <tr>
        <td>Num 1: </td>
        <td><input name="num1" type="text"/></td>
      </tr>

      <tr>
        <td>Num 2: </td>
        <td><input name="num2" type="text"/></td>
      </tr>

      <tr>
        <td>Operator: </td>
        <td>
          <select name="operator">
            <option value="cong">Addition</option>
            <option value="tru">Subtraction</option>
            <option value="nhan">Multiplication</option>
            <option value="chia">Division</option>
          </select>
        </td>
      </tr>

      <tr>
        <td></td>
        <td><input type="submit" value="Calculate"/></td>
      </tr>

      <tr>
        <td>Result Division: </td>
        <td><input type="text" value="${result}"></td>
      </tr>

    </table>
  </fieldset>
</form>
</body>
</html>
