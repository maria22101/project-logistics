<#import "../parts/common.ftl" as c>
<#import "../parts/forms.ftl" as l>
<#import "/spring.ftl" as spring/>

<@c.page>

    <h3><@spring.message "admincabinet.userlist.indication"/></h3>

    <table border="0.5">
        <thead>
        <tr>
            <th><@spring.message "admincabinet.user.id"/></th>
            <th><@spring.message "admincabinet.user.username"/></th>
            <th><@spring.message "admincabinet.user.email"/></th>
            <th><@spring.message "admincabinet.user.role"/></th>
        </tr>
        </thead>
        <tbody>
        <#list allUsers as u>
            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.email}</td>
                <td>${u.role}</td>
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