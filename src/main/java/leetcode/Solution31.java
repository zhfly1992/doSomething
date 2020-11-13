package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 有序数组的平方---各种排序
 */
public class Solution31 {
    public int[] sortedSquares(int[] A) {

        for (int i = 0;i < A.length;i++){
            A[i] = A[i] * A[i];
        }
        //冒泡排序，太耗时
/*        int temp;
        for (int i = 0;i < A.length -1;i++){
            for (int m = i + 1;m < A.length;m++){
                if (A[i] > A[m]){
                    temp = A[i];
                    A[i] = A[m];
                    A[m] = temp;
                }
            }
        }*/
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares1(int [] A){
         return Arrays.stream(A).map(a -> a * a).sorted().toArray();
    }
}
