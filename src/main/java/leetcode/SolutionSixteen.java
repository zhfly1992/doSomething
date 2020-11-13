package leetcode;

/**
 * https://leetcode-cn.com/problems/predict-the-winner/solution/yu-ce-ying-jia-by-leetcode-solution/
 * 预测赢家
 */
public class SolutionSixteen {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        if (length == 1 || length == 2){
            return true;
        }
        return total(0,length -1,nums) >= 0;
    }


    //分别计算从左边取和从右边取，做出选择的一方得分为正，另一方得分为负
    public int total(int start,int end,int nums[]){
        //只有一个数字的时候，取该数字
        if (start == end){
            return nums[start];
        }
        //从左边取，对于取数玩家来说，取了该数字后，另一方即从剩下的数字中选择最大的方案(得分为负)
        int left = nums[start] - total(start +1,end,nums);
        //从右边取
        int right = nums[end] - total(start,end -1,nums);
        //返回最大的值
        return Math.max(left,right);
    }
}
