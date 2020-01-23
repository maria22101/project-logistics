<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h2><@spring.message "admincabinet.title"/></h2>

<#--    <a href="/"><@spring.message "admincabinet.orderlist.link"/></a>-->
    <a href="/admin/users"><@spring.message "admincabinet.userlist.link"/></a>
<#--    <a href="/"><@spring.message "admincabinet.routelist.link"/></a>-->
<#--    <a href="/"><@spring.message "admincabinet.weight.rates.link"/></a>-->

    <p></p>
    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>
    <a href="?lang=ua"><@spring.message "lang.ua"/></a>

    <p></p>
    <@l.logout />

    <p></p>
    <a href="/main_authenticated"><@spring.message "main.page.link"/></a>

</@c.page>