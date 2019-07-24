package cn.bb.dao;

import cn.bb.model.OneUser;
import cn.bb.model.OneUserRole;

import java.util.List;

public interface OneUserDao {
    //添加用户
    public void addUser(OneUser user);
    public void insertUserRole(List<OneUserRole> list);
    //根据用户名查找用户
    public List<OneUser> findUserByName(String username);
    public List<OneUser> findUser();
    //根据用户名修改用户
    public void updateUser(OneUser user);
    //根据用户名删除用户
    public void deleteUser(String[] ids);
    public void deleteUserRole(String[] ids);
    //表单赋值
    public OneUser getUserById(int id);
}
