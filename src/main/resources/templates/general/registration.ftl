<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring />

<@c.page>
    <h3><@spring.message "registration.page.title"/></h3>

    <#if errorMessage??>
        <h4 class="error"><@spring.message "${errorMessage}"/></h4>
    </#if>

    <@l.registration "/registration" />

    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <a href="/"><@spring.message "main.return.link"/></a>

</@c.page>