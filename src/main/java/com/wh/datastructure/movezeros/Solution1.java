package com.wh.datastructure.movezeros;

/**
 * @author 28476 WangHao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @version 1.0
 * @date 2020/07/27 15:05
 * desc :
 */
public class Solution1 {
    public  void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                if (i > j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]+" ");
        }
    }

    public static void main(String[] args) {
       // int nums[] = {0,1,0,3,12};
        int nums[] = {0,0,0,3,16};
        new Solution1().moveZeroes(nums);
    }
}
