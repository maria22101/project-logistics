<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h2><@spring.message "admincabinet.title"/></h2>

    <a href="/admin/orders"><@spring.message "cabinet.orderlist.link"/></a><br><br>
    <a href="/admin/open_orders"><@spring.message "admincabinet.open.orderlist.link"/></a><br><br>
    <a href="/admin/users"><@spring.message "admincabinet.userlist.link"/></a><br><br>
    <a href="/admin/routes"><@spring.message "admincabinet.routelist.link"/></a>

    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <@l.logout />

    <p></p>
    <a href="/"><@spring.message "main.page.link"/></a>

</@c.page>