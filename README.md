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


## 3.注意事项

### 3.1 代码生成

主要修改配置文件`generatorConfig.xml`里面的

```xml
<table tableName="customer_t" schema="Customer"
			enableCountByExample="false" enableUpdateByExample="false"
			enableDeleteByExample="false" enableSelectByExample="false"
			selectByExampleQueryId="false">
</table>
```

在`pom.xml`目录先执行如下命令

```shell
mvn mybatis-generator:generate -e
```

### 3.2 Jdbc batch

阿里云的mysql数据库不知道为什么那么慢.泪目

使用jdbc batch上传文件导入(100条数据左右),几乎要耗时8s.

但本地测试耗时才1s不到就完成了.

```
2018-08-21 08:38:54 [http-nio-4321-exec-8] INFO  com.official.util.JdbcBatchUtil - Process 50 ,spend :67
2018-08-21 08:38:54 [http-nio-4321-exec-8] INFO  com.official.util.JdbcBatchUtil - Process 50 ,spend :73
2018-08-21 08:38:54 [http-nio-4321-exec-8] INFO  com.official.util.JdbcBatchUtil - Process 16 ,spend :41
2018-08-21 08:38:54 [http-nio-4321-exec-8] INFO  com.official.ctrl.admin.AdminCtrl - Upload 1 file 前测-list2.xlsx is done, {success=100, failure=0}, spend:254 

```

### 3.3 druid监控页面

user: `admin`

password: `admin`

```js
http://ip:port/druid/sql.html
```

## 4.其他

本项目主要开发人员: [LucienX](https://github.com/LucienX)和[cs12110](https://github.com/cs12110)
