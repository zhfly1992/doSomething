package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/submissions/
 * 组合综合--回溯
 */
public class SolutionNineteen {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> filter = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i: candidates) {
            //等于目标，直接将该数字添加到结果
            if (i == target) {
                List<Integer> tempone = new ArrayList<>();
                tempone.add(i);
                result.add(tempone);
            }
            //小于目标，添加到新的数组里.大于的直接不要
            if (i < target) {
                filter.add(i);
            }
        }
        Integer[] filterArray = filter.toArray(new Integer[filter.size()]);
        dfs(0,filterArray,result,temp,0,target);

        return result;
    }

    public void dfs(int index,Integer[] array,List<List<Integer>> result,List<Integer> temp,int count,int target){
        //越界，直接返回
        if (index > array.length -1){
            return;
        }
        //正好等于目标数，添加进结果
        if (count == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        //大于目标数，直接返回
        else if (count > target){
            return;
        }
        else {
            /**
             * 优化方案，将数组排序，当count+当前位置大于target时，可直接return,当前数和后面的都不用再选
             */
            //将当前数添加进temp
            temp.add(array[index]);
            dfs(index,array,result,temp,count + array[index] ,target);
            temp.remove(temp.size() -1);
            dfs(index +1,array,result,temp,count,target);
        }
    }

    public static void main(String[] args) {
        SolutionNineteen solution = new SolutionNineteen();
        int[] candicates = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> lists = solution.combinationSum(candicates, target);
        System.out.println(lists);
    }
}
