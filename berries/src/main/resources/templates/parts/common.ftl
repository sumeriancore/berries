<#macro page>
    <!DOCTYPE HTML>
    <html xmlns="http://www.w3.org/1999/xhtml"  lang="en">
    <head>
        <title>BlueBerries BY</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="/static/css/style.css">
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
                                <a class="nav-link active" href="/admin/products">Products</a>
                            </li>
                        </div>
                        <div class="ni-2">
                            <li class="nav-item">
                                <a class="nav-link active" href="/admin/users">Users</a>
                            </li>
                        </div>
                        <div class="ni-2">
                            <li class="nav-item">
                                <a class="nav-link active" href="/logout">Log Out</a>
                            </li>
                        </div>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <#nested >
    </body>
    <script type="text/javascript" src="/static/js/index.js"></script>
</html>
</#macro>


<#macro htmlDoc>
    <!DOCTYPE HTML>
    <html xmlns="http://www.w3.org/1999/xhtml"  lang="en">
    <head>
        <title>BlueBerries BY</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="../static/css/style.css">
    </head>
    <body>
    <#nested >
    </body>
    </html>
</#macro>

<#macro productEditForm product>
    <div id="${product.id}" class="modal">
        <div class="modal-content">
            <span class="closeEdit">&times;</span>
            <form action="/admin/product/${product.id}/edit" method="post">
                <input type="hidden" class="form-control" id="id" name="id"
                       value="${product.id}">
                <div class="form-group">
                    <label for="productName">Product Name</label>
                    <input type="text" class="form-control" id="productName" name="productName" aria-describedby="emailHelp"
                    value="${product.productName}">
                </div>
                <div class="form-group">
                    <label for="price">Edit Price</label>
                    <input type="text" class="form-control" id="price" name="price" value="${product.price}">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
        </div>
    </div>
</#macro>

<#macro loginOrRegistration path>
    <div class="back-image">
        <div class="back">
            <div class="reg-form-div">
                <form action="${path}" method="post">
                    <div class="mb-3">
                        <label for="userEmail" class="form-label">Email address</label>
                        <input type="text" class="form-control" name="username">
                    </div>
                    <div class="mb-4">
                        <label for="userPassword" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password">
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" id="logRegBtn" class="btn">Submit</button>
                </form>
            </div>
        </div>
    </div>
</#macro>

<#macro deleteProductForm product>
    <form action="/admin/product/${product.id}/delete" method="post">
        <input type="hidden" class="form-control" id="id" name="id" value="${product.id}">
        <input type="hidden" class="form-control" id="productName" name="productName" value="${product.productName}">
        <input type="hidden" class="form-control" id="price" name="price" value="${product.price}">
        <button type="submit" class="btn btn-primary">Delete</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</#macro>