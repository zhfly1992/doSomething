package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-common-characters/
 * 查找常用字符--自己的憨憨解法太笨重（耗时长），参考官方解法
 */
class Solution29 {
    public List<String> commonChars(String[] A) {

        if (A.length == 0) {
            return null;
        }
        int resultSize = Integer.MAX_VALUE;
        int mark = 0;
        for (int i = 0; i < A.length; i++) {
            if (resultSize > A[i].length()) {
                resultSize = A[i].length();
                mark = i;
            }
        }
        List<String> result = new ArrayList<>(resultSize);
        String baseString = A[mark];
        boolean remove = true;
        for (int m = 0;m < baseString.length();m++){
            remove = true;
            char c = baseString.charAt(m);
            for (int n = 0;n < A.length;n++){

                if (!A[n].contains(String.valueOf(c))){
                    remove = false;
                    break;
                }
            }
            if (remove){
                result.add(String.valueOf(c));
                for (int j =0;j <A.length;j++){
                    StringBuilder a = new StringBuilder(A[j]);
                    int i = a.indexOf(String.valueOf(c));
                    a.deleteCharAt(i);
                    A[j] = a.toString();
                }
            }
        }
        return result;
    }
}