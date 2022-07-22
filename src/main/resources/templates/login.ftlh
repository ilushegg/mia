<#import "parts/common.ftlh" as c>
<@c.page>
    <form action="/login" method="post">
        <div class="">
            <label>Username: </label>
            <input type="text" name="username" />
            <label>Password: </label>
            <input type="password" name="password" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="submit" value="Sign In"/>
        </div>
    </form>

    <#include "parts/logout.ftlh">
</@c.page>
