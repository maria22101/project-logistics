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

<#--    <@spring.bind "deliveryOrderDTO" />-->
<#--    <form action="${path}" method="post">-->
<#--        <div><label> <@spring.message "order.source"/> <input type="text" name="source"/> </label></div>-->
<#--        <div><label> <@spring.message "order.destination"/> <input type="text" name="destination"/> </label></div>-->
<#--        <div><label> <@spring.message "order.delivery.date"/> <input type="text" name="deliveryDate"/> </label></div>-->
<#--        <div><label> <@spring.message "order.weight"/> <input type="text" name="weight"/> </label></div>-->
<#--        <div><label> <@spring.message "order.cargo"/> <input type="text" name="cargo"/> </label></div>-->
<#--        <div><input type="submit" value=<@spring.message "order.placing.button"/>></div>-->
<#--    </form>-->

    <@spring.bind "deliveryOrderDTO"/>
    <#if deliveryOrderDTO?? && noErrors??>
        Your submitted data<br>
        First name: ${deliveryOrderDTO.source}<br>
        Last name: ${deliveryOrderDTO.destination}<br>
    <#else>
        <form action="${path}" method="post">

            <@spring.message "order.route.source"/><br>
            <@spring.formInput "deliveryOrderDTO.source"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.route.destination"/><br>
            <@spring.formInput "deliveryOrderDTO.destination"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.delivery.date"/><br>
            <@spring.formInput "deliveryOrderDTO.deliveryDate"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.weight"/><br>
            <@spring.formInput "deliveryOrderDTO.weight"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.cargo"/><br>
            <@spring.formInput "deliveryOrderDTO.cargo"/>
            <@spring.showErrors "<br>"/><br><br>

            <input type="submit" value="Submit">
        </form>
    </#if>
</#macro>

