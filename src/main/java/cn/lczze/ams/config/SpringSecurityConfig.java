package cn.lczze.ams.config;

import cn.lczze.ams.handle.MyAccessDeniedHandler;
import cn.lczze.ams.handle.MyAuthenticationFailureHandler;
import cn.lczze.ams.service.Impl.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Created by lczze on 2021/3/30 9:18
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    //登录逻辑
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //数据源
    @Autowired
    private DataSource dataSource;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin()
                .loginProcessingUrl("/toLogin")
                //自定义登录配置
                .loginPage("/")
                //成功后跳转的页面（必须是Post请求）
                .successForwardUrl("/index")
                //登录失败后跳转的页面
//                .failureForwardUrl("/toError");
                //自定义失败后页面
                .failureHandler(new MyAuthenticationFailureHandler("/toError"));


        //授权认证
        http.authorizeRequests()
                //login.html 不需要被认证
                .antMatchers("/","/toError").permitAll()
//                .antMatchers("/checkCode").permitAll()
                .antMatchers("/js/**","/css/**").permitAll()
                //所有请求都必须被认证，必须登录之后被访问
                .anyRequest().authenticated();



        //关闭csrf防火墙
        http.csrf().disable();

        //异常处理 403
        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);

        //记住我
        http.rememberMe()
                //自定义失效时间 60s
                .tokenValiditySeconds(600)
                //自定义登录逻辑
                .userDetailsService(userDetailsService)
                //持久层对象  把登录信息保存到数据库
                .tokenRepository(persistentTokenRepository);

        //退出登录功能
        http.logout()
                .logoutSuccessUrl("/");
    }

    //加密
    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }

    //持久化
    @Bean
    public PersistentTokenRepository getPersistentTokenRepository(){

        JdbcTokenRepositoryImpl  jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        //拿到数据源
        jdbcTokenRepository.setDataSource(dataSource);
        //第一次 启动时创建一张表 保存登录信息 （第二次启动要注释掉）
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return  jdbcTokenRepository;
    }
}
