<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 23.02.2024
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="styles/w3.css">
<html>
<head>
    <title>Choice game Page</title>
</head>
<body class="w3-light-grey">
    <div>
        <header>
            <div class="w3-container w3-blue-grey w3-opacity-min w3-left-align w3-animate-left">
                <h1>Choice the game</h1>
            </div>
        </header>
    </div>
    <div class="w3-selection w3-light-grey w3-padding">
        <form  class="w3-selection w3-light-grey w3-padding w3-animate-zoom"action="setGame" method="post">
            <button class="w3-btn w3-border-aqua w3-round-large w3-margin-bottom" name="name"  value="ufo" onclick="" type="submit"><h3>Ufo game</h3></button>
            <button class="w3-btn w3-border-aqua w3-round-large w3-margin-bottom" name="name" value="another" onclick="" type="submit"> <h3>Another game</h3></button>
            <button class="w3-btn w3-border-aqua w3-round-large w3-margin-bottom" name="name" value="more" onclick="" type="submit"><h3>More game</h3></button>
        </form>
    </div>
    <div class="w3-container w3-grey w3-opacity-min w3-right-align w3-padding">
        <a href="index.jsp">Back to main</a>
    </div>

</body>
</html>
