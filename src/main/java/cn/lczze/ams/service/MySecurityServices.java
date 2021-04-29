package cn.lczze.ams.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lczze on 2021/4/3 8:51
 */
public interface MySecurityServices {

    public boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
