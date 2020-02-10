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

    <@spring.bind "orderDTO"/>
        <form action="${path}" method="post">

            <@spring.bind "routeCities" />

            <div>
            <@spring.message "order.dispatch.city"/>
            <@spring.formSingleSelect "orderDTO.dispatchCity", routeCities, " "/>
            <@spring.showErrors ", "/>
            </div>

            <div>
            <@spring.message "order.dispatch.street"/>
            <@spring.formInput "orderDTO.dispatchStreet"/>
            <@spring.showErrors ", "/>
            </div>

            <div>
            <@spring.message "order.dispatch.house"/>
            <@spring.formInput "orderDTO.dispatchHouse"/>
            <@spring.showErrors ", "/>
            </div>

            <div>
            <@spring.message "order.dispatch.apartment"/>
            <@spring.formInput "orderDTO.dispatchApartment"/>
            <@spring.showErrors ", "/>
            </div>

            </br></br>

            <div>
            <@spring.message "order.delivery.city"/>
            <@spring.formSingleSelect "orderDTO.deliveryCity", routeCities ""/>
            <@spring.showErrors ", "/>
            </div>

            <div>
            <@spring.message "order.delivery.street"/>
            <@spring.formInput "orderDTO.deliveryStreet"/>
            <@spring.showErrors ", "/>
            </div>

            <div>
            <@spring.message "order.delivery.house"/>
            <@spring.formInput "orderDTO.deliveryHouse"/>
            <@spring.showErrors ", "/>
            </div>

            <div>
            <@spring.message "order.delivery.apartment"/>
            <@spring.formInput "orderDTO.deliveryApartment"/>
            <@spring.showErrors ", "/>
            </div>

            </br></br>

            <div>
            <@spring.message "order.delivery.date"/>
            <@spring.formInput "orderDTO.deliveryDate"/>
            <@spring.showErrors ", "/>
            </div>

            <p></p>

            <div>
            <@spring.message "order.weight"/>
            <@spring.formInput "orderDTO.weight"/>
            <@spring.showErrors ", "/>
            </div>

            <p></p>

            <div>
            <@spring.message "order.cargo"/>
            <@spring.formSingleSelect "orderDTO.cargoType", cargoTypes ""/>
            <@spring.showErrors ", "/>
            </div>

            </br></br>

            <input type="submit" value="<@spring.message "usercabinet.order.placing.button"/>">
        </form>
</#macro>

