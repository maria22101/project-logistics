<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h3><@spring.message "admincabinet.open.orderlist.title"/></h3>

    <table border="0.5">
        <thead>
        <tr>
            <th><@spring.message "order.number"/></th>
            <th><@spring.message "name.indication"/></th>
            <th><@spring.message "surname.indication"/></th>
            <th><@spring.message "email.indication"/></th>
            <th><@spring.message "order.dispatch.city"/></th>
            <th><@spring.message "order.delivery.city"/></th>
            <th><@spring.message "order.weight"/></th>
            <th><@spring.message "order.cargo"/></th>
            <th><@spring.message "order.sum"/></th>
            <th><@spring.message "order.status"/></th>
            <th><@spring.message "order.action"/></th>
        </tr>
        </thead>
        <tbody>
        <#list openOrders as order>
            <tr>
                <td>${order.orderNumber}</td>
                <td>${order.user.name}</td>
                <td>${order.user.surname}</td>
                <td>${order.user.email}</td>
                <td>${order.route.pointOne}</td>
                <td>${order.route.pointTwo}</td>
                <td>${order.weight}</td>
                <td>${order.cargoType}</td>
                <td>${order.sum}</td>
                <td>${order.orderStatus}</td>

                <td>
                    <form action="/admin/open_orders" method="post">
                        <div>
                            <input type="hidden" value="${order.orderNumber}" name="orderNumber">
                            <input type="submit" value="<@spring.message "admincabinet.issue.invoice.button"/>">
                        </div>
                    </form>
                </td>

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