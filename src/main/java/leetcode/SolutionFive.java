package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  数组中的第K个最大元素
 *  https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class SolutionFive {
    public int findKthLargest(int[] nums, int k) {

        Integer[] a = new Integer[nums.length];
        for (int i= 0;i< nums.length;i++){
            a[i] = nums[i];
        }
        Arrays.sort(a,new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if (a < b){
                    return 1;
                }
                else if (a > b){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        return a[k-1];
    }
}
