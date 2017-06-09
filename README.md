## Mongeez spike

参考：[Mongeez](https://github.com/mongeez/mongeez/wiki/How-to-use-mongeez)

包含两个数据库migration的JS脚本：

- V1_add_new_column.js
- V2_remove_column.js

在代码中，执行Mongeez的代码：

```java

Mongeez mongeez = new Mongeez();
mongeez.setFile(new ClassPathResource("mongeez.xml"));
mongeez.setDbName("test");
mongeez.setMongo(new Mongo("127.0.0.1", 27017));
mongeez.process();
		
```

执行结束之后会在Mongo数据库中生成一个mongeez表管理已经执行过的迁移脚本

![mongeez表](http://oi2ywsrou.bkt.clouddn.com/mongeez.jpeg)


