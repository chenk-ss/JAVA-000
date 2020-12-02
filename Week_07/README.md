#WEEK07
##一、按自己设计的表结构，插入 100 万订单模拟数据，测试不同方式的插入效率  

##二、读写分离 - 动态切换数据源版本 1.0  
  创建两个数据库shop、shop_slave,用其中的tb_user模拟读写分离  
  使用AbstractRoutingDataSource和AOP实现读写分离、数据库自动切换，代码见abstractroutingdatasource目录  
  通过调用：  
  http://localhost:8081/user/queryAll  
  http://localhost:8081/user/add  
  可以发现新增后数据不同，代表实现了读写分离  
  
##三、读写分离 - 数据库框架版本 2.0(使用shardingsphere)  
  使用shardingsphere实现读写分离，代码见shardingsphere目录  
  自动切换从日志中可以看出：  
  
    insert into tb_user (name, id) values (?, ?) ::: DataSources: master
    select user0_.id as id1_0_, user0_.name as name2_0_ from tb_user user0_ ::: DataSources: slave0