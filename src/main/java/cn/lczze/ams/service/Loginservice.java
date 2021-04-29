package cn.lczze.ams.service;

import cn.lczze.ams.entity.UserInfo;

/**
 * Created by lczze on 2021/3/3 19:16
 */
public interface Loginservice {

//    UserInfo checkUser(String username, String password);

      void updateAvatar(String avatar);


      void updateUser(String nickName,String password,String phoneNum, String sign);


}
