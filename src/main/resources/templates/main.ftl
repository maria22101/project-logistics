<#import "parts/common.ftl" as c>
<#import "parts/log_in_out.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h2><@spring.message "main.title"/></h2>
    <a href="?lang=en">
        <@spring.message "lang.eng"/>
    </a>
    <br>
    <a href="?lang=ua">
        <@spring.message "lang.ua"/>
    </a>


    <h3><@spring.message "main.services"/></h3>

    <table>
        <thead>
        <tr>
            <th><@spring.message "main.from"/></th>
            <th><@spring.message "main.to"/></th>
            <th><@spring.message "main.cost"/></th>
        </tr>
        </thead>
        <tbody>
        <#list routes as route>
            <tr>
                <td>${route.sourceLocation}</td>
                <td>${route.destinationLocation}</td>
                <td>${route.deliveryCost}</td>
            </tr>
        </#list>
        </tbody>
    </table>

    <br>

    <h4><@spring.message "main.login.indication"/></h4>
    <div>
        <@l.login "/login"/>
    </div>

    <br>

    <h4><@spring.message "main.registration.indication"/></h4>
    <a href="/registration"><@spring.message "main.registration.link"/></a>

</@c.page>