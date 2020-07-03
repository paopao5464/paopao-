<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>


<body>
    <form>
        <h2>用户信息列表</h2>
        <table>
            <tr>
                <td>序号</td>
                <td>用户名</td>
                <td>身份</td>
                <td>修改</td>
                <td>删除</td>
            </tr>
            <c:forEach items="${userList}" var="item" varStatus="status">
                <tr id="tr${item.id}">
                    <td>${status.count}</td>
                    <td>${item.userName}</td>
                    <td>${item.realName}</td>
                    <td><input type="button" name="upt" id="upt"  value="修改" onClick="updt(${item.id})"></td>
                    <td><input type="button" name="del" id="del"  value="删除" onClick="dele(${item.id})"></td>
                </tr>
                <br>
            </c:forEach>
        </table>
    </form>

    <script type="text/javascript">
        function dele(id) {
            if(confirm("确定删除吗!!")) {
                $.ajax({
                    type: "post",
                    url: "/user/delUser",
                    data:
                        {
                            id: id
                        },
                    success: function (data) {
                        alert("删除成功!!");
                        $("#tr"+id).remove();
                    },
                    error: function () {
                        alert("网络异常，请稍后重试!!");
                    }
                })
            }
        }

        function updt(id){
            window.location.href = "/user/uptDetailToView?id="+id;
        }

    </script>
</body>
</html>
