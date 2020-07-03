<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/26
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>用户新增</p>

<form id="form">
    <table>
        <tr>
            <td>用户名:<label for="userName"></label><input type="text" id="userName" name="userName" value=""></td>
            <td>密码:<label for="passWord"></label><input type="text" id="passWord" name="passWord" value=""></td>
            <td>身份:<label for="realName"></label><input type="text" id="realName" name="realName" value=""></td>
            <td><input type="button" id="btn" value="确认" onclick="insertBtn()"></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    function insertBtn() {
        const data = $("#form").serialize();//序列化表单
        $.ajax({
            url: "/user/insert",
            type: "post",
            data: data,
            success: function (msg) {
                alert(msg);
            },
            error: function () {
                alert("网络错误，请稍后重试!!");
            }
        })


    }


</script>


</body>
</html>
