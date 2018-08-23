## SpringBoot第一章

主要包含内容

1. 最简单的SpringBoot的MVC程序
2. 日志，相比与1.5.x，2.0.x的日志有一些变化:[2.0.x日志配置](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-custom-log-levels)

```
#2.0.2
logging:
  level:
    root: info
#1.5.8    
logging:
  level: info
  
```
3. 随机端口

```
server:
  port: ${random.int[10000,19999]}
```

4. auctor [参考](https://blog.csdn.net/qq_35915384/article/details/80203768)