[![Build Status](https://travis-ci.org/liuxinsi/mongo-jdbc.svg?branch=master)](https://travis-ci.org/liuxinsi/mongo-jdbc)

# mongo-jdbc
使用JDBC访问MongoDB，执行SQL。

解析SQL转换成MongDB语句的核心代码抽取自[Mycat-Server](https://github.com/MyCATApache/Mycat-Server)。

正好需要用到但又不需要Mycat的完整功能，所以提出来完善下。thx a lot。 🙏🙏

## Usage
```
MongoDataSource mds = new MongoDataSource();
mds.setUrl("127.0.0.1");
mds.setDbName("testdb");
Connection  connection = mds.getConnection();
try (Statement stat = connection.createStatement();
    ResultSet rs = stat.executeQuery("select * from user")) {
    while (rs.next()) {
        System.out.println(rs.getObject(1) + ":" + rs.getObject(2));
    }
}
```

## Usage(With Spring JDBCTemplate)：
```
// 构造数据源
MongoDataSource mds = new MongoDataSource();
mds.setUrl("127.0.0.1:57004");
mds.setDbName("testdb");
mds.setUserName("testadmin");
mds.setPassword("admnipwd");
...
other config
```

```
JdbcTemplate jdbcTemplate = new JdbcTemplate(mds);
List<TestObject> list = jdbcTemplate.query("SELECT * FROM TEST", new BeanPropertyRowMapper<>(TestObject.class));
list.forEach(testObject -> System.out.println(":" + testObject));
```

## 使用ORM相关类库进行查询的限制

支持类型：
* org.bson.types.ObjectId
* 基本类型
* 枚举
* 内嵌对象
* 内嵌数组

eg.
```
public class A{
private ObjectId _id;
private String name;
private Integer age;
private B b;
private Address[] addresses;
private String[] someCode;
}
```

不支持类型：
* 第一层的内嵌集合类型

eg.
```
public class A{
private ObjectId _id;
private String name;
private Integer age;
private B b;
private List<Address> addresses;
private Set<String> someCode;
}
```
第一次拿不到范型，所以addresses、someCode不支持，直接返回null。B对象里的则没问题。<br/>

## Configure
see [MongoJDBCConfig.java](https://github.com/liuxinsi/mongo-jdbc/blob/master/src/main/java/com/lxs/mj/MongoJDBCConfig.java)


## TODO：
- [x] DataSource
- [x] Configure
- [x] JDBCTemplate support (PreparedStatement 相关的query不支持)
- [] PreparedStatement
- [x] 复制集
- [x] 查询结果中内嵌对象支持(第一层内嵌的集合不支持)