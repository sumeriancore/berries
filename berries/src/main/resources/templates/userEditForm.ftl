<#import "parts/common.ftl" as common>

<@common.page>
    User Editor
    <form action="/admin" method="post">
        <input type="hidden" value="${user.id}" name="id">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string('checked', '')}>${role}</label>
            </div>
        </#list>
        <input type="text" name="username" value="${user.username}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Save</button>
    </form>
</@common.page>