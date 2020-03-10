// Question link : https://leetcode.com/problems/plus-one/

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res = new int[len + 1];
        int carry = 1;
        for(int i = len - 1; i >= 0; i--){
            if(digits[i] + carry <= 9){
                res[i+1] = digits[i] + carry;
                carry = 0;
            }else{
                res[i+1] = 0;
                carry = 1;
            }
        }
        res[0] = carry;
        return carry == 0 ? Arrays.copyOfRange(res, 1, res.length): res;
    }

}
