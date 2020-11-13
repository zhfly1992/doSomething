package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列问题，回溯
 */
public class SolutinEighteen {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0 || n == 0 || n < k){
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(result,n,k,1,temp);
        return result;
    }

    public void dfs(List<List<Integer>> result,int n, int k ,int begin,List<Integer> temp){
        if (temp.size() + n -begin + 1 < k){
            return;
        }

        if (temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }
        else {
            temp.add(begin);
            dfs(result,n,k,begin + 1,temp);
            temp.remove(temp.size() -1);
            dfs(result,n,k,begin + 1,temp);
        }

    }

    public static void main(String[] args) {
        SolutinEighteen solution = new SolutinEighteen();
        List<List<Integer>> combine = solution.combine(5, 3);
        System.out.println(combine);
    }

}
