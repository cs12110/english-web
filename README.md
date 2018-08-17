# English web简单应用

本文档用于说明和部署english-web项目


## 1.项目环境依赖

a. mysql数据库,执行docs/sql里面的`english_web.sql`文件

b. 修改`application.properties`文件运行参数,端口(默认为4321),数据库连接等

c. 默认用户:**admin**,登录密码:**admin**



## 2.项目打包

打包命令
```shell
mvn clean package
```

运行项目
解压出来zip压缩包,编辑application.properties文件里面的loggin.config路径
去掉`classpath:`
```properties
logging.config=logconfig/logback-dev.xml
```

项目运行命令
```shell
nohup java -jar app/*.jar &
```



## 2.项目访问路径

主页地址:
```js
http://ip:4321/
```


## 3.其他

本项目主要开发人员: [LucienX](https://github.com/LucienX)和[cs12110](https://github.com/cs12110)
