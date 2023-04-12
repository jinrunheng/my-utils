package com.github.myutils.log.test;

import com.github.myutils.log.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dooby Kim
 * @Date 2023/4/12 7:38 下午
 * @Version 1.0
 */
@RestController
public class TestController {

    @Log()
    @GetMapping("/test")
    public String send() {
        return "success";
    }
}
