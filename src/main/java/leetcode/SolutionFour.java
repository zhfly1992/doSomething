package leetcode;

import java.util.Arrays;

/**
 * 排序 + 双指针
 * https://leetcode-cn.com/problems/3sum-closest/solution/zui-jie-jin-de-san-shu-zhi-he-by-leetcode-solution/
 */
public class SolutionFour {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closeNum = nums[0] + nums[1] + nums[2];
        int p = 0;
        for(int i = 0;i <= nums.length -2;i++){
           int j = i+1;
           p = nums.length -1;
           //借助双指针，可以对枚举的过程进行优化,减少了枚举的范围
           while (j < p){
               int three = nums[i] + nums[j] + nums[p];
               if (Math.abs(closeNum -target) > Math.abs(three -target)){
                    closeNum =three;
               }
               if (three > target){
                   p--;
               }
               else if (three < target){
                   j++;
               }
               else {
                   return three;
               }
           }
        }
        return closeNum;
    }

    public static void main(String[] args) {
        SolutionFour solutionFour = new SolutionFour();
        int[] a = new int[4];
        a[0] = -1;;
        a[1] = 2;
        a[2] = 1;
        a[3] = -4;
        int b = solutionFour.threeSumClosest(a,1);
        System.out.println(b);
    }
}
