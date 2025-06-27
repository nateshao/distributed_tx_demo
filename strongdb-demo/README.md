# 强一致数据库分布式事务 Demo  
# Strong Consistency Database Distributed Transaction Demo

## 方案简介 | Overview

依赖TiDB、CockroachDB等原生支持分布式事务的数据库，应用层无感。
Rely on databases like TiDB or CockroachDB that natively support distributed transactions, with no special handling required at the application layer.

## 运行方式 | How to Run

1. 启动TiDB或MySQL服务 | Start TiDB or MySQL server
2. 启动本模块 | Start this module
   ```bash
   mvn spring-boot:run
   ```
- 默认端口 | Default port: `8086`

## 典型接口 | Typical API

- 账户转账 | Account transfer  
  `POST http://localhost:8086/account/transfer?from=1&to=2&amount=100`

## 主要代码结构 | Main Code Structure

- `Account`：账户实体 | Account entity
- `AccountRepository`：账户持久化 | Account repository
- `AccountService`：转账服务 | Transfer service
- `AccountController`：REST接口 | REST controller

## 依赖环境 | Prerequisites

- JDK 8+
- Maven 3.6+
- TiDB/MySQL

## 参考 | Reference

- [TiDB官方文档](https://docs.pingcap.com/zh/tidb/stable) 