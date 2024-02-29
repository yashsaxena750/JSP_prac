<%--
  Created by IntelliJ IDEA.
  User: yashs
  Date: 29-02-2024
  Time: 08:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="java">
<head>
    <title>Session</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/session-servlet" method="post">

        <label>user:
            <input type="text" name="fname" required>
        </label><br><br>

        <label>pass:
            <input type="text" name="pswd" required>
        </label><br><br>

        <label>login:
            <input type="submit" value="submit" required>
        </label><br><br>

    </form>

  </body>
</html>
