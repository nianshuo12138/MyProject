<%--
  Created by IntelliJ IDEA.
  User: NianShuo_O
  Date: 2021/1/7
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function () {

            let $typeText = $("[type=text]");
            $.each($($typeText),function (i) {
                // alert(i);
                // alert(this.value);
                // alert($(this).val());

            })

        })
    </script>
</head>
<body>
框1:<input type="text" name="inp1" id="inp1" class="inputClass1" value="吃饭"> <br>
框2:<input type="text" name="inp2" id="inp2" value="睡觉"> <br>
框3:<input type="text" name="inp3" id="inp3" value="打泡泡"> <br>
框3:<input type="button" name="btn1" id="btn1"> <br>
</body>
</html>
