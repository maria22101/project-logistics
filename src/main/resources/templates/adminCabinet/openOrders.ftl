<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h3><@spring.message "admincabinet.open.orderlist.title"/></h3>

    <table border="0.5">
        <thead>
        <tr>
            <th><@spring.message "order.number"/></th>
            <th><@spring.message "order.username"/></th>
            <th><@spring.message "order.route.source"/></th>
            <th><@spring.message "order.route.destination"/></th>
            <th><@spring.message "order.weight"/></th>
            <th><@spring.message "order.cargo"/></th>
            <th><@spring.message "order.sum"/></th>
            <th><@spring.message "order.status"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list openOrders as order>
            <tr>
                <td>${order.orderNumber}</td>
                <td>${order.user.username}</td>
                <td>${order.route.source}</td>
                <td>${order.route.destination}</td>
                <td>${order.weightRate.weightCategory}</td>
                <td>${order.cargoType}</td>
                <td>${order.sum}</td>
                <td>${order.orderStatus}</td>

                <td>
                    <form action="/admin/openOrders" method="post">
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
    <a href="/main_authenticated"><@spring.message "main.page.link"/></a>

</@c.page>