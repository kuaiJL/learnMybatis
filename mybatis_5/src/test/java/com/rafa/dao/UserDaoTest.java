package com.rafa.dao;


import com.rafa.pojo.User;
import com.rafa.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void getUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 底层主要应用反射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 底层主要应用反射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);

            System.out.println(user);

        sqlSession.close();
    }
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 底层主要应用反射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(new User(6, "Hello", "456456"));

        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 底层主要应用反射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(5, "呜呜呜呜", "789654"));

        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 底层主要应用反射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        for (int i = 7; i <12 ; i++) {
            userMapper.deleteUser(i);
        }

        sqlSession.close();
    }
}
