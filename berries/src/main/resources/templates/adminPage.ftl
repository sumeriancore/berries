<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <title>BlueBerries BY</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../static/css/style.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <div class="shopName">
                <h1 class="navbar-brand">
                    BlueBerry
                </h1>
            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <div class="ni-1">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/main">Main</a>
                        </li>
                    </div>
                    <div class="ni-2">
                        <li class="nav-item" id="reg">
                            <a class="nav-link active" href="/registration">Registration</a>
                        </li>
                    </div>
                    <div class="ni-2">
                        <li class="nav-item">
                            <a class="nav-link active" href="/products">Products</a>
                        </li>
                    </div>
                    <div class="ni-2">
                        <li class="nav-item">
                            <a class="nav-link active" href="/admin">Admin</a>
                        </li>
                    </div>
                </ul>
            </div>
        </div>
    </nav>
</header>
<form action="/admin" method="post">
    <p>Product Name: <input type="text" name="productName" /></p>
    <p>Price: <input type="text" name="price"/></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
<#list products as product>
    <div>
        <b>${product.productName}</b>
        <span>${product.price}</span>
    </div>
</#list>
</body>
</html>