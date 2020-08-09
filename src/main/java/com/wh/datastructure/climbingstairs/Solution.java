package com.wh.datastructure.climbingstairs;
/**
 * @author wanghao <a href="hao.wang@1hai.cn">Contact me.</a>
 * date  2020/7/29
 *
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1,b = 2,c = 3;
        for (int i = 3; i < n+1 ;++i){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
    }


}