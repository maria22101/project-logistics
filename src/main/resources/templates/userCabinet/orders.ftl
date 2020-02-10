<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h3><@spring.message "cabinet.orderlist.title"/></h3>

    <table border="0.5">
        <thead>
        <tr>
            <th><@spring.message "order.number"/></th>
            <th><@spring.message "order.dispatch.city"/></th>
            <th><@spring.message "order.dispatch.street"/></th>
            <th><@spring.message "order.dispatch.house"/></th>
            <th><@spring.message "order.dispatch.apartment"/></th>
            <th><@spring.message "order.delivery.city"/></th>
            <th><@spring.message "order.delivery.street"/></th>
            <th><@spring.message "order.delivery.house"/></th>
            <th><@spring.message "order.delivery.apartment"/></th>
            <th><@spring.message "order.delivery.date"/></th>
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
                <td>${order.dispatchAddress.city}</td>
                <td>${order.dispatchAddress.street}</td>
                <td>${order.dispatchAddress.house}</td>
                <td>${order.dispatchAddress.apartment}</td>
                <td>${order.deliveryAddress.city}</td>
                <td>${order.deliveryAddress.street}</td>
                <td>${order.deliveryAddress.house}</td>
                <td>${order.deliveryAddress.apartment}</td>
                <td>${order.deliveryDate}</td>
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
    <a href="/"><@spring.message "main.page.link"/></a>

</@c.page>