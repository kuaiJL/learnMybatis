```java
public class User {
    private int user_id;
    private String user_name;
    private String user_pubKey;
    
    public void setId(int id) {
        this.user_id = id;
    }

    public void setName(String name) {
        this.user_name = name;
    }

    public void setPwd(String user_pubKey) {
        this.user_pubKey = user_pubKey;
    }
    
}
```

```xml
    <insert id="addUser" parameterType="com.kuai.pojo.User">
        insert into bishe.users (user_id, user_name, user_pubKey) values (#{id},#{name},#{user_pubKey});
    </insert>
```

SQL语句参数映射实体类的字段**或**对应的setXXX方法的XXX。 

例如#{id}<->setId(int id)、#{user_pubKey}<->private String user_pubKey

```xml
    <insert id="addUser" parameterType="com.kuai.pojo.User">
        insert into bishe.users (user_id, user_name, user_pubKey) values (#{id},#{name},#{user_pubKey});
    </insert>
```
parameterType="com.kuai.pojo.User"可以省略，parameterType为基本类型，和实体对象可以省略，

**因为UserMapper.java里面 int addUser(User user);已经映射了**


```xml
    <update id="updateUser" parameterType="com.kuai.pojo.User">
        update bishe.users set user_name = #{name} where user_id = #{id};
    </update>
```
如上，可知有的情况下为什么要用parameterType="Map/map"，例如在**User实体类类中如下只有有参（3个）构造函数**，
没有public User(int id, String name)构造函数。

```java
public class User {
    private int user_id;
    private String user_name;
    private String user_pubKey;
    
    public User(int id, String name, String user_pubKey) {
        this.user_id = id;
        this.user_name = name;
        this.user_pubKey = user_pubKey;
    }
}
```

所以新建实例时只能调用此构造函数，但是updateUser函数要传入User实例，只能
```mapper.updateUser(new User(6, "呵呵哒", "123123"));```
但是在xml里sql语句只需要根据id就能更改用户名，即我们希望```mapper.updateUser(new User(6, "呵呵哒");```
但是实体类中并没有此构造函数，导致报错，**虽然可以新建此构造函数，但是如果参数（字段）过多，即要建立排列组合个构造函数**，
过多的构造函数不美观，也不灵活。**诚然也可以```mapper.updateUser(new User(6, "呵呵哒", "123123"));```
把表里id=6的 name改为“呵呵哒”，且user_pubKey并不会被改变。但是必须要初始化不需要的字段不奇怪吗？**

**所以这个时候需要更灵活的方案：Map**

```int updateUser2(Map<String, Object> map);``` //UserMapper.java接口定义方法

```xml
    <update id="updateUser2" parameterType="Map">
        update bishe.users set user_name = #{userName} where user_id = #{userid};
    </update>
```
测试Test:

```
    @Test
    public void updateUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 6);   //对应#{userid}
        map.put("userName", "马erA");    //对应#{userName}
        int i = mapper.updateUser2(map);
        
        if (i > 0) {
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();
        test();
    }
```
这样使用就很灵活。不过貌似阿里不建议使用Map。😅

**以上是参数为User,需要User字段映射数据库列名。
还有一种情况是返回值是User，需要数据库列名映射User字段，这个时候可以通过**

**1.起别名：数据库列名 as 实体类字段名**

**2.resultMap:** 
```xml
    <resultMap id="UserMap" type="User">
        <result column="user_id" property="id"/>
        <result column="user_name" property="name"/>
        <result column="user_pubKey" property="pubKey"/>
    </resultMap>
```
