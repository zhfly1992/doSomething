package leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 * 全排列2-回溯（注意剪枝条件） 看liweiwei的讲解
 */
public class Solution22 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }
        boolean[] judge = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result,temp,judge,nums);
        return result;
    }

    public void dfs(List<List<Integer>> result,List<Integer> temp,boolean[] judge,int[] nums){
        //选择的list长度等于数组长，已选完
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i =0;i<nums.length;i++){
            if (judge[i]){
                continue;
            }
            /**
             * 如果当前位置和上一个位置相等，且上一个位置未被选择，则剪枝
             * 比如1a,1b,1c,正常选择后1a,1b,1c
             * 当1a位置回溯，判断到1b位置时，发现1a=1b,且1a未被选择,则剪枝(1b,1a,1c是重复选择,!judge[i-1]这个条件理解成判断是否是回溯)
             * 若是不加!judge[i-1]这个条件，当1a选了后，无法进行后续选择，因为1b=1a,但是1a,1b,1c序列符合条件
             *
             */


            if (i > 0 && nums[i] == nums[i-1]&& !judge[i-1]){
                continue;
            }
            temp.add(nums[i]);
            judge[i] = true;
            dfs(result,temp,judge,nums);
            temp.remove(temp.size() -1);
            judge[i] = false;
        }

    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<List<Integer>> lists = solution22.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }
}
