<#import "../parts/common.ftl" as c>
<#import "/spring.ftl" as spring />

<@c.page>
    <h3 class="error"><@spring.message "login.fail.message"/></h3>

    <a href="/login"><@spring.message "main.login.link"/></a>

</@c.page>