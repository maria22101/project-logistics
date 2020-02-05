<#import "/spring.ftl" as spring/>

<#macro registration path>

    <@spring.bind "user"/>
    <form action="${path}" method="post">

        <@spring.message "name.indication"/><br>
        <@spring.formInput "user.name"/>
        <@spring.showErrors "<br>"/><br><br>

        <@spring.message "surname.indication"/><br>
        <@spring.formInput "user.surname"/>
        <@spring.showErrors "<br>"/><br><br>

        <@spring.message "email.indication"/><br>
        <@spring.formInput "user.email"/>
        <@spring.showErrors "<br>"/><br><br>

        <@spring.message "password.indication"/><br>
        <@spring.formInput "user.password"/>
        <@spring.showErrors "<br>"/><br><br>

        <input type="submit" value="<@spring.message "registration.button"/>">
    </form>

</#macro>

<#macro login path>
    <form action="${path}" method="post">
        <div><label> <@spring.message "email.indication"/> <input type="text" name="username"/> </label></div>
        <br/>
        <div><label> <@spring.message "password.indication"/> <input type="password" name="password"/> </label></div>
        <br/>
        <div><input type="submit" value=<@spring.message "login.button"/>></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="submit" value=<@spring.message "logout.button"/>>
    </form>
</#macro>

<#macro delivery_order_creation path>

    <@spring.bind "orderAddressDTO"/>
        <form action="${path}" method="post">

            <@spring.message "order.route.source"/><br>
            <@spring.formInput "orderAddressDTO.source"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.route.destination"/><br>
            <@spring.formInput "orderAddressDTO.destination"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.address.street"/><br>
            <@spring.formInput "orderAddressDTO.street"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.address.house"/><br>
            <@spring.formInput "orderAddressDTO.house"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.address.apartment"/><br>
            <@spring.formInput "orderAddressDTO.apartment"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.delivery.date"/><br>
            <@spring.formInput "orderAddressDTO.deliveryDate"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.weight"/><br>
            <@spring.formInput "orderAddressDTO.weight"/>
            <@spring.showErrors "<br>"/><br><br>

            <@spring.message "order.cargo"/><br>
            <@spring.formSingleSelect "orderAddressDTO.cargoType", cargoTypes, ""/>
            <@spring.showErrors "<br>"/><br><br>

            <input type="submit" value="<@spring.message "usercabinet.order.placing.button"/>">
        </form>
</#macro>

