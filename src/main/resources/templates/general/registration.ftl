<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring />

<@c.page>
    <h3><@spring.message "registration.page.title"/></h3>

    <@l.registration "/registration" />

    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <a href="/"><@spring.message "main.page.link"/></a>

</@c.page>