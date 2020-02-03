<#macro page>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Logistics</title>
        <style>
            body{
                font-family: "arial";
                margin-left: 120px;
                margin-top: 30px;
            }

            table {
                width: 500px;

            }

            table, th, td {
                border: 1px solid black;
                padding: 2px;
                border-collapse: collapse;
            }

            th{
                background-color: #176c9a;
                color : #FFFFFF;
            }

            tr.odd{
                background-color: #CFCFCF;
            }

            tr.even{
                background-color: #1076F5;
            }

            .error {
                color: orangered;
            }
        </style>
    </head>
    <body>
    <#nested>
    </body>
    </html>
</#macro>