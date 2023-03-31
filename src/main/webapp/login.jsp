<%--
  Created by IntelliJ IDEA.
  User: 11732
  Date: 2023/3/31
  Time: 17:27
  To change this template use File | Settings | File Templates.
  <form action="/LoginServlet" method="post">
          用户名:<input type="text", name="account"><br/>
          密码:<input type="text", name="password"><br/>
        <input type="submit", value="登录">
        <button>注册</button>
        </form>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link type="text/css" href="/css/login.css" rel="stylesheet">
</head>
<body>
    <div>
      <div class="card">
        <div class="container">
            <form class="form" action="/LoginServlet" method="post">
                用户名:<input  type="text", name="account"><br/><br/>
                密码:<input type="text", name="password"><br/><br/>
                <input type="submit", value="登录">
                <button>注册</button>
            </form>
        </div>
      </div>
    </div>

</body>
</html>
