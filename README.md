# hk-oa

![AUR](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)
![](https://img.shields.io/badge/Author-hk-orange.svg)
![](https://img.shields.io/badge/version-1.0-brightgreen.svg)


## 简介：
基于`SpringCloud(Greenwich.SR2)`  + `SpringBoot(2.1.7.RELEASE)` 的微服务 脚手架，
具备用户管理、资源权限管理、网关统一鉴权、自动代码生成、分布式事务等多个模块，支持多业务系统并行开发，
支持多服务并行开发，可以作为后端服务的开发脚手架。代码简洁，架构清晰，非常适合学习使用。
核心技术采用Nacos、Fegin、Ribbon、Gateway、Hystrix、JWT Token、Mybatis、SpringBoot、Nacos
等主要框架和中间件。

打造一套从 `基础框架` - `分布式微服务架构` - `持续集成` - `自动化部署` - `系统监测` 的解决方案。

该项目为本人在学习过程中通过一些`其他的开源项目`，`资料`，`文章`进行整合的一个提供基础功能的项目。`本项目旨在实现基础能力，不设计具体业务。`
目前国内的一些资料讲解和使用的SpringCloud版本都比较低，而一些开源项目，则大多不适用于生产，
自己在基于现有的开源项目和资料学习的同时，将一些想法和最佳实践落地为本项目。

部署方面, 可以采用以下4种方式，并会陆续公布jenkins集合以下3种部署方式的脚本和配置文件：
- IDEA 启动
- jar部署
- docker部署 
- k8s部署


## 功能点介绍:
 - **服务注册与调用：**

基于Nacos来实现的服务注册与调用以及配置中心，在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验，开发者完全感知不到这是远程方法，更感知不到这是个HTTP请求。
Nacos修改配置文件可以将配置文件持久化到mysql库中
 - **服务鉴权:**

通过JWT的方式来加强服务之间调度的权限验证，保证内部服务的安全性。
采用access_token和refresh_token来解决token一旦失效用户就要重新登录的，保证用户一定时间内，无感知的情况下刷新token

 - **负载均衡：**

将服务保留的rest进行代理和网关控制，除了平常经常使用的node.js、nginx外，Spring Cloud系列的zuul和rebbion，可以帮我们进行正常的网关管控和负载均衡。其中扩展和借鉴国外项目的扩展基于JWT的Zuul限流插件，方面进行限流。

 - **熔断机制：**

因为采取了服务的分布，为了避免服务之间的调用“雪崩”，采用了Hystrix的作为熔断器，避免了服务之间的“雪崩”。


- **后端统一表单验证**

严谨的表单验证通常需要 前端+后端同时验证， 但传统的项目，均只能前后端各做一次检验， 后期规则变更，又得前后端同时修改。
故在`hibernate-validator`的基础上封装了`oa-validator-starter`起步依赖，提供一个通用接口，可以获取需要校验表单的规则，然后前端使用后端返回的规则，
以后若规则改变，只需要后端修改即可。


- **在线API**

由于原生swagger-ui某些功能支持不够友好，故采用了国内开源的`swagger-bootstrap-ui`，并制作了stater，方便springboot用户使用。

- **代码生成器**

基于Mybatis-generator自定义了一套代码生成器


## 项目架构图:  架构图.xml -> https://www.draw.io/
![架构图.png](doc/image/项目相关/架构图.png)

## 技术栈/版本介绍：
- 所涉及的相关的技术有：
    - JSON序列化:Jackson
    - 数据库： MySQL 5.7.9 (驱动6.0.6)
    - 持久层框架： Mybatis
    - 代码生成器：基于Mybatis-plus-generator自定义  [https://github.com/zuihou/zuihou-generator.git]
    - API网关：gateway 
    - 服务注册与发现： Nacos
    - 服务消费：OpenFeign
    - 负载均衡：Ribbon
    - 配置中心：Nacos
    - 服务熔断：Hystrix
    - 项目构建：Maven 3.3
    - 分布式事务： seata
- 部署方面：
    - 服务器：CentOS
    - Jenkins
    - Docker 18.09
  

本代码采用 Intellij IDEA(2018.1 EAP) 来编写，但源码与具体的 IDE 无关。

PS: Lombok版本过低会导致枚举类型的参数无法正确获取参数，经过调试发现因为版本多低后，导致EnumDeserializer的 Object obj = p.getCurrentValue();取的值为空。


## 约定：

- oa-xxx-api 模块中提供feign客户端
- 区分po、dto，不要把po中的所有字段都返回给前端。 前端需要什么字段，就返回什么字段
- 类名：首字母大写驼峰规则；方法名：首字母小写驼峰规则；常量：全大写；变量：首字母小写驼峰规则，尽量非缩写
- 业务模块接口层命名为`项目-业务-api`，如`zuihou-authority-api`
- 业务模块业务层命名为`项目-业务-biz`，如`zuihou-authority-biz`
- 业务模块控制层命名为`项目-业务-controller`，如`zuihou-authority-controller`
- 业务模块容器命名为`项目-业务-server`，如`zuihou-authority-server`
- 注释：
```
表注释： 第一行用简短的文字来描述表的名称，会体现在Swagger中； 换行后对表进行详细介绍
字段注释： 第一行用简短的文字来描述字段的名称，会体现在Swagger的字段描述上； 换行后对字段进行详细的描述。
        另外，若字段需要使用枚举类型，则字段需要设置成varchar类型， 并在字段注释上使用 #枚举类型{KEY:描述;key2:描述;} 格式来描述枚举类型格式， 代码生成器会自动生成枚举类
        eg: #LogType{OPT:操作日志;EX:异常日志;}
类注释： 用 /** 开头的文档型注释， 并添加 @author @date 等参数
方法注释：  用 /** 开头的文档型注释， 并添加 @param @return 等参数
```
- 更多规范，参考[阿里巴巴Java开发手册] 

## 小技巧
- 多线程编译： `clean install -T8`
- mapper类上增加注解`@Repository`, 防止`IDEA`提示注入报错。
- IDEA提示`@Autowired`注入失败时，可以用`@Resource` 防止`IDEA`提示注入报错。
- IDEA提交代码时，勾选Reformat code、Rearrange code、Optimize imports, 让代码更整洁

    
## 环境须知：

- nginx (文件下载、预览时需要使用)
- mysql 5.7.9+
- JDK8
- IDE插件一个(Eclipse, IDEA都需要安装插件)，`lombok插件`

## 项目结构:

```
├─hk-oa
│  │  
│  ├─oa-backend---------------------------后端服务
│  |  ├─oa-api----------------------------常用API
|  |  ├─oa-config-------------------------配置文件中心
│  |  ├─oa-authority----------------------后端管理服务[正在开发]
│  |  |  ├─oa-authority-biz-------------------后端管理业务/持久层
│  |  |  ├─oa-authority-controller------------后端管理业务/持久层
│  |  |  ├─oa-authority-server----------------后端管理服务
│  |  ├─oa-gateway------------------------统一网关负载中心
│  |  |  |─oa-gateway-ratelimit-----------网关限流插件[未开始]
│  |  |  |─oa-gateway-server--------------项目网关服务
│  │ 
│  ├─oa-commons--------------------------公共模块   
│  |  ├─oa-common------------------------项目业务模块 （业务模块主要用于存放可能跟业务相关的公共代码）
│  |  ├─oa-jwt-starter-------------------JWT起步依赖
│  |  ├─oa-log-starter-------------------操作日志起步依赖
│  |  ├─oa-openfeign-starter-------------OpenFeign常用配置起步依赖【未开始】
│  |  ├─oa-swagger2-starter--------------SwaggerUI文档配置
│  |  ├─oa-user-starter------------------用户信息自动注入起步依赖
│  |  ├─oa-validator-starter-------------增强表单前后端统一验证起步依赖
│  |  
│  │-...
```


## 运行步骤: 
- 1, 依次运行数据库脚本
    

- 2, 在bootstrap-dev.yml文件修改配置数据库Nacos注册中心地址等配置：


- 3，在Nacos修改各个模块配置
    
- 3， 在IDE中启动，编译通过后按如下顺序启动：
    - Nacos                  
    - GatewayServerApplication   
    - AuthorityApplication

- 4， 命令行启动:
    - 先cd 到各个服务的target目录，依次启动即可：
    - java -jar -Dspring.profiles.active=dev oa-gatway-server.jar 
    - java -jar -Dspring.profiles.active=prod -Dserver.port=8080  oa-authority-server.jar  > /dev/null 2>&1 &  

## 端口号介绍 :

| 服务 | 端口号 |
|:----:|:----:|
| oa-eureka | 8761 |  ​
| - | - |​- | ​
| oa-gateway-server | 8760 |  ​
| oa-authority-server | 8764 |  ​


## 常见报错：
 - 1, 很多依赖死活都下载不下来？
    - 答： 由于spring-boot和spring-cloud等版本比较新，所以目前国内的一些仓库还没有新版本的jar。
    需要配置spring的maven仓库。 （配置后还是无法下载，就先注释掉settings.xml中其他的仓库，只保留这个）
```
    <mirror>
        <id>spring-milestones</id>
        <name>Spring Milestones</name>
        <url>https://repo.spring.io/libs-milestone</url>
        <mirrorOf>central</mirrorOf>
    </mirror>
```
 - 2, 很多类缺少get/set方法？
    - 答：请用IDEA或Eclipse安装`lombok`插件
    
## 查看磁盘空间占用
df -h
## 查看当前目录的磁盘占用
du -ah --max-depth=1
     

