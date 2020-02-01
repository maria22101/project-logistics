<#import "/spring.ftl" as spring/>

<#macro main>

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

            <#if .locale?starts_with("ua")>
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

</#macro>