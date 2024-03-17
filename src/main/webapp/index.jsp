<html>
<head>
    <title>Quiz game</title>
<%@page contentType="text/html; ISO-8859-1" language="java" %>
    <link rel="stylesheet" href="styles/w3.css">
</head>
    <header>
        <div class="w3-container w3-blue-grey w3-opacity-min w3-left-align">
            <h1>Quiz game</h1>
        </div>

    </header>
<body class="w3-light-grey">
    <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
        <button class="w3-btn w3-border-aqua w3-round-large w3-margin-bottom" name="auth" type="submit" onclick="window.location = '/authorizationPage.jsp'">Authorization</button>
        <button class="w3-btn w3-border-aqua w3-round-large w3-margin-bottom" name="regUser" type="submit" onclick="window.location='/regUser'">Registration</button>
        <button class="w3-btn w3-border-aqua w3-round-large w3-margin-bottom" name="admin" type="submit" onclick="window.location='/adminLoginPage.jsp'">Admin page</button>
    </div>
</body>
</html>
