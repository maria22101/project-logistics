<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
    <h4><@spring.message "login.page.title"/></h4>
    <@l.login "/login" />

    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <a href="/"><@spring.message "main.page.link"/></a>

</@c.page>