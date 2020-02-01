<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h2><@spring.message "usercabinet.title"/>${name}!</h2>

    <a href="/user/orders"><@spring.message "cabinet.orderlist.link"/></a><br><br>
    <a href="/user/invoicedOrders"><@spring.message "usercabinet.invoiced.orderlist.link"/></a><br><br>
    <a href="/user/placeOrder"><@spring.message "usercabinet.order.creation.link"/></a>

    <p></p>
    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <p></p>
    <@l.logout />

    <p></p>
    <a href="/main_authenticated"><@spring.message "main.page.link"/></a>

</@c.page>