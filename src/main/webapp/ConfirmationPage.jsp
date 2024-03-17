<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 21.02.2024
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="styles/w3.css">
<html>
<head>
    <title>Confirmation page</title>
</head>
<body class="w3-light-gray">
    <header>
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>Confirm password</h1>
        </div>
    </header>
    <div class="w3-selection w3-light-grey w3-padding">
        <form action="admin" method="post">
            <label>Old password</label>
            <input class="w3-hover-border-pale-green w3-round-large" type="password" name="pass" id="old" required pattern="^\d+$" size="5"><br>
            <button class="w3-btn w3-blue-gray w3-round-large w3-margin-bottom" type="submit">Confirm password</button>
        </form>
    </div>

</body>
</html>
