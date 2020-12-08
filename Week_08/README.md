WEEK8  


1.在docker中启动两个mysql5.7  
```
CONTAINER ID        IMAGE               COMMAND                  CREATED              STATUS                      PORTS                               NAMES
0edb8d9daacc        mysql:5.7           "docker-entrypoint..."   5 seconds ago        Up 4 seconds                33060/tcp, 0.0.0.0:3307->3306/tcp   mysql5.7-2
556f920124fc        mysql:5.7           "docker-entrypoint..."   About a minute ago   Up About a minute           0.0.0.0:3306->3306/tcp, 33060/tcp   mysql5.7
```  
在mysql5.7建数据库shop_00,在mysql5.7-2建数据库shop_01

2.下载https://mirror.bit.edu.cn/apache/shardingsphere/5.0.0-alpha/apache-shardingsphere-5.0.0-alpha-shardingsphere-proxy-bin.tar.gz 并解压  
下载https://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.47/mysql-connector-java-5.1.47.jar 包放入解压的apache-shardingsphere-5.0.0-alpha-shardingsphere-proxy-bin的lib路径下  

修改conf/config-sharding.yaml为
```yaml
######################################################################################################
#
# If you want to connect to MySQL, you should manually copy MySQL driver to lib directory.
#
######################################################################################################

schemaName: shop

dataSourceCommon:
  username: root
  password: 123456
  connectionTimeoutMilliseconds: 30000
  idleTimeoutMilliseconds: 60000
  maxLifetimeMilliseconds: 1800000
  maxPoolSize: 50
  minPoolSize: 1
  maintenanceIntervalMilliseconds: 30000

dataSources:
  shop_00:
    url: jdbc:mysql://127.0.0.1:3306/shop_00?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true
  shop_01:
    url: jdbc:mysql://127.0.0.1:3307/shop_01?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true

rules:
  - !SHARDING
    tables:
      tb_order:
        actualDataNodes: shop_0${0..1}.tb_order_${0..15}
        tableStrategy:
          standard:
            shardingColumn: id
            shardingAlgorithmName: tb_order_inline
    defaultDatabaseStrategy:
      standard:
        shardingColumn: user_id
        shardingAlgorithmName: database_inline
    shardingAlgorithms:
      database_inline:
        type: INLINE
        props:
          algorithm-expression: shop_0${user_id % 2}
      tb_order_inline:
        type: INLINE
        props:
          algorithm-expression: tb_order_${id % 16}
```

修改server.yaml为
```yaml
######################################################################################################
#
# If you want to connect to MySQL, you should manually copy MySQL driver to lib directory.
#
######################################################################################################

schemaName: shop

dataSourceCommon:
  username: root
  password: 123456
  connectionTimeoutMilliseconds: 30000
  idleTimeoutMilliseconds: 60000
  maxLifetimeMilliseconds: 1800000
  maxPoolSize: 50
  minPoolSize: 1
  maintenanceIntervalMilliseconds: 30000

dataSources:
  shop_00:
    url: jdbc:mysql://127.0.0.1:3306/shop_00?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true
  shop_01:
    url: jdbc:mysql://127.0.0.1:3307/shop_01?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true

rules:
  - !SHARDING
    tables:
      tb_order:
        actualDataNodes: shop_0${0..1}.tb_order_${0..15}
        tableStrategy:
          standard:
            shardingColumn: id
            shardingAlgorithmName: tb_order_inline
    defaultDatabaseStrategy:
      standard:
        shardingColumn: user_id
        shardingAlgorithmName: database_inline
    shardingAlgorithms:
      database_inline:
        type: INLINE
        props:
          algorithm-expression: shop_0${user_id % 2}
      tb_order_inline:
        type: INLINE
        props:
          algorithm-expression: tb_order_${id % 16}
```

本地通过 mysql -h127.0.0.1 -P 3306  -uroot -p123456连接数据库
```sql
mysql> show databases;
+----------+
| Database |
+----------+
| shop     |
+----------+
1 row in set (0.00 sec)
```
  
创建表
```sql
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
以下为shardingsphere-proxy的部分日志
```
[INFO ] 23:23:48.869 [ShardingSphere-Command-4] ShardingSphere-SQL - Logic SQL: CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
[INFO ] 23:23:48.869 [ShardingSphere-Command-4] ShardingSphere-SQL - SQLStatement: MySQLCreateTableStatement(isNotExisted=false)
[INFO ] 23:23:48.871 [ShardingSphere-Command-4] ShardingSphere-SQL - Actual SQL: shop_00 ::: CREATE TABLE `tb_order_0` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
[INFO ] 23:23:48.873 [ShardingSphere-Command-4] ShardingSphere-SQL - Actual SQL: shop_00 ::: CREATE TABLE `tb_order_1` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

插入34条数据  
```sql
INSERT INTO `tb_order` (`id`, `user_id`) 
VALUES 
(00, 2),(01, 2),(02, 2),(03, 2),(04, 2),(05, 2),(06, 2),(07, 2),(08, 2),(09, 2),(10, 2),(11, 2),
(12, 2),(13, 2),(14, 2),(15, 2),(16, 1),(17, 1),(18, 1),(19, 1),(20, 1),(21, 1),(22, 1),(23, 1),
(24, 1),(25, 1),(26, 1),(27, 1),(28, 1),(29, 1),(30, 1),(31, 1),(32, 1),(33, 3);  
```

部分日志：
```
[INFO ] 23:26:09.273 [ShardingSphere-Command-5] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 23:26:09.279 [ShardingSphere-Command-5] ShardingSphere-SQL - Actual SQL: shop_00 ::: INSERT INTO `tb_order_0` (`id`, `user_id`)
VALUES
(0, 2)
[INFO ] 23:26:09.282 [ShardingSphere-Command-5] ShardingSphere-SQL - Actual SQL: shop_00 ::: INSERT INTO `tb_order_1` (`id`, `user_id`)
VALUES
(1, 2)
[INFO ] 23:26:09.282 [ShardingSphere-Command-5] ShardingSphere-SQL - Actual SQL: shop_00 ::: INSERT INTO `tb_order_2` (`id`, `user_id`)
VALUES
(2, 2)
```

最后可以发现数据分散在两个数据库的各个表中。