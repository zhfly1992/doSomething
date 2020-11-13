package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/solution/216-zu-he-zong-he-iiihui-su-fa-mo-ban-ti-by-carlsu/
 * 组合总和 III   回溯
 */
public class Solution20 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (n == 0){
            return result;
        }
        if (k == 0 || k > 9){
            return result;
        }
        if (k == 1 && n > 9){
            return result;
        }
        if (k == 1 && n < 9){
            temp.add(n);
            result.add(temp);
            return result;
        }
        dfs(1,k,n,result,temp);
        return result;

    }


    public void dfs(int begin,int count,int left,List<List<Integer>> result,List<Integer> temp){
        if (count == 0 && left == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if (count == 0){
            return;
        }
        if (begin > 9){
            return;
        }
        if (begin > left){
            return;
        }
        else{
            temp.add(begin);
            //选择当前位置
            dfs(begin +1,count -1,left -begin,result,temp);
            temp.remove(temp.size() -1);
            //不选择当前位置
            dfs(begin +1,count,left,result,temp);
        }

    }

    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        List<List<Integer>> lists = solution.combinationSum3(3, 9);
        System.out.println(lists);
    }

}
