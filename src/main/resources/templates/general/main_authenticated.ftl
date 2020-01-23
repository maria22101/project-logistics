<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "../parts/main.ftl" as m>
<#import "/spring.ftl" as spring/>

<@c.page>

    <@m.main />

    <p></p>
    <a href="/cabinet"><@spring.message "cabinet.link"/></a>

    <p></p>
    <@l.logout />

</@c.page>