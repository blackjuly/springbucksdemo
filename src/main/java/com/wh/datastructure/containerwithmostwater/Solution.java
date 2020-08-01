package com.wh.datastructure.containerwithmostwater;
/**
 * @author wanghao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @date  2020/7/29
 * desc : 一维数组坐标变换
 *  i，j 交换
 * 1.枚举 左右柱子， （x-y）*height_diff
 * 2.O(n),左右边界 i,j向中间收敛，左右夹逼
 */
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int j = height.length - 1;
        for (int i = 0; i < j; ) {
            //死记硬背这种单循环控制两边的！！！
            int minHeight = height[i] > height[j]?height[j--]:height[i++];
            max = Math.max(max,minHeight*(i - j + 1));
        }
        return max;
    }



    public static void main(String[] args) {
        //int[] height = {1,2,1};
       // int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(new Solution().maxArea(height));
    }


}