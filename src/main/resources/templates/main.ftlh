<#import "parts/common.ftlh" as c>
<@c.page>
<div>
    <form action="/main" method="post" enctype="multipart/form-data">
        <label for="">Text</label>
        <input type="text" name="text" />
        <label for="">Tag</label>
        <input type="text" name="tag">
        <label for="">Photo</label>
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Add">
    </form>
    <#list messages as message>
        <div>
            <#if message.filename??>
                <img src="/img/${message.filename}" alt="">
            </#if>
        </div>
        <span>${message.text}</span>
        <i>${message.tag}</i>
    <#else>
        No Messages
    </#list>
</div>
</@c.page>