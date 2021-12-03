package kuai.dao;

import kuai.pojo.User;
import kuai.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public  void  getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }
    @Test
    public  void  getUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById2(1);
        System.out.println(user);

        sqlSession.close();
    }
    // 增删改查需要提交事务
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.addUser(new User(10, "kiao", "pou213"));

        if (i > 0) {
            System.out.println("插入成功");
        }

        sqlSession.commit();

        sqlSession.close();
    }


    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userid", 11);
        map.put("userName", "哈行昂");
        map.put("password", "465789");

        int i = mapper.addUser2(map);

        if (i > 0) {
            System.out.println("插入成功");
        }

        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(9, "呵哒", "pppp23"));
        if (i > 0) {
            System.out.println("修改成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 7);
        map.put("userName", "马erA");
        int i = mapper.updateUser2(map);

        if (i > 0) {
            System.out.println("修改成功");
        }

        sqlSession.commit();

        sqlSession.close();
    }
}
