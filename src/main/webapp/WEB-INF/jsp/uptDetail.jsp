<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/25
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<html>
<head>
    <title>修改展示页面</title>
</head>
<body>
<form id="form">
<h2>用户信息修改</h2>
<table>
    <tr>
        <td>用户名</td>
        <td>身份</td>
        <td>修改</td>
        <td><input type="button" id="btn" name="btn" value="新增" onclick="insertBtn()"></td>
    </tr>
    <tr>
        <td><input type="text" id="userName" name="userName" value="${userModel.userName}"></td>
        <td><input type="text" id="realName" name="realName" value="${userModel.realName}"></td>
        <td><input type="button" name="upt" id="upt"  value="确认修改" onClick="updt('${userModel.id}')"></td>
    </tr>
</table>
</form>
<script type="text/javascript">
    function updt(id){
        var userName = $("#userName").val();
        var realName = $("#realName").val();
        var data = {
            userName: userName,
            realName: realName,
            id: id
        };

        if(confirm("确定修改吗!!")) {
            $.ajax({
                url: "/user/updtUser",
                type: "post",
                data:
                    {
                        js:JSON.stringify(data)
                    },
                success: function (data) {
                    alert("修改成功!!");
                    console.log(data);
                    //window.location.href = "/user/selAll";
                },
                error:function (data) {
                    alert("网络异常，请稍后重试!!");
                }

            })
        }
    }

    function insertBtn(){
        window.location.href = "/user/insertUser";
    }




</script>

</body>
</html>
