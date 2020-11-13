package leetcode;

/**
 * 把数字翻译成字符串  动态规划问题
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class SolutionTwo {
    public int translateNum(int num) {
        String snum = String.valueOf(num);

        int length = snum.length();
        int possible = 1;
        if (length > 1) {
            if (Integer.parseInt(String.valueOf(snum.charAt(0))) > 2) {
                //第一位数字大于2，只有一种翻译方式
                String charSequence = snum.substring(1).toString();
                possible = possible * translateNum(Integer.parseInt(charSequence));
            }
            else {
                //第一位数字为1，则有两种翻译方式
                if (Integer.parseInt(String.valueOf(snum.charAt(0))) ==1){
                    String a = snum.substring(1).toString();
                    int possibleOne = translateNum(Integer.parseInt(a));
                    String b = snum.substring(2);
                    if (b.length() != 0){
                        int possibleTwo = translateNum(Integer.parseInt(b));
                        possible = possibleOne + possibleTwo;
                    }
                    else{
                        possible = possibleOne + 1;
                    }

                }
                else{
                    //第一位数字为2，考虑第二位数字大小，小于等于5有两种，大于5有一种
                    if (Integer.parseInt(String.valueOf(snum.charAt(1))) <=5){
                        String a = snum.substring(1).toString();
                        int possibleOne = translateNum(Integer.parseInt(a));
                        String b = snum.substring(2);
                        if (b.length() != 0){
                            int possibleTwo = translateNum(Integer.parseInt(b));
                            possible = possibleOne + possibleTwo;
                        }
                        else{
                            possible = possibleOne + 1;
                        }
                    }
                    else{
                        String charSequence = snum.substring(1).toString();
                        possible = possible * translateNum(Integer.parseInt(charSequence));
                    }
                }
            }
        } else {
            possible = possible;
        }
        return possible;
    }


    public static void main(String[] args) {
        SolutionTwo solution = new SolutionTwo();

        System.out.println(solution.translateNum(12258));
    }
}
