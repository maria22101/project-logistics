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

<#macro delivery_order_creation path>

<#--    <@spring.bind "orderDTO" />-->
<#--    <form action="${path}" method="post">-->
<#--        <div><label> <@spring.message "order.source"/> <input type="text" name="source"/> </label></div>-->
<#--        <div><label> <@spring.message "order.destination"/> <input type="text" name="destination"/> </label></div>-->
<#--        <div><label> <@spring.message "order.delivery.date"/> <input type="text" name="deliveryDate"/> </label></div>-->
<#--        <div><label> <@spring.message "order.weight"/> <input type="text" name="weight"/> </label></div>-->
<#--        <div><label> <@spring.message "order.cargo"/> <input type="text" name="cargo"/> </label></div>-->
<#--        <div><input type="submit" value=<@spring.message "order.placing.button"/>></div>-->
<#--    </form>-->

    <@spring.bind "orderDTO"/>
    <#if orderDTO?? && noErrors??>
        Your submitted data<br>
        First name: ${orderDTO.source}<br>
        Last name: ${orderDTO.destination}<br>
    <#else>
        <form action="${path}" method="post">

            <@spring.message "order.route.source"/><br>
            <@spring.formInput "orderDTO.source"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.route.destination"/><br>
            <@spring.formInput "orderDTO.destination"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.delivery.date"/><br>
            <@spring.formInput "orderDTO.deliveryDate"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.weight"/><br>
            <@spring.formInput "orderDTO.weight"/>
            <@spring.showErrors "<br>"/><br><br>

            <input type="submit" value="Submit">
        </form>
    </#if>
</#macro>

