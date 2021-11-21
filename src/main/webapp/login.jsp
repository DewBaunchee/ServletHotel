<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Signing in</title>
</head>
<body>
<form action="login" method="post">
    <div>
        <h2>Signing in</h2>
        <div>
            <label>
                <input name="username" type="text" placeholder="Username">
            </label>
        </div>
        <div>
            <label>
                <input name="password" type="password" placeholder="Password">
            </label>
        </div>
    </div>
    <div>
        <input type="submit" value="Sign in">
        <a href="registration">
            <input type="button" value="Sign up">
        </a>
    </div>
</form>
</body>
</html>
