<#import "/spring.ftl" as spring/>

<#macro weights>

    <table border="0.5">

        <#assign WeightBusinessInputs=statics['com.training.projectlogistics.constants.BusinessInputConstants']>

        <thead>
            <tr>
                <th style="background-color: mediumseagreen"><@spring.message "main.weight.differenciation"/></th>
                <th style="background-color: mediumseagreen"><@spring.message "main.weight.lower.bound"/></th>
                <th style="background-color: mediumseagreen"><@spring.message "main.weight.upper.bound"/></th>
                <th style="background-color: mediumseagreen"><@spring.message "main.weight.coeff"/></th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td><@spring.message "main.weight.light"/></td>
                <td>${WeightBusinessInputs.WEIGHT_LIGHT_LOWER_BOUND}</td>
                <td>${WeightBusinessInputs.WEIGHT_LIGHT_UPPER_BOUND}</td>
                <td>${WeightBusinessInputs.WEIGHT_LIGHT_COEFFICIENT}</td>
            </tr>
            <tr>
                <td><@spring.message "main.weight.medium"/></td>
                <td>${WeightBusinessInputs.WEIGHT_MEDIUM_LOWER_BOUND}</td>
                <td>${WeightBusinessInputs.WEIGHT_MEDIUM_UPPER_BOUND}</td>
                <td>${WeightBusinessInputs.WEIGHT_MEDIUM_COEFFICIENT}</td>
            </tr>
            <tr>
                <td><@spring.message "main.weight.heavy"/></td>
                <td>${WeightBusinessInputs.WEIGHT_HEAVY_LOWER_BOUND}</td>
                <td>${WeightBusinessInputs.WEIGHT_HEAVY_UPPER_BOUND}</td>
                <td>${WeightBusinessInputs.WEIGHT_HEAVY_COEFFICIENT}</td>
            </tr>
        </tbody>

    </table>

</#macro>