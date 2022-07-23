<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Users List</div>
    <div>
      <table>
        <thead>
          <th>Name</th>
          <th>Role</th>
        </thead>
        <tbody>
        <#list users as user>
           <td>${user.username}</td>
           <td><#list user.roles as role>${role}<#sep>, </#list></td>
           <td><a href="/users/${user.id}">EDIT</a></td>
        </#list>
        </tbody>
      </table>
    </div>

</@c.page>