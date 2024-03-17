<%@ page import="service.PasswordSaver" %><%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 21.02.2024
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="styles/w3.css">
<html>
<head>
    <title>Admin login page</title>
</head>
<body class="w3-light-gray">
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
        <header>
            <h2>Admin login page</h2>
        </header>
    </div>
    <div class="w3-selection w3-light-grey w3-padding">
        <form action="passw" method="post">
            <label class= for="pass">Admin password(default 1)</label>
            <input class="w3-hover-border-pale-green w3-round-large" type="password" name="pass" id="pass" required pattern="^\d+$" size="5"><br>
            <button class="w3-btn w3-blue-gray w3-round-large w3-margin-bottom" type="submit">Send password</button>
        </form>
    </div>
    <div class="w3-selection w3-gray w3-padding">
        <button class="w3-btn w3-blue-gray w3-round-large w3-margin-bottom" type="button" onclick="window.location='/admin'">Change password</button>
    </div>
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <a href="index.jsp">Back to main</a>
    </div>

</body>
</html>
