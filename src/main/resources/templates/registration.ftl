<#import "parts/common.ftl" as c>
<#import "parts/log_in_out.ftl" as l>
<#import "/spring.ftl" as spring />

<@c.page>
    <h4><@spring.message "registration.page.title"/></h4>
    <@l.login "/registration" />

    <p></p>

    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>

    <a href="/"><@spring.message "main.return.link"/></a>

</@c.page>