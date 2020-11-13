package leetcode;



public class Solution37 {
    public String changeFormatNumber(String number) {
        // write code here
        if (number == null || number.isEmpty()){
            return "INPUTERROR";
        }
        for (int i = 0; i < number.length(); i++) {
            if (i > 0){
                if ((number.charAt(i) > '9') || (number.charAt(i)  < '0')) {
                    return "INPUTERROR";
                }
            }
            else {
                if (!number.startsWith("-")){
                    if ((number.charAt(i) > '9') || (number.charAt(i)  < '0')){
                        return "INPUTERROR";
                    }
                }
            }

        }
        int numb = Integer.valueOf(number);
        if (numb < -32768 || numb > 32767){
            return "NODATA";
        }
        String hex = "";
        String binary = "";
        if (numb >= 0){
            StringBuilder binaries = new StringBuilder(Integer.toBinaryString(numb));
            int len = binaries.length();
            for(int i=0;i<16-len;i++)
            {

                binaries.insert(0, '0');

            }
            binary  = binaries.toString();
            hex = Integer.toHexString(numb);
            while (hex.length() < 4){
                hex = "0" + hex;
            }
        }
        else{
            String s = Integer.toBinaryString(numb);
            binary = s.substring(16,s.length());
            hex = Integer.toHexString(numb);
        }



        return binary + "," + hex;
    }

    public static void main(String[] args) {
        Solution37 solution = new Solution37();
        String s = solution.changeFormatNumber("41");
        System.out.println(s);
        System.out.println(solution.myBinary(41));
    }



    public String myBinary(int i){
        StringBuffer buffer =  new StringBuffer();
        while (i / 2 != 0){
            buffer.append(i%2);
            i = i/2;
        }
        buffer.append(i);
        buffer.reverse();
        String re  = buffer.toString();
        while (re.length() < 16)
        {
            re = "0" + re;
        }
        return re;
    }


    public static String minusDecimalismToBinary(int num){
        StringBuffer sb = new StringBuffer();
        int temp = -num;
        int counter = 0;
        while(temp!=0){
            counter++;
            sb.append(temp%2);
            if((counter+1)%2==0){
                temp += temp/2*-1;
            }else{
                temp = temp/2;
            }
        };
        return sb.toString();
    }
}
