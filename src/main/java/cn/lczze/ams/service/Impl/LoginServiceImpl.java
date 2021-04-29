package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.UserInfoDao;
import cn.lczze.ams.entity.UserInfo;
import cn.lczze.ams.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lczze on 2021/3/3 19:16
 */
@Service
public class LoginServiceImpl implements Loginservice {

    @Autowired
    private UserInfoDao userDao;

    @Autowired
    private HttpServletRequest request;





//    @Override
//    public UserInfo checkUser(String username, String password) {
//        return userDao.findByUsernameAndPassword(username,password);
//
//    }



    @Override
    public void updateAvatar(String avatar) {
        HttpSession session = request.getSession();
        Object userId =  session.getAttribute("userId");
        userDao.updateAvatar(avatar,userId);
        session.setAttribute("avatar", avatar);
    }

    @Override
    public void updateUser(String nickName, String email, String phoneNum, String sign) {
        HttpSession session = request.getSession();
        Object userId =  session.getAttribute("userId");

        System.out.println(nickName+""+email+""+phoneNum+""+sign+"");

        if (email != null && nickName != null && phoneNum != null && sign != null) {
            userDao.updateUser(nickName, email, phoneNum, sign, userId);

            //账号
            session.setAttribute("nickName", nickName);

            //邮箱
            session.setAttribute("email", email);

            //手机号
            session.setAttribute("phoneNum", phoneNum);
            session.setAttribute("sign", sign);
            //当前角色


        }
    }
}
