**Spring boot project - Delivery System**

**Проект Spring boot - Система "Доставка вантажу"**

---------------------------------------------------------------------
Надання послуг з отримання і доставки вантажу.

На сайті відображається інформація по тарифах і напрямах доставки.

- Незареєстрованому користувачу доступний перегляд сайту та калькулятор послуг.

- Зареєстрований користувач у себе в кабінеті може створити Заявку на отримання
вантажу і адресу доставки. Заявка містить інформацію про тип вантажу, вагу,
дату отримання.

- Після створення заявки Система* формує Рахунок. Користувач може оплатити рахунок
в своєму кабінеті.

*або Адміністратор(узгоджено з Тренером)

---------------------------------------------------------------------
Requirements:
DB - MySql
Java version up 8.
Maven

Set up:
1. Clone project
2. Run delivery4.sql from resources/
3. Enter db login & password in resources/application.properties
4. Run Spring boot, link - localhost:8088/