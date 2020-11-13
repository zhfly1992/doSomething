package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 * 划分字母区间---哈希表，双指针
 */
public class Solution35 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0;i < length;i++){
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> part = new ArrayList<>();
        int start = 0,end = 0;
        for (int j = 0;j < length;j++){
            end = Math.max(end,last[S.charAt(j) - 'a']);
            if (j == end){
                part.add(end -start + 1);
                start = end +1;
            }
        }
        return  part;
    }
}
