<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h3><@spring.message "admincabinet.orderlist.title"/></h3>

    <table border="0.5">
        <thead>
        <tr>
            <th><@spring.message "admincabinet.order.number"/></th>
            <th><@spring.message "admincabinet.order.username"/></th>
            <th><@spring.message "admincabinet.order.source"/></th>
            <th><@spring.message "admincabinet.order.destination"/></th>
            <th><@spring.message "admincabinet.order.weight.rate"/></th>
            <th><@spring.message "admincabinet.order.cargo"/></th>
            <th><@spring.message "admincabinet.order.sum"/></th>
            <th><@spring.message "admincabinet.order.status"/></th>
        </tr>
        </thead>
        <tbody>
        <#list orders as o>
            <tr>
                <td>${o.orderNumber}</td>
                <td>${o.user.username}</td>
                <td>${o.route.source}</td>
                <td>${o.route.destination}</td>
                <td>${o.weightRate.weightCategory}</td>
                <td>${o.cargoType}</td>
                <td>${o.sum}</td>
                <td>${o.orderStatus}</td>
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