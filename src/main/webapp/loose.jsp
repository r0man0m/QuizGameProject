<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 27.02.2024
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="styles/w3.css">
<link rel="stylesheet" href="styles/myStyle.css">
<html>
<head>
    <title>loose Page</title>
</head>
<body class="looseImage">
<div class="smile">
    <div class="w3-container w3-blue-grey w3-opacity-min w3-center w3-animate-zoom">
        <h1 class="w3-black"><%=session.getAttribute("loose")%></h1>
    </div>
</div>

    <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
        <button class="w3-btn w3-deep-orange w3-round-large w3-margin-bottom"  onclick="window.location='choiceGame.jsp'">Play again?</button>
    </div>
    <div class="w3-container w3-grey w3-opacity-min w3-right-align w3-padding">
        <a href="index.jsp">Back to main</a>
    </div>


</body>
</html>
