package leetcode;

import java.util.Stack;

/**
 * 栈的相关应用
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
class SolutionTwelve {
    public  boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        if (s.length() %2 != 0){
            return false;
        }
        Stack<Character> mystack = new Stack<Character>();
        for (char a: s.toCharArray()) {
            if (mystack.empty()){
                mystack.push(a);
            }
            else{
                if (a == '{' || a == '[' || a == '(') {
                    mystack.push(a);
                }
                else{
                    Character peek = mystack.peek();
                    if (peek == '{'){
                        if (a == '}'){
                            mystack.pop();
                        }
                        else{
                            return false;
                        }
                    }
                    if (peek == '['){
                        if (a == ']'){
                            mystack.pop();
                        }
                        else{
                            return false;
                        }
                    }
                    if (peek == '('){
                        if (a == ')'){
                            mystack.pop();
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
        }
        if (mystack.empty()){
            return  true;
        }
        else {
            return false;
        }

    }


    public static void main(String[] args) {
        String a = "(]";
        SolutionTwelve solutionTwelve = new SolutionTwelve();
        System.out.println(solutionTwelve.isValid(a));
    }
}
