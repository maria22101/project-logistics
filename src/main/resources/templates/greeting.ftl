<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>

<@c.page>
    <div>Hello, user</div>
    <a href="/main">Main page</a>

    <br>

    <h1><@spring.message "title"/></h1>
    <span><@spring.message "lang.change"/></span>

    <a href="?lang=en">
        <@spring.message "lang.eng"/>
    </a>

    <a href="?lang=ua">
        <@spring.message "lang.ua"/>
    </a>
</@c.page>