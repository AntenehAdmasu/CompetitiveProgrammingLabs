// Question : https://leetcode.com/problems/reverse-integer/

public class ReverseInteger {

    public int reverse(int x){
        try{
            String numString = x + "";
            String sign = (numString.charAt(0) == '-')? "-":"";
            int numLength = (numString.charAt(0) == '-')? numString.length() - 1 : numString.length() ;
            String signRemoved = (numString.charAt(0) == '-')? numString.substring(1): numString;
            String answerString = "";

            for (int i = numLength - 1; i >= 0; i--) {
                answerString += Character.toString(signRemoved.charAt(i));
            }
            int reversed = Integer.parseInt(answerString);

                if(sign == "-"){
                    return reversed * -1;
                }
                return reversed;
        }catch(NumberFormatException e){
            return 0;
        }
    }
}
