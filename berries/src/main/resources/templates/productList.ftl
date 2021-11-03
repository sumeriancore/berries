<#import "parts/common.ftl" as common>

<@common.page>
    <button id="myBtn" class="btn btn-secondary btn-sm">Add Product</button>

    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
                <form action="/admin/products" method="post">
                    <div class="form-group">
                        <label for="productName">Product Name</label>
                        <input type="text" class="form-control" id="productName" name="productName" aria-describedby="emailHelp" placeholder="Enter product name">
                    </div>
                    <div class="form-group">
                        <label for="price">Price</label>
                        <input type="text" class="form-control" id="price" name="price" placeholder="Price">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
        </div>
    </div>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Product Name</th>
        <th scope="col">Price</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <tr>
            <th scope="row" id="id">${product.id}</th>
            <td id="productName">${product.productName}</td>
            <td id="price">${product.price}</td>
            <td>
                <button id="myBtnEdit" class="btn btn-secondary btn-sm" name="myBtnEdit" value="${product.id}">Edit</button>
            </td>
        </tr>
        <@common.productEditForm product>
        </@common.productEditForm>
    </#list>
    </tbody>
</table>
</@common.page>