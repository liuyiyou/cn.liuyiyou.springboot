<!DOCTYPE html>
<html lang="en">
<body>
<pre>
spring.freemarker.template-loader-path=classpath:/web/
spring.freemarker.cache=false
spring.freemarker.charset=UTF-8
spring.freemarker.check-template-location=true
spring.freemarker.content-type=text/html
spring.freemarker.expose-request-attributes=true
spring.freemarker.expose-session-attributes=true
spring.freemarker.request-context-attribute=request
spring.freemarker.suffix=.ftl
</pre>
<#list cityList as city>
    city.name:        ${city.cityName}! <br>
    city.description: ${city.description}!
</#list>
</body>
</html>