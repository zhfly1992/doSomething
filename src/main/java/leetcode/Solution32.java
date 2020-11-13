package leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * 比较含退格的字符串
 */
public class Solution32 {
    public boolean backspaceCompare(String S, String T) {
        if (S.equals(T)){
            return true;
        }
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        StringBuffer sRe = new StringBuffer();
        StringBuffer tRe = new StringBuffer();
        for (int i = 0;i < S.length();i++){
            if (S.charAt(i) != '#'){
                sStack.push(S.charAt(i));
            }
            else if(!sStack.empty()){
                sStack.pop();
            }
        }
        for (int i = 0;i < T.length();i++){
            if (T.charAt(i) != '#'){
                tStack.push(T.charAt(i));
            }
            else if(!tStack.empty()){
                tStack.pop();
            }
        }
        for (Character a:sStack){
            sRe.append(a);
        }
        for (Character b:tStack){
            tRe.append(b);
        }
        if (sRe.toString().equals(tRe.toString())){
            return true;
        }
        else {
            return false;
        }

    }
}
