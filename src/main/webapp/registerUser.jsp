<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 17.02.2024
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register page</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">

    <header>
        <div class="w3-container w3-blue-grey w3-opacity-min w3-left-align">
            <h1>Registration page</h1>
        </div>

    </header>
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h2>Add new user</h2>
        </div>
      <div class="w3-selection w3-light-grey w3-padding">
          <form class="w3-selection w3-light-grey w3-padding" action="regUser" method="post">
              <label for="name">Name: </label>
              <input class="w3-input w3-animate-input w3-border w3-round-large" type="text" name="name" id="name" required>
              <br>
              <label for="nick">Nickname</label>
              <input class="w3-input w3-animate-input w3-border w3-round-large" type="text" name="nick" id="nick" required>
              <br>
              <button class="w3-btn w3-green w3-round-large w3-margin-bottom" type="submit">Add</button>
          </form>
      </div>
    <div class="w3-container w3-grey w3-opacity w3-left-align w3-padding"><br>
        <a href="/index.jsp">Back to main</a>
    </div>
</body>
</html>
