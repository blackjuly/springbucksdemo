package com.wh.datastructure.containerwithmostwater;

/**
 * @author 28476 WangHao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @version 1.0
 * @date 2020/07/29 14:24
 * desc :
 */
public class Solution1 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                max = Math.max(max,(j-i)*minHeight);
            }
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
