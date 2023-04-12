package com.github.myutils.log;

import com.github.myutils.date.DateUtils;
import com.github.myutils.ip.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author Dooby Kim
 * @Date 2023/4/12 7:11 下午
 * @Version 1.0
 * <p>
 * 日志切面
 */
@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(com.github.myutils.log.Log)")
    private void advice() {
    }

    @Around("advice()")
    public void doAround(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
            log.info("save log ...");
            saveLog(joinPoint);
        } catch (Throwable e) {
            log.error("error message : {}, cause : {}", e.getMessage(), e.getCause());
            throw new RuntimeException(e);
        }
    }

    private void saveLog(ProceedingJoinPoint joinPoint) throws Exception {
        LogBean logBean = new LogBean();
        // 设置访问时间
        logBean.setAccessTime(DateUtils.getDate());
        // 设置方法名
        String className = joinPoint.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        logBean.setRequestMethod(className + "#" + methodName);
        // 设置 host ip
        logBean.setHostIp(IPUtils.getHostIp());
        // 设置 client ip
        logBean.setClientIp(IPUtils.getClientIp(request));

        // TODO 存入数据库
        log.info(logBean.toString());

    }
}
