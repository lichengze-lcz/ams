//package cn.lczze.ams.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//
///**
// * Created by lczze on 2021/4/20 8:32
// */
//
//@Slf4j
//@Aspect
//@Component
//public class LogAspect {
//
//
//    private Long visitTime;
//    private Class clazz;
//
//    @Pointcut("execution(public * cn.lczze.ams.controller.*.*(..))")
//    private  void  aspect(){}
//
//
//    @Before("aspect()")
//    public void before(JoinPoint joinPoint) throws NoSuchMethodException{
//        visitTime = System.currentTimeMillis();
//
//        //请求时间
//        Date date = new Date(visitTime);
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(date);
//
//        clazz = joinPoint.getTarget().getClass();
//        log.warn(clazz+"===============================================");
//        String methodName = joinPoint.getSignature().getName();
////        Object target = joinPoint.getTarget().getClass().getName();
//        log.info(methodName+"---------methodName--------------");
//        Object[] args = joinPoint.getArgs();
//
//        Method method;
//        if (args == null || args.length == 0){
//            method = clazz.getMethod(methodName);
//        }else{
//            Class[] argsClass = new Class[args.length];
//            for (int i = 0; i < args.length; i++) {
//              argsClass[i] = args[i].getClass();
//            }
//            log.warn(methodName+"===============================================");
//            log.warn(argsClass+"===============================================");
////            method = clazz.getMethod(methodName,argsClass);
//        }
//
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//        log.info("-------------------请求内容--开始------------------------");
//        String requestMethod = request.getMethod();
//        log.info("请求时间"+ new SimpleDateFormat().format(date));
//        log.info("请求IP"+request.getRemoteAddr());
//        log.info("请求地址"+request.getRequestURI());
//        log.info("请求方式"+requestMethod);
//        log.info("请求类方法"+joinPoint.getSignature());
//        log.info("请求类方法参数"+ Arrays.toString(joinPoint.getArgs()));
//        String url = "";
//
//        if (clazz != null ){
//            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
//            if (clazzAnnotation != null) {
//                String[] classValue = clazzAnnotation.value();
//                if ("GET".equals(requestMethod)) {
////                    GetMapping methodAnnotation = method.getAnnotation(GetMapping.class);
////                    url(classValue,methodAnnotation != null,methodAnnotation.value());
////
//                } else {
////                    PostMapping methodAnnotation = method.getAnnotation(PostMapping.class);
////                    url(classValue,methodAnnotation != null,methodAnnotation.value());
//                }
//            }
//
//            log.info("类名：{}， 方法{}",clazz.getName(),methodName);
//            log.info("-------------------请求内容--开结束------------------------");
//        }
//
//    }
//
//    @AfterReturning(returning = "obj",pointcut = "aspect()")
//    public void methodAfterReturning(Object[] obj){
//        long time = System.currentTimeMillis() - visitTime;
//        log.info("执行时长",time/1000);
//        log.info("-------------------返回内容---------======================================================---------------");
//
////        log.info(mapper);
//        log.info("-------------------请求内容--开结束------------------------");
//
//
//    }
//
//    private  void url(String[] classValue,boolean b,String[] value){
//        String url;
//        if(b){
//            String[] methodValue = value;
//            url = classValue[0] + methodValue[0];
//            log.info("url:{}",url);
//        }
//    }
//
//
//    @After(aspect("aspect()")) //在切入点的方法run之前要干的
//    public void logAfterController(JoinPoint joinPoint) {
//        logger.info("################Time : ");
//    }
//
//}
