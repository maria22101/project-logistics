<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h3><@spring.message "cabinet.orderlist.title"/></h3>

    <table border="0.5">
        <thead>
        <tr>
            <th><@spring.message "order.number"/></th>
            <th><@spring.message "name.indication"/></th>
            <th><@spring.message "surname.indication"/></th>
            <th><@spring.message "email.indication"/></th>
            <th><@spring.message "order.route.source"/></th>
            <th><@spring.message "order.route.destination"/></th>
            <th><@spring.message "order.weight"/></th>
            <th><@spring.message "order.cargo"/></th>
            <th><@spring.message "order.sum"/></th>
            <th><@spring.message "order.status"/></th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <td>${order.orderNumber}</td>
                <td>${order.user.name}</td>
                <td>${order.user.surname}</td>
                <td>${order.user.email}</td>
                <td>${order.route.source}</td>
                <td>${order.route.destination}</td>
                <td>${order.weight}</td>
                <td>${order.cargoType}</td>
                <td>${order.sum}</td>
                <td>${order.orderStatus}</td>
            </tr>
        </#list>
        </tbody>
    </table>

    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <@l.logout />

    <p></p>
    <a href="/main_authenticated"><@spring.message "main.page.link"/></a>

</@c.page>