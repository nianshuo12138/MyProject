<%--
  Created by IntelliJ IDEA.
  User: NianShuo_O
  Date: 2021/1/6
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册页面</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#registForm").validate({
                rules : {
                    username: {
                        required : true,
                        rangelength : [4,16]
                    },
                    password : {
                        required: true,
                        rangelength: [4,16]
                    },
                    Repassword :{
                        required : true,
                        equalTo : password
                    }
                },

                messages : {
                    username: {
                        required : "这玩意得填啊",
                        rangelength : "最少{0}位,最多{1}位,不识字请重新开始九年义务教育"
                    },
                    password : {
                        required : "把密码写上",
                        rangelength : "最少{0}位,最多{1}位"
                    },
                    Repassword :{
                        required : "请填写<确认密码>",
                        equalTo : "<密码和确认密码不一致啊>"
                    }
                }

            });

        });
    </script>
    <style type="text/css">
        label{
            color: #034c50;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/login?method=usernameIsExist" method="post" id="registForm">
    <table>
        <tr>
            <td>用户名:</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>

        <tr>
            <td>密码:</td>
            <td>
                <input type="password" name="password" id="password">
            </td>
        </tr>

        <tr>
            <td>确认密码:</td>
            <td>
                <input type="password" name="Repassword">
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
