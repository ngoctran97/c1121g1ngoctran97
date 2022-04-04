<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Greeting</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
    <form action="/sum" method="post">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 m-lg-auto">
                    <div class="mb-3">
                        <label for="number1" class="form-label">Number 1</label>
                        <input type="text" class="form-control" id="number1" name="a">
                    </div>
                    <div class="mb-3">
                        <label for="number2" class="form-label">Number 2</label>
                        <input type="text" class="form-control" id="number2" name="number2">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </div>
    </form>

</body>
</html>
