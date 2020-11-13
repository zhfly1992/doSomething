package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * 按奇偶排序数组 II
 * 自己的方法太烂，看看结题
 */

class Solution38 {
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        //题目的限制条件
        //2 <= A.length <= 20000
        //A.length % 2 == 0
        //0 <= A[i] <= 1000
        //存储奇数
        int odd[] = new int[A.length /2];
        //存储偶数
        int even[] = new int[A.length /2];
        int oddMark = 0;
        int evenMark = 0;
        for (int i = 0;i < A.length;i++){
            if (A[i] % 2 == 0){
                //是偶数，放入偶数数组
                even[evenMark] = A[i];
                evenMark++;
            }
            else{
                //是奇数，放入奇数数组
                odd[oddMark] = A[i];
                oddMark++;
            }
        }
        Arrays.sort(odd);
        Arrays.sort(even);
        //循环放入完后标记值加了1，越界，需要减去1保证数组不越界
        oddMark--;
        evenMark--;
        for (int j = 0;j < A.length;j++){
            if (j % 2 == 0){
                //下标为偶数
                A[j] = even[evenMark];
                evenMark--;
            }
            else {
                //下标为奇数
                A[j] = odd[oddMark];
                oddMark--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int test[] = {4,2,5,7};
        Solution38 solution = new Solution38();
        int[] ints = solution.sortArrayByParityII(test);
        System.out.println(ints);
    }
}
