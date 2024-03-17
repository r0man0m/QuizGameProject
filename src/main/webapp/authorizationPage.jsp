<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 20.02.2024
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="styles/w3.css">
<html>
<head>
    <title>Authorization page</title>
</head>
<body class="w3-light-grey">
    <header>
        <div class="w3-container w3-blue-grey w3-opacity-min w3-left-align">
            <h1>Authorization page</h1>
        </div>
    </header>
    <div class="w3-selection w3-light-grey w3-padding">
        <form class="w3-selection w3-light-grey w3-padding" action="auth" method="post">
            <label for="NickName">User nickname</label>
            <input  class="w3-input w3-animate-input w3-border w3-round-large" type="text" name="nickName" id="nickName" required><br>
           <button class="w3-btn w3-green w3-round-large w3-margin-bottom" type="submit">Submit</button><br>
        </form>
        <div class="w3-container w3-grey w3-opacity w3-left-align-align w3-padding">
            <a href="index.jsp">Back to main</a>
        </div>
    </div>

</body>
</html>
