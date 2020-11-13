package leetcode;

/**
 * @author Administrator
 *
 * 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
 */
public class SolutionSeven {
    public int findLength(int[] A, int[] B) {
        int maxlength = 0;
        for (int i = 0;i < A.length;){
            int j = 0;
            while (j < B.length && A[i] != B[j]){
                j++;

            }
            if (j == B.length){
                i = i + 1;
            }
            else{
                int cl = 1;
                int currentlength = 1;
                for (;j < B.length;){

                    if (i + currentlength < A.length && j + currentlength < B.length){
                        if (A[i + currentlength] == B[j + currentlength]){
                            currentlength ++;
                        }else{
                            j++;
                            cl =currentlength;
                            currentlength =1;
                        }
                    }
                    else{
                        j++;
                        cl =currentlength;
                        currentlength =1;
                    }

                    if (cl >= maxlength){
                        maxlength = cl;
                    }
                }

                i = i+ maxlength;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        SolutionSeven solution = new SolutionSeven();
        int[] A = {1,0,0,0,1,0,0,1,0,0};
        int[] B = {0,1,1,1,0,1,1,1,0,0};
        System.out.println(solution.findLength(A,B));

     }
}
