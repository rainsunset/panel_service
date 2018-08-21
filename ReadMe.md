## 事务配置 ##
 方案1.
[springboot mybatis 事务管理](https://www.cnblogs.com/kangoroo/p/8192503.html)
在Application启动类上添加注解：@EnableTransactionManagement
在对应Class或方法上添加注解:@Transactional
当方法抛出runtimeException时事务回滚

方案2.手动回滚，在需要回滚时增加：TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

## 分页配置 ##
- pom
``` xml
<!--分页-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.5</version>
        </dependency>
```
- *ServiceImpl.java
```java
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
......
@Override public PageInfo<Record> getUserRecordPageList(String userId, Integer page, Integer rows)
            throws Exception {
        PageHelper.startPage(page, rows, true);
        List<Record> recordList = null;
        recordList = recordMapper.getRecordListByUserId(userId);
        PageInfo<Record> pageInfo = new PageInfo<Record>(recordList);
        return pageInfo;
    }
......
```
