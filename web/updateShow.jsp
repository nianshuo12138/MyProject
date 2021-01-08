<%--
  Created by IntelliJ IDEA.
  User: NianShuo_O
  Date: 2021/1/6
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>回显页面并在此修改</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script>
    <script src="My97DatePicker/WdatePicker.js"></script>

</head>
<body>

<form action="${pageContext.request.contextPath}/phone?method=updateIt&pid=${p.pid}" method="post">
    <table>
        <tr>
            <td>手机品牌:</td>
            <td>
                <input type="text" name="pname" value="${p.pname}">
            </td>
        </tr>

        <tr>
            <td>手机分类:</td>
            <td>
                <input type="radio" name="ptype" value="${p.ptype}" <c:if test="${p.ptype == 1}">checked</c:if>>智能机
                <input type="radio" name="ptype" value="${p.ptype}" <c:if test="${p.ptype == 2}">checked</c:if>>老年机

            </td>
        </tr>

        <tr>
            <td>手机价格:</td>
            <td>
                <input type="text" name="pprice" value="${p.pprice}">
            </td>
        </tr>

        <tr>
            <td>手机颜色:</td>
            <td>
                <select name="pcolor">
                    <option value="1" <c:if test="${p.pcolor==1}" >selected</c:if> >红色</option>
                    <option value="2"  <c:if test="${p.pcolor==2}" >selected</c:if> >黑色</option>
                    <option value="3"  <c:if test="${p.pcolor==3}" >selected</c:if> >蓝色</option>
                    <option value="4"  <c:if test="${p.pcolor==4}" >selected</c:if> >白色</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>手机出厂日期:</td>
            <td>
                    <input type="text" name="pdate" value="${p.pdate}" id="dateIn">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确认修改">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
<script type="text/javascript">
    $(function () {

        $("#dateIn").click(function () {
            WdatePicker({maxDate : "%y-%M-%d"});

        })
    });


</script>