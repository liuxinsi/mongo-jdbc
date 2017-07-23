[![Build Status](https://travis-ci.org/liuxinsi/mongo-jdbc.svg?branch=master)](https://travis-ci.org/liuxinsi/mongo-jdbc)

# mongo-jdbc
使用JDBC访问MongoDB，执行SQL。

解析SQL转换成MongDB语句的核心代码抽取自[Mycat-Server](https://github.com/MyCATApache/Mycat-Server)。

正好需要用到但又不需要Mycat的完整功能，所以提出来完善下。thx a lot。 🙏🙏

<b>目前不支持preparedStatment相关的方法</b>
TODO：
- [x] datasource
- [x] configure
- [] jdbctemplate support
- [] preparedStatment
- [] 复制集