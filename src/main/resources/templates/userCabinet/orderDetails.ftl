<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h3><@spring.message "usercabinet.orderdetails.title"/></h3>

    <table border="0.5">
        <thead>
            <tr>
                <th><@spring.message "usercabinet.orderdetails.data"/></th>
                <th><@spring.message "usercabinet.orderdetails.information"/></th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td><@spring.message "order.number"/></td>
                <td>${order.orderNumber}</td>
            </tr>
            <tr>
                <td><@spring.message "order.dispatch.city"/></td>
                <td>${order.dispatchAddress.city}</td>
            </tr>
            <tr>
                <td><@spring.message "order.dispatch.street"/></td>
                <td>${order.dispatchAddress.street}</td>
            </tr>
            <tr>
                <td><@spring.message "order.dispatch.house"/></td>
                <td>${order.dispatchAddress.house}</td>
            </tr>
            <tr>
                <td><@spring.message "order.dispatch.apartment"/></td>
                <td>${order.dispatchAddress.apartment}</td>
            </tr>
            <tr>
                <td><@spring.message "order.delivery.city"/></td>
                <td>${order.deliveryAddress.city}</td>
            </tr>
            <tr>
                <td><@spring.message "order.delivery.street"/></td>
                <td>${order.deliveryAddress.street}</td>
            </tr>
            <tr>
                <td><@spring.message "order.delivery.house"/></td>
                <td>${order.deliveryAddress.house}</td>
            </tr>
            <tr>
                <td><@spring.message "order.delivery.apartment"/></td>
                <td>${order.deliveryAddress.apartment}</td>
            </tr>
            <tr>
                <td><@spring.message "order.delivery.date"/></td>
                <td>${order.deliveryDate}</td>
            </tr>
            <tr>
                <td><@spring.message "order.weight"/></td>
                <td>${order.weight}</td>
            </tr>
            <tr>
                <td><@spring.message "order.cargo"/></td>
                <td>${order.cargoType}</td>
            </tr>
            <tr>
                <td><@spring.message "order.sum"/></td>
                <td>${order.sum}</td>
            </tr>
            <tr>
                <td><@spring.message "order.status"/></td>
                <td>${order.orderStatus}</td>
            </tr>
        </tbody>
    </table>

    <p></p>

    <form action="/user/invoicedOrders/${order.orderNumber}" method="post">
         <div>
             <input type="submit" value="<@spring.message "usercabinet.invoice.payment.button"/>">
         </div>
    </form>

    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <@l.logout />

    <p></p>
    <a href="/"><@spring.message "main.page.link"/></a>

</@c.page>