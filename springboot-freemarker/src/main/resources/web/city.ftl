<!DOCTYPE html>
<html lang="en">
<body>
配置如下
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



<#if city??>
    city.name:        ${city.cityName}! <br>
    city.description: ${city.description}!
</#if>
</body>
</html>