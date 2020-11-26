import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstructKPalindromeStrings {
    public static void main(String[] args) {
        System.out.println(new ConstructKPalindromeStrings().canConstruct("aaa", 2));
    }
    public boolean canConstruct(String s, int k) {
        if(s.length() == k) return true;
        int[] occ = new int[26];
        boolean middleIndex = false;
        boolean New = true;
        int palCount = 1;
        int largestPal = 0;
        for (char c : s.toCharArray()) {
            occ[c - 'a']++;
        }
         System.out.println(Arrays.toString(occ));
        // Hold starting position
        int sum = getSum(occ);
        while (sum > 0) {
            for (int index = 0; index < 26; index++) {
                int i = occ[index];
                if (i == 0) {
                    continue;
                }
                 System.out.print("for " + index);
                if (i == 1) {
                    if (palCount >= k) {
                        // System.out.println("returnning false " + middleIndex + " k is " + k);
                        return false;
                    }
                    if(!middleIndex){
                        palCount++;
                        middleIndex = false;
                    }
                    occ[index]--;
                } else {
                    // middleIndex += largestPal % 2 == 0 ? 0 : 1;
                    if(i % 2 == 0){
                        largestPal += i;
                        occ[index] = 0;
                    }else{
                        largestPal += i - 1;
                        occ[index] = 1;
                    }
                }
            }
            sum = getSum(occ);
            System.out.println(palCount);
            // System.out.println(Arrays.toString(occ) + " sum => " + sum);
        }
        palCount += largestPal % 2 == 0 ? largestPal - 2 : largestPal - 1;
        // System.out.println("palCount " + palCount + " lP " + largestPal);
        return palCount >= k;
    }


    public int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
