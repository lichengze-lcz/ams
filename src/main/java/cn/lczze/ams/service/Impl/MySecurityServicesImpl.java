package cn.lczze.ams.service.Impl;

import cn.lczze.ams.service.MySecurityServices;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * Created by lczze on 2021/4/3 8:53
 */
//public class MySecurityServicesImpl implements MySecurityServices {
//
//    @Override
//    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
//
//        //获取主体
//        Object obj = authentication.getPrincipal();
//
//        if(obj instanceof UserDetails){
//          UserDetails userDetails = (UserDetails) obj;
//
//            //拿到角色对应的权限
//            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//            //判断权限里有没有包含的Url   You  true
//            return authorities.contains(new SimpleGrantedAuthority(request.getRequestURI()));
//        }
//
//        return false;
//    }
//}
