# sparrow-shop

单独启动打包好的jar包
```bash
mvn package

java -Deserver.port=8080 -jar target/sparrowShop-0.0.1-SNAPSHOT.jar
```

MySQL 和 Redis 的docker 启动

```bash
docker run -itd -p 3306:3306 --name=mysql_sparrow -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=sparrowDB mysql:5.7.29
docker run -itd -p 6379:6379 --name=redis_sparrow redis
```

MySQL启动后要灌入数据表格
```bash
mvn flyway:clean flyway:migrate
```

DockerFile 的使用

在config目录写上配置文件 `docker-application.yml`，
```
# 数据源配置
spring:
  datasource:
    url: jdbc:mysql://192.168.31.15:3306/sparrowDB?useSSL=false&allowPublicKeyRetrieval=true
    username: root
    password: 123456
    driverClassName: com.mysql.cj.jdbc.Driver

# mybatis 配置
mybatis:
  config-location: classpath:db/mybatis/config.xml

sparrowShop:
  redis:
    host: 192.168.31.15
    port: 6379
```

```bash
// 构建
docker build . -t sparrowShop

// 导出镜像
docker save -o sparrowShop.tar sparrowShop:laster

// 载入镜像
sudo docker load < sparrowShop.tar

// 启动
docker run -p 9080:8080 -v `pwd`/config/docker-application.yml:/app/config/application.yml -itd sparrow_shop
```

Nginx 使用

在conf.d目录写上配置文件 `default.conf`，
（下面是开启了https 的配置）
```$xslt
server {
    listen 443 ssl http2;

    ssl                      on;
    ssl_certificate          /etc/nginx/certs/example.crt;
    ssl_certificate_key      /etc/nginx/certs/example.key;

    ssl_session_timeout  5m;

    ssl_ciphers HIGH:!aNULL:!MD5;
    ssl_protocols SSLv3 TLSv1 TLSv1.1 TLSv1.2;
    ssl_prefer_server_ciphers   on;

    location / {
		proxy_pass http://192.168.31.11:9080;
    }
}
```

启动Nginx
```bash
docker run -p 80:80 -v `pwd`/config/nginx.conf:/etc/nginx/nginx.conf:ro -it nginx
```
