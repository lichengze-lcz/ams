//package cn.lczze.ams.controller;
//
///**
// * Created by lczze on 2021/4/21 22:49
// */
//import java.util.Arrays;
//import java.util.Date;
//
//import javax.servlet.http.HttpServletRequest;
//
//import cn.lczze.ams.entity.SysLog;
//import cn.lczze.ams.service.ISysLogService;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//@Aspect
//@Component
//public class webAop {
//
//    @Autowired
//    private ISysLogService sysLogService;
//
//
//    private long visitTime;
//
//
//    private final Logger logger = LoggerFactory.getLogger(webAop.class);
//
//    @Pointcut("execution(public * cn.lczze.ams.controller.*.*(..))")//切入点描述 这个是controller包的切入点
//    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称
//
//    @Pointcut("execution(public * cn.lczze.ams.controller.*.*(..))")//切入点描述，这个是uiController包的切入点
//    public void uiControllerLog(){}
//
//    @Before("controllerLog() || uiControllerLog()") //在切入点的方法run之前要干的
//    public void logBeforeController(JoinPoint joinPoint) {
//
//        visitTime = System.currentTimeMillis();
////
//
//
//    }
//
//    @After("controllerLog() || uiControllerLog()")
//    public void logAfterController(JoinPoint joinPoint) throws Exception {
//
//
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
//        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//
//        // 记录下请求内容
//        logger.info("################URL : " + request.getRequestURL().toString());
//        logger.info("################HTTP_METHOD : " + request.getMethod());
//        logger.info("################IP : " + request.getRemoteAddr());
//        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
//
////        下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
//        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
//        logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象
//
//
//
//        //        //请求时间
//        Date date = new Date(visitTime);
//        logger.info(date+"请求时间--------开始请求--------------");
//
//
//
//         long  visitAfter = System.currentTimeMillis();
//        long time = visitAfter-visitTime;
//        logger.info(time+"s");
////
////        //请求时间
//        Date dateAfter = new Date(visitTime);
//        logger.info(dateAfter+"请求时间---------dateAfter-------------");
//
//
//         long t =  dateAfter.getTime() - date.getTime();
//        logger.info(t+"请求时间---------TTTTTT-------------");
////        将日志相关信息封装到SysLog 对象里
//                    SysLog sysLog = new SysLog();
//
////                    sysLog.setExecutionTime(time);
//                    sysLog.setIp(request.getRemoteAddr());
//                    sysLog.setMethod("[类名] "+joinPoint.getSignature().getDeclaringTypeName()+"[方法名 ]"+joinPoint.getSignature().getName());
//                    sysLog.setUrl(request.getRequestURL().toString());
////                    sysLog.setUsername(username);
////                    sysLog.setVisitTime(visitTime);
////                    sysLog.setExecutionTime(time);
////                     sysLogService.save(sysLog);
//
//
//    }
//
//
//}