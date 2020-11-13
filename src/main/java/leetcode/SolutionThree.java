package leetcode;

public class SolutionThree {
    public boolean isPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (; i <= j; ) {
            if (!Character.isLetterOrDigit(chars[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(chars[j])) {
                j--;
            } else {
                if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
                    flag = false;
                    break;
                }
                i++;
                j--;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        SolutionThree solution = new SolutionThree();
        System.out.println(solution.isPalindrome("race a car"));
    }
}