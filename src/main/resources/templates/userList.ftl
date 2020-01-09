<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>

<@c.page>

<h2>List of Users</h2>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Role</th>
    </tr>
    </thead>

    <tbody>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
        </tr>
    </#list>
    </tbody>
</table>

</@c.page>