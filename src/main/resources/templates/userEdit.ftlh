<#import "parts/common.ftlh" as c>

<@c.page>
    <div>User Editor</div>
    <div>${user.username}</div>
    <label>The user roles: <#list user.roles as role>${role}<#sep>, </#list></label>
    <form action="/users" method="post">
        <input type="text" value="${user.username}" name="username" />
        <#list roles as role>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")} >${role}</label>
        </#list>
        <input type="hidden" name="userId" value="${user.id}"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Save">
    </form>
</@c.page>