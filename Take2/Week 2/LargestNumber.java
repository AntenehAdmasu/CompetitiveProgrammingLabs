import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        new LargestNumber().largestNumber(new int[]{121,12,1});
    }


    public String largestNumber(int[] nums) {
        Integer[] numbers = new Integer[nums.length];
        int index = 0;
        String answer = "";

        for (int a : nums) {
            numbers[index++] = new Integer(a);
        }
        Arrays.sort(numbers, new NumbersComparator());
        boolean nonZeroStart = false;
        for (int a: numbers) {
            if(a == 0 && !nonZeroStart){
                continue;
            }
            nonZeroStart = true;
            answer += a;
        }

        return answer == "" ? "0" : answer;
    }

}



class NumbersComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer n1, Integer n2) {
        int len1 = ("" + n1).length();
        int len2 = ("" + n2).length();
        if(n1.equals(n2) || len1 == len2){
            return n2 - n1;
        }

        int index = 0;
        while ((index < len1) && (index < len2)){
            int digitOne =  Character.getNumericValue((""+n1).toCharArray()[index]);
            int digitTwo =  Character.getNumericValue((""+n2).toCharArray()[index]);

            if(digitOne != digitTwo){
                return digitTwo - digitOne;
            }
            index++;
        }

        int n1First = Integer.parseInt("" + n1 + n2);
        int n2First = Integer.parseInt("" + n2 + n1);

        return n2First - n1First;
    }

}