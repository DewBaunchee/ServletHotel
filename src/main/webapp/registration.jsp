<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
</head>
<body>
<form action="registration" method="post">
    <div>
        <h2>Registration</h2>
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
        <input type="submit" value="Sign up">
        <a href="login">
            <input type="button" value="Sign in">
        </a>
    </div>
</form>
</body>
</html>