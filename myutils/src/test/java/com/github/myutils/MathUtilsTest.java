package com.github.myutils;

import com.github.myutils.math.MathUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author Dooby Kim
 * @Date 2023/2/15 11:35 下午
 * @Version 1.0
 */
class MathUtilsTest {

    @Test
    void gcd() {
        Assertions.assertEquals(MathUtils.gcd(9, 12), 3);
    }
}