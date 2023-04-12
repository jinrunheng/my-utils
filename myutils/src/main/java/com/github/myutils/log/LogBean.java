package com.github.myutils.log;

import lombok.*;

import java.util.Date;

/**
 * @Author Dooby Kim
 * @Date 2023/4/12 7:26 下午
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LogBean {
    /**
     * 访问方法名
     */
    private String requestMethod;

    /**
     * 本地（服务器） IP
     */
    private String hostIp;

    /**
     * 访问客户端 IP
     */
    private String clientIp;

    /**
     * 访问时间
     */
    private String accessTime;
}
