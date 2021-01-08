<%--
  Created by IntelliJ IDEA.
  User: NianShuo_O
  Date: 2021/1/6
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>数据增加页面</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script>
    <script src="My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#addItForm").validate({
                rules : {
                    pname : {
                        required : true,
                        rangelength : [2,16]
                    },
                    pprice : {
                        required : true,
                        range : [199,19999]
                    }
                },
                messages : {
                    pname : {
                        required :  "必填!!!",
                        rangelength : "手机名字在 2~16位之间"
                    },
                    pprice : {
                        required : "价格必填!!!!",
                        range : "价格区间在 199 ~ 19999"
                    },
                    pdate : {
                        required : true,
                        date : true
                    }
                }
            });

        });

        $(function () {

            $("#dateIn").click(function () {
                // WdatePicker({dateFmt:"yyyy-MM-dd",maxDate :" %y-%M-%d"})
                WdatePicker({maxDate:"%y-%M-%d"});
            });
        });
    </script>

</head>
<body>
数据增加页面
<form action="${pageContext.request.contextPath}/phone?method=addIt" method="post" id="addItForm">
    <table>
        <tr>
            <td>手机品牌 : </td>
            <td>
                <input type="text" name="pname" placeholder="2-16位啊小伙纸">
            </td>
        </tr>

        <tr>
            <td>手机分类 : </td>
            <td>
                <input type="radio" name="ptype" value="1" checked>智能机
                <input type="radio" name="ptype" value="2">老年机
            </td>
        </tr>

        <tr>
            <td>手机价格 : </td>
            <td>
                <input type="text" name="pprice" placeholder="价格区间:199~19999">
            </td>
        </tr>

        <tr>
            <td>手机颜色 : </td>
            <td>
                <select name="pcolor">
                    <option value="1">红色</option>
                    <option value="2">黑色</option>
                    <option value="3">蓝色</option>
                    <option value="4">白色</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>手机生产日期 : </td>
            <td>
                <input type="text" name="pdate"  id="dateIn" onclick="WdatePicker({maxDate: '%y-%M-%d'})">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="增加">
            </td>
        </tr>

    </table>
</form>

</body>
</html>
