<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/jquery.min1.3.5.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easyui.min1.3.5.js"></script>
<script src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN1.3.5.js"></script>
<link href="${pageContext.request.contextPath}/themes1.3.5/icon.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/themes1.3.5/default/easyui.css" rel="stylesheet" type="text/css">
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div align="center"><h1>唐诗检索系统</h1></div>
  <hr/>
  <div align="center" style="margin-top: 200px">
        <form name="form" action="${pageContext.request.contextPath}/poem/find" method="post">
            <input type="text" name="name"><input type="submit" value="搜索">
            <br>
            <input type="radio" value="1" name="id" checked="checked">查作者
            <input type="radio" value="2" name="id">查标题
            <input type="radio" value="3" name="id">查内容
        </form>
  </div>
  </body>
</html>
