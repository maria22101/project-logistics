<#import "parts/common.ftl" as c>
<#import "parts/log_in_out.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h2><@spring.message "usercabinet.title"/>${username}!</h2>
    <h3><@spring.message "usercabinet.orderlist.indication"/></h3>

    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <@l.logout />

</@c.page>