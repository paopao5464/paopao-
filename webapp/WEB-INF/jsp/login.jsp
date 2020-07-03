<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My first Spring boot web demo</title>
</head>
<body>
<h2>登录</h2>
<form action="/user/selUser" >
    用户名:<input type="text" name="userName" id="userName" >
    密码:<input type="text" name="password" id="password">
    <input type="submit" value="确认登录">
</form>
</body>
</html>