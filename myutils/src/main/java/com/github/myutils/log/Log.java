package com.github.myutils.log;

import java.lang.annotation.*;

/**
 * @Author Dooby Kim
 * @Date 2023/4/12 10:20 上午
 * @Version 1.0 日志注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {
}
