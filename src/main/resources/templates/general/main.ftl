<#import "../parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h2><@spring.message "main.title"/></h2>

    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <h3><@spring.message "main.services"/></h3>

    <table border="0.5">
        <thead>
        <tr>
            <th><@spring.message "main.from"/></th>
            <th><@spring.message "main.to"/></th>
            <th><@spring.message "main.cost"/></th>
        </tr>
        </thead>
        <tbody>
        <#list routes as route>

            <#if .locale?starts_with("UA")>
                <tr>
                    <td>${route.sourceUA}</td>
                    <td>${route.destinationUA}</td>
                    <td>${route.basicRate}</td>
                </tr>
            <#else>
                <tr>
                    <td>${route.source}</td>
                    <td>${route.destination}</td>
                    <td>${route.basicRate}</td>
                </tr>
            </#if>

        </#list>
        </tbody>
    </table>

    <br>
    <span><@spring.message "main.login.indication"/></span>
    <a href="/login"><@spring.message "main.login.link"/></a>

    <br/><br/>

    <span><@spring.message "main.registration.indication"/></span>
    <a href="/registration"><@spring.message "main.registration.link"/></a>

</@c.page>