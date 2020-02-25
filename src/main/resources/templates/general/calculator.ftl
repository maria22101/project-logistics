<#import "../parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>

<@c.page>

    <table border="0.5">
        <thead>
        <tr>
            <th style="background-color: seagreen"><@spring.message "usercabinet.orderdetails.data"/></th>
            <th style="background-color: seagreen"><@spring.message "usercabinet.orderdetails.information"/></th>
        </tr>
        </thead>

        <tbody>

        <tr>
            <td><@spring.message "main.route.point.one"/></td>
            <td>${point1}</td>
        </tr>

        <tr>
            <td><@spring.message "main.route.point.two"/></td>
            <td>${point2}</td>
        </tr>

        <tr>
            <td><@spring.message "calculator.results.weight"/></td>
            <td>${weight}</td>
        </tr>

        <tr>
            <td><@spring.message "calculator.results.cost"/></td>
            <td>${cost}</td>
        </tr>

        </tbody>
    </table>

    <br><br>

    <a href="/"><@spring.message "main.page.link"/></a>

</@c.page>