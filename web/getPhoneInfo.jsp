<%--
  Created by IntelliJ IDEA.
  User: NianShuo_O
  Date: 2021/1/6
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>手机信息展示页面</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script>
</head>
<body>
<table border="1px" cellspacing="0">
    <tr>
        <td colspan="6"><center>手机信息展示</center></td>
        <td colspan="2" style="text-align: right">
            <input type="button" value="增加数据" onclick="addIt()">
            <input type="button" value="批量删除(JS)" onclick="deleteSome()">
            <input type="button" value="批量删除(JQ)" onclick="deleteSome2()">
        </td>
    </tr>
    <tr>
        <th>
            <input type="button" value="反选" onclick="reverse()">
        </th>
        <th>手机序号</th>
        <th>手机品牌</th>
        <th>手机分类</th>
        <th>手机价格</th>
        <th>手机颜色</th>
        <th>手机生产日期</th>
        <th>操作</th>
    </tr>
    <%--此时plist已经变成了pb的一个属性了,需要使用点的形式去引用--%>
    <c:if test="${not empty pb.plist}">
        <c:forEach items="${pb.plist}" var="p">
            <tr>
                <td>
                    <input type="checkbox" name="checkboxs" value="${p.pid}">
                </td>
                <td>${p.pid}</td>
                <td>${p.pname}</td>
                <td>
                        <c:if test="${p.ptype == 1}">智能机</c:if>
                        <c:if test="${p.ptype == 2}">老年机</c:if>

                </td>
                <td>${p.pprice}</td>
                <td>
                    <c:if test="${p.pcolor == 1}">红色</c:if>
                    <c:if test="${p.pcolor == 2}">黑色</c:if>
                    <c:if test="${p.pcolor == 3}">蓝色</c:if>
                    <c:if test="${p.pcolor == 4}">白色</c:if>
                </td>
                <td>${p.pdate}</td>
                <td>
                    <a onclick="let delTo=(confirm('确认删除吗?我的老baby')); return delTo" href="${pageContext.request.contextPath}/phone?method=deleteIt&pid=${p.pid}">删除</a>
                    <a href="${pageContext.request.contextPath}/phone?method=updateShow&pid=${p.pid}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <tr>
        <td colspan="8">
            <c:if test="${pb.pageNumber != 1}">
                <a href="${pageContext.request.contextPath}/phone?method=getPhoneInfo&pageNumber=${pb.pageNumber - 1}">上一页</a>
            </c:if>
            <%--begin 开始值 ,  end : 结束值--%>
            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <a href="${pageContext.request.contextPath}/phone?method=getPhoneInfo&pageNumber=${i}">${i}</a>
            </c:forEach>

            <c:if test="${pb.totalPage != pb.pageNumber}">
                <a href="${pageContext.request.contextPath}/phone?method=getPhoneInfo&pageNumber=${pb.pageNumber  + 1}">下一页</a>
            </c:if>
        </td>
    </tr>





</table>
</body>
</html>
<script type="text/javascript">
    function addIt() {
        location.href = "${pageContext.request.contextPath}/addIt.jsp"
    }

    function reverse() {
        let checkeds = $("[type=checkbox]:checked");    //已选中的
        let notCheckeds = $("[type=checkbox]:not([type=checkbox]:checked)");  //未选中的
        checkeds.prop("checked",false);
        notCheckeds.prop("checked",true);

    }

    function deleteSome() {
        let checkboxs = document.getElementsByName("checkboxs");//注意看清,取的是name属性!!!
        let str = "";
        for (let i = 0; i < checkboxs.length; i++) {
            if (checkboxs[i].checked == true){
                str += "'" + checkboxs[i].value + "',";
            }
        }
        let pids = str.substring(0,str.length - 1);
        // alert(pids);
        location.href = "${pageContext.request.contextPath}/phone?method=deleteSome&pid="+pids;
    }

    function deleteSome2() {
        //使用jQuery
        let $checkboxs = $("[type=checkbox]:checked");  //数组
        let str = "";
        $.each($($checkboxs),function (i) {
            alert("要删除的手机序号为:" + this.value);
            str +=  this.value + ",";
        })
        let pids = str.substring(0,str.length - 1);
        location.href = "${pageContext.request.contextPath}/phone?method=deleteSome&pid="+pids;
        // ocalhost:8080/day21_hw/phone?method=deleteSome&pid=%2731,%27%2730,
    }




</script>
