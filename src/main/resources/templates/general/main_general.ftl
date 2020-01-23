<#import "../parts/common.ftl" as c>
<#import "../parts/main.ftl" as m>
<#import "/spring.ftl" as spring/>

<@c.page>

    <@m.main />

    <br>
    <span><@spring.message "main.login.indication"/></span>
    <a href="/login"><@spring.message "main.login.link"/></a><br>

    <span><@spring.message "main.registration.indication"/></span>
    <a href="/registration"><@spring.message "main.registration.link"/></a>

</@c.page>