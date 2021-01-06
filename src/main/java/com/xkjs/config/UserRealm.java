package com.xkjs.config;

//import com.xkjs.mapper.UserMapper;
import com.xkjs.mapper.UserMapper;
import com.xkjs.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("执行授权");
        //授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addRole("1");
        //拿到当前登陆对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser=(User) subject.getPrincipal();
        //设置当前用户的权限
        info.addRole(currentUser.getRole());
        return info;
    }
    @Autowired
    UserMapper userMapper;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证");
        //用户名密码数据库获取
        //String name="root";
        // String password="123456";
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
        User users= userMapper.getUserByName(usertoken.getUsername());
        if(users==null){//用户不存在
            return null;
        }//密码认证shiro做,加密
        //System.out.println(users.getPassword());
        return new SimpleAuthenticationInfo(users,users.getPassword(),"");
    }
}
