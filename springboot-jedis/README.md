## SpringBoot第二章：继承Reids
 
1. 加入依赖

```
spring-boot-starter-data-redis
spring-boot-starter-redis
```
两者都可以

如果采用默认配置，到这里就可以运行了


几个问题：

如果前期启动后，redis挂掉。 系统会报错，但是lettuce客户端ConnectionWatchdog会自动探测，一旦redis恢复，则系统正常
Reconnecting, last destination was localhost:6379
Reconnecting, last destination was localhost:6379


2.0.4 默认使用的是lettuce客户端，如果要使用jedis
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
	<exclusions>
		<exclusion>
			<groupId>io.lettuce</groupId>
			<artifactId>lettuce-core</artifactId>
		</exclusion>
	</exclusions>
</dependency>
		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>2.9.0</version>
		</dependency>
