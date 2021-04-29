package cn.lczze.ams.controller;


import cn.lczze.ams.entity.SysLog;
import cn.lczze.ams.service.ISysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint; //#aspectj
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Component  //日志
@Aspect     //切面
@Slf4j
public class LogAop {

    @Autowired
    private ISysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;  //request 用于获取请求的IP地址

    private Date visitTime;//访问开始时间
    private Class clazz;//访问的类
    private Method method;//访问的方法



    /**
     * 定义后置通知的表达式
     *
     * @Pointcut 声明切入点表达式
     */
    @Pointcut("execution(public * cn.lczze.ams.controller.*.*(..))")
    public void afterTimeTest() {}


    //前置通知，主要获取开始时间，执行的类是哪一个，执行的是哪一个方法
    @Before("execution(public * cn.lczze.ams.controller.*.*(..))")  //拦截了当前 Controller 下所有的方法
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();//获取开始访问的时间
    }

    //后置通知
    @After(value = "afterTimeTest()")  //拦截了当前 Controller 下所有的方法
    public void doAfter(JoinPoint joinPoin) throws Exception {

        //#获取访问时长   总时长=后置时间-前置时间
        long time = new Date().getTime()-visitTime.getTime();
//        log.info(time+"毫秒");
//
//
//        // 记录下请求内容
//        log.info("################ 请求地址URL : " + request.getRequestURL().toString());
//        log.info("################ 请求方式 : " + request.getMethod());
//        log.info("################ 请求IP : " + request.getRemoteAddr());
//        log.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoin.getArgs()));
//
////        下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
//        log.info("################CLASS_METHOD : " + joinPoin.getSignature().getDeclaringTypeName() + "." +joinPoin.getSignature().getName());
//        log.info("################TARGET: " + joinPoin.getTarget());//返回的是需要加强的目标类的对象
//        log.info("################THIS: " + joinPoin.getThis());//返回的是经过加强后的代理类的对象


//        将日志相关信息封装到SysLog 对象里
        SysLog sysLog = new SysLog();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            sysLog.setUsername(authentication.getName());
        }
        sysLog.setExecutionTime(time);
        sysLog.setIp(request.getRemoteAddr());
        sysLog.setMethod("[类名] "+joinPoin.getSignature().getDeclaringTypeName()+"[方法名 ]"+joinPoin.getSignature().getName());
        sysLog.setUrl(request.getRequestURL().toString());
        sysLog.setVisitTime(visitTime);
        sysLogService.save(sysLog);
    }

}




