package cn.lczze.ams.service.Impl;

import cn.lczze.ams.dao.UserInfoDao;
import cn.lczze.ams.entity.SysLog;
import cn.lczze.ams.entity.UserInfo;
import jdk.nashorn.internal.ir.RuntimeNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by lczze on 2021/4/1 9:34
 */

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoDao userInfoDao;


    @Autowired
    private HttpServletRequest request;
    /**
     * 自定义登录逻辑
     * @param u
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String u) throws AuthenticationException {


        log.info("执行了===============loadUserByUsername================");

        String username = userInfoDao.findUsername(u);

        if (username == null){
            throw new UsernameNotFoundException("用户名不存在！！！");
        }
          String password = userInfoDao.findPasswordByUsername(u);
          UserInfo userRole = null;

          if (password != null && !password.equals("") && username != null && !username.equals("")){
              userRole = userInfoDao.findUserRole(username);

              HttpSession session = request.getSession();
              //头像
              session.setAttribute("avatar", userRole.getAvatar());
              session.setAttribute("userId", userRole.getId());
              //账号
              session.setAttribute("userName", userRole.getUsername());
              //用户昵称
              session.setAttribute("nickName", userRole.getNickName());
              //邮箱
              session.setAttribute("email", userRole.getEmail());
              //性别
              session.setAttribute("sex", userRole.getSex());
              //手机号
              session.setAttribute("phoneNum", userRole.getPhoneNum());
              session.setAttribute("sign", userRole.getSign());
              //当前角色
              session.setAttribute("userRole", userRole.getRoleList().getRoleDesc());
          }

        return new User(u,password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+userRole.getRoleList().getRoleName()));
    }
}
