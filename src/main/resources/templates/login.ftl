<#import "parts/common.ftl" as c>
<#import "parts/log_in_out.ftl" as l>

<@c.page>
    Login page
    <@l.login "/login" />
    <a href="/registration">Add new user</a>
</@c.page>