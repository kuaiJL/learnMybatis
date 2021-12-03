package kuai.dao;

import kuai.pojo.User;

import java.util.Map;

public interface UserMapper {

    User getUserById(int id);

    User getUserById2(int id);

    int addUser(User user);

    int addUser2(Map<String, Object> map);

    int updateUser(User user);

    int updateUser2(Map<String, Object> map);

}