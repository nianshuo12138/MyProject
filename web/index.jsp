<%--
  Created by IntelliJ IDEA.
  User: NianShuo_O
  Date: 2021/1/6
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户登录页面</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script>
      <script type="text/javascript">
          $(function () {
              $("#f1").validate({
                  rules : {
                      username : {
                          required : true,
                          rangelength : [4,16]

                      },
                      password : {
                          required: true,
                          rangelength : [4,16]
                      },
                      checkCode : {
                          required : true,
                          rangelength : [4,4]
                      }
                  },
                messages:{
                  username : {
                    required : "账号不能为空!",
                    rangelength : "账号长度4-16位啊"

                  },
                  password : {
                    required: "密码不能为空",
                    rangelength : "密码长度4-16位啊"
                  },
                  checkCode : {
                    required : "验证码不能为空啊",
                    rangelength : "验证码只能{0}位"
                  }
                }
              });

          });
      </script>
    <style type="text/css">
      label{
        color: blueviolet;
      }
    </style>
  </head>
  <body onload="checkImg()">
  <form action="${pageContext.request.contextPath}/login?method=loginCheck" method="post" id="f1">
    <table>
      <tr>
        <td>账号:</td>
        <td>
          <input type="text" name="username" placeholder="账号长度4-16位">
        </td>
      </tr>
      <tr>
        <td>密码:</td>
        <td>
          <input type="text" name="password"  placeholder="密码长度4-16位">
        </td>
      </tr>
      <tr>
        <td>
          <img src="${pageContext.request.contextPath}/code" alt="图片没加载出来~" onclick="checkImg()" id="chImg">
        </td>
        <td>
          <input type="text" name="checkCode" placeholder="4位,输错了顺着网线来打你">
        </td>
      </tr>
      <tr>
        <td colspan="2" style="text-align: center">
          <input type="submit" value="登录">

          <input type="button" value="注册" onclick="regist()" >
        </td>
      </tr>
    </table>
  </form>

  <a href="${pageContext.request.contextPath}/phone?method=getPhoneInfo&pageNumber=1">点击查看手机信息</a>
  </body>
</html>
<script type="text/javascript">
  function checkImg() {
    let img = document.getElementById("chImg");
    img.src = "${pageContext.request.contextPath}/code?time=" +new Date().getTime();

  }


  function regist() {
    location.href = "${pageContext.request.contextPath}/registIt.jsp"

  }
</script>
