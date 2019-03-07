<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>
<style>
    em {
        color: red;
    }
</style>
<body>
<a href="javaScript:void(0)" onclick="last()">上一页</a><h1 align="center"> 查询结果展示</h1>
<a href="javaScript:void(0)" onclick="next()">下一页</a>
<hr>
<a href="../index.jsp">返回检索</a>
<table align="center" border="0" bgcolor="#faebd7" >
<#list poem as p>
    <tr>
        <td>
            ${p.title}
        </td>
    </tr>
    <tr>
        <td>
            ${p.name}
        </td>
    </tr>
    <tr>
        <td>
            ${p.content}<br><br>
        </td>
    </tr>

</#list>
</table>
<br>

<script>
    function last() {
        if (${page?number}==1){
            return;
        }
        var i = ${page?number}-1;
        window.location = "http://127.0.0.1:8008/Poem/poem/find?start="+i+"&name=${name}&id=${id}";
    }
    function next() {
        var i = ${page?number}+1;
        window.location = "http://127.0.0.1:8008/Poem/poem/find?start="+i+"&name=${name}&id=${id}";
    }
</script>


</body>
</html>