<#import "parts/common.ftl" as c>
<#import "parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h2><@spring.message "admincabinet.title"/></h2>
    <h3><@spring.message "admincabinet.userlist.indication"/></h3>

<#--    <table>-->
<#--        <thead>-->
<#--        <tr>-->
<#--            <th>Id</th>-->
<#--            <th>Name</th>-->
<#--            <th>Role</th>-->
<#--        </tr>-->
<#--        </thead>-->

<#--        <tbody>-->
<#--        <#list users as user>-->
<#--            <tr>-->
<#--                <td>${user.id}</td>-->
<#--                <td>${user.username}</td>-->
<#--                <td><#list user.roles as role>${role}<#sep>, </#list></td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--        </tbody>-->
<#--    </table>-->

    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <@l.logout />

    <p></p>
    <a href="/main_authenticated"><@spring.message "main.page.link"/></a>

</@c.page>