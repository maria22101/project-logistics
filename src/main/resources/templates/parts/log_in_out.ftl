<#import "/spring.ftl" as spring/>

<#macro login path>
    <form action="${path}" method="post">
        <div><label> <@spring.message "login.user_name.indication"/> <input type="text" name="username"/> </label></div>
        <div><label> <@spring.message "login.password.indication"/> <input type="password" name="password"/> </label></div>
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
        <div><input type="submit" value=<@spring.message "login.log_in.on.button"/>></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
        <input type="submit" value=<@spring.message "logout.log_out.on.button"/>>
    </form>
</#macro>