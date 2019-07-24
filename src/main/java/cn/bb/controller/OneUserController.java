package cn.bb.controller;

import cn.bb.model.OneUser;
import cn.bb.model.OneUserRole;
import cn.bb.service.OneUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/one")
public class OneUserController {
    @Autowired
    private OneUserService oneUserService;
    /*
    * 插入用户 和用户角色表
    * */
    @RequestMapping("/register")
    @ResponseBody
    public void addUser(@RequestBody  OneUser user){
        System.out.println("123456");
        oneUserService.register(user);
        ArrayList<OneUserRole> list = new ArrayList<>();
        if(user!=null && user.getRole()!= null && user.getRole() != ""){
            String[] split = user.getRole().split(",");
            for (String s:split){
                OneUserRole oneUserRole = new OneUserRole();
                oneUserRole.setRoleId(Integer.parseInt(s));
                oneUserRole.setUserId(user.getId());
                list.add(oneUserRole);
            }
        }
        if(list.size()>0){
            oneUserService.insertUserRole(list);
            System.out.println(1111);
        }

    }
    //根据用户名查找用户
    @ResponseBody
    @RequestMapping("/getUserByName")
    public List<OneUser> getUserByName(String username){
        List<OneUser> oneUsers = oneUserService.find(username);
        return oneUsers;
    }
    //显示出所有的用户
    @ResponseBody
    @RequestMapping("/getAllUserByName")
    public List<OneUser> getAllUserByName(){
        List<OneUser> oneUsers = oneUserService.findUser();
        return oneUsers;
    }
    //修改用户
    @ResponseBody
    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody OneUser user){
        //全删 根据用户id删除中间表
        String[] userids = new String[1];
        Integer id = user.getId();
        userids[0] = id.toString();
        oneUserService.deleteUserRole(userids);
        //全插
        String role = user.getRole();
        ArrayList<OneUserRole> list = new ArrayList<>();
        if(!"".equals(role)){
            String[] split = role.split(",");
            for(String s : split){
                OneUserRole oneUserRole = new OneUserRole();
                oneUserRole.setUserId(id);
                oneUserRole.setRoleId(Integer.parseInt(s));
                list.add(oneUserRole);
            }
        }
        oneUserService.insertUserRole(list);
        oneUserService.update(user);
    }
    @ResponseBody
    @RequestMapping("/deleteUser")
    public void  deleteUser(String ids){
        String[] split = ids.split(",");
        oneUserService.deleteUserRole(split);
        oneUserService.delete(split);
    }
    @ResponseBody
    @RequestMapping("/getOneUser")
    public OneUser getOneUser(String ids){
        int id = Integer.parseInt(ids);
        OneUser userById = oneUserService.getUserById(id);
        return userById;
    }
}
