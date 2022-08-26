# dao cloud

提供简单的微服务开发模板

# 环境安装

## redis

```bash
docker run -itd --name dao-redis -p 6679:6379 redis
```


## mysql

```bash
docker run -itd --name mysql888 -p 33060:3306 -e MYSQL_ROOT_PASSWORD=root -e TZ=Asia/Shanghai  ubuntu/mysql:8.0-20.04_beta  --default-authentication-plugin=mysql_native_password 
```

## nacos

https://github.com/alibaba/nacos/releases

下载压缩包，根据说明启动即可， 开发使用单机模式即可



## 配置导入

config-backup 下有一个zip压缩文件，可以通过nacos导入

注意命名空间先创建，和我的一样

2b3c48fb-f6e6-4ff4-9c74-6b9be8fb5b09

