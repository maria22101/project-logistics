<#import "../parts/common.ftl" as c>
<#import "../parts/weightTable.ftl" as w>
<#import "/spring.ftl" as spring/>
<#import "../parts/forms.ftl" as m>

<@c.page>

    <h1><@spring.message "main.title"/></h1>

    <a href="?lang=en"><@spring.message "lang.eng"/></a><br>

    <a href="?lang=ua"><@spring.message "lang.ua"/></a><br>

    <a href="/login"><@spring.message "main.login.link"/></a><br>

    <a href="/registration"><@spring.message "main.registration.link"/></a>

    <div style="width: 100%; float: left;">

        <div style="float: left;">
            <div>

                <h2 style="color: #3a60bf"><@spring.message "main.services.routes.table.title"/></h2>

                <table border="0.5">
                    <thead>
                    <tr>
                        <th><@spring.message "main.route.point.one"/></th>
                        <th><@spring.message "main.route.point.two"/></th>
                        <th><@spring.message "main.basic.rate"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list routes as route>
                        <#if .locale?starts_with("ua")>
                            <tr>
                                <td>${route.pointOneUA}</td>
                                <td>${route.pointTwoUA}</td>
                                <td>${route.basicRate}</td>
                            </tr>
                        <#else>
                            <tr>
                                <td>${route.pointOne}</td>
                                <td>${route.pointTwo}</td>
                                <td>${route.basicRate}</td>
                            </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>


        <div style="float: left;">
            <div style="padding-left: 15px;">

                <h2 style="color: seagreen"><@spring.message "main.services.weight.coeff.table.title"/></h2>


                <@w.weights />

            </div>
        </div>

    <div style="clear: both;"></div>

    <br><br>

    <@m.calculator "/calculate" />

</@c.page>