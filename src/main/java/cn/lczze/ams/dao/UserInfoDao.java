package cn.lczze.ams.dao;

import cn.lczze.ams.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lczze on 2021/3/3 19:04    用户信息
 */
@Mapper
@Repository
public interface UserInfoDao {
    //查user信息
    UserInfo findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


    //查询是否有该用户名
    String findPasswordByUsername(@Param("username") String username);

    //根据用户名查询密码
    String  findUsername(@Param("username") String username);

    //根据用户名查询对应角色
    UserInfo findUserRole(@Param("username") String username);

    //更改头像
    void updateAvatar(@Param("avatar") String username,@Param("userId")Object userId);

    //更改用户信息
    void updateUser(@Param("nickName") String nickName,@Param("email") String email,@Param("phoneNum") String phoneNum,@Param("sign") String sign,@Param("userId")Object userId);


    //查user信息
    List<UserInfo> findRole();

}
