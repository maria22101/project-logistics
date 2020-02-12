<#import "../parts/common.ftl" as c>
<#import "/spring.ftl" as spring />

<@c.page>
    <h3 class="error"><@spring.message "${errorMessage}"/></h3>

    <a href="/login"><@spring.message "main.login.link"/></a>
    <br/><br/>
    <a href="/registration"><@spring.message "main.registration.link"/></a>
    <br/><br/>
    <a href="/"><@spring.message "main.page.link"/></a>

</@c.page>