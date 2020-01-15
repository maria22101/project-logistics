<#import "/spring.ftl" as spring/>

<#macro registration path>
    <form action="${path}" method="post">
        <div><label> <@spring.message "user_name.indication"/> <input type="text" name="username"/> </label></div>
        <div><label> <@spring.message "email.indication"/> <input type="text" name="email"/> </label></div>
        <div><label> <@spring.message "password.indication"/> <input type="password" name="password"/> </label></div>
        <div><input type="submit" value=<@spring.message "registration.button"/>></div>
    </form>
</#macro>

<#macro login path>
    <form action="${path}" method="post">
        <div><label> <@spring.message "user_name.indication"/> <input type="text" name="username"/> </label></div>
        <div><label> <@spring.message "password.indication"/> <input type="password" name="password"/> </label></div>
        <div><input type="submit" value=<@spring.message "login.button"/>></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="submit" value=<@spring.message "logout.button"/>>
    </form>
</#macro>

