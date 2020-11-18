###第五周作业

#### 一、写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）
 1.XML配置注入  
  代码：spring-bean-1  
  配置文件:resources/spring.xml
  测试文件：test/java/SpringMain
 
 2.注解注入  
  代码：spring-bean-2  
  配置文件:resources/spring.xml，在里面配置扫描路径  
  测试文件：test/java/SpringMain
  
 ####二、给前面课程提供的 Student/Klass/School 实现自动配置和 Starter
  1.编译，打包spring-starter项目：mvn clean package install，使其进入到本地maven仓库  
  2.在springstartertest项目中引用spring-starter包
  ```$xslt
		<dependency>
			<groupId>com.chenk</groupId>
			<artifactId>spring-starter</artifactId>
			<version>1.0-SNAPSHOT</version>
		</dependency>
```
  3.在springstartertest项目的application.properties中配置
  ```$xslt
stu.enabled=true
stu.stuId=111
stu.name=chenk
```
  4.启动项目，访问http://localhost:8080/sayHello
  
####三、实现一个 Spring XML 自定义配置，配置一组 Bean，例如：Student/Klass/School  
  代码：spring-schema  
  配置文件:resources/META-INF/spring.handlers  resources/META-INF/spring.schemas  resources/META-INF/student.xsd  resources/student.xml
  测试文件：MainTets
  
####四、研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法：
1）使用 JDBC 原生接口，实现数据库的增删改查操作。  
2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。  
3）配置 Hikari 连接池，改进上述操作。提交代码到 Github。

