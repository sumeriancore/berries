<#import "parts/common.ftl" as common>

<@common.page>
    List of users
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Active</th>
            <th scope="col">Login</th>
            <th scope="col">Password</th>
            <th scope="col">Roles</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
    <tbody>
        <#list users as user>
            <tr>
                <th scope="row">${user.id}</th>
                <td>${user.active?string('yes', 'no')}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td><#list user.roles as role>
                      ${role}<#sep> ,
                    </#list>
                 </td>
                <td><a href="/admin/users/${user.id}">edit</a></td>
            </tr>
        </#list>
    </tbody>
    </table>
</@common.page>