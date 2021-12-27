package com.rafa.dao;

import com.rafa.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from users")
    List<User> getUsers();

    @Select("select user_id as id , user_name , user_pubKey from users where user_id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into users(user_id,user_name,user_pubKey) values (#{id},#{user_name},#{pubKey})")
    int addUser(User user);

    @Update("update users set user_name=#{user_name},user_pubKey=#{pubKey} where user_id=#{id}")
    int updateUser(User user);


    @Delete("delete from users where user_id = #{id}")
    int deleteUser(@Param("id") int id);
}