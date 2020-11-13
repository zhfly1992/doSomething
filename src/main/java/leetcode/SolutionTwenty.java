package leetcode;


import java.util.*;

public class SolutionTwenty {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<String> check = new HashSet<>();
        dfs(result,candidates,0,target,temp,check);

        return result;
    }

    public void dfs(List<List<Integer>> result, int[] candidates, int index, int target, List<Integer> temp,Set<String> check) {
        if (target == 0) {
            List<Integer> copy = new ArrayList<>(temp);
            Collections.sort(copy);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i :copy) {
                stringBuffer.append(i);
            }
            if (!check.contains(stringBuffer.toString())){
                result.add(new ArrayList<>(temp));
                check.add(stringBuffer.toString());
            }
            return;
        }
        if (index > candidates.length -1){
            return;
        }
        else {
            //当前位置的数大于目标数
            if (candidates[index] > target) {
                dfs(result,candidates,index + 1,target,temp,check);
            }
            else {
                //将当前位置加入到组合中
                temp.add(candidates[index]);
                dfs(result,candidates,index + 1,target -candidates[index],temp,check);
                //不要当前位置
                temp.remove(temp.size() -1);
                dfs(result,candidates,index + 1,target,temp,check);
            }

        }
    }

    public static void main(String[] args) {
        SolutionTwenty solution = new SolutionTwenty();
        int[] candi = new int[]{2,5,2,1,2};
        int target = 5;
        List<List<Integer>> lists = solution.combinationSum2(candi, target);
        System.out.println(lists);
    }
}
