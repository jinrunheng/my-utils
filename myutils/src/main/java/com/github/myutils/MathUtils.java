package com.github.myutils;

/**
 * @Author Dooby Kim
 * @Date 2023/2/15 11:30 下午
 * @Version 1.0
 */
public class MathUtils {

    /**
     * 获取两个正整数的最大公约数
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int gcd(int num1, int num2) {
        int res = num2;
        while (num1 % num2 != 0) {
            res = num1 % num2;
            num1 = num2;
            num2 = res;
        }

        return res;
    }
}
