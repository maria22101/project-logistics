<#import "parts/common.ftl" as c>
<#import "parts/log_in_out.ftl" as l>
<#import "/spring.ftl" as spring />

<@c.page>
    Add new user
<#--    ${message}-->
    <@l.login "/registration" />
<#--    ${rc.getMessage("title")}-->
</@c.page>