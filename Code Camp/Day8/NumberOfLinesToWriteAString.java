// Question link : https://leetcode.com/contest/weekly-contest-77/problems/number-of-lines-to-write-string

public class NumberOfLinesToWriteAString {

    public static void main(String[] args) {
       int[] widths = new int[]{7,5,4,7,10,7,9,4,8,9,6,5,4,2,3,10,9,9,3,7,5,2,9,4,8,9};
       String s = "zlrovckbgjqofmdzqetflraziyvkvcxzahzuuveypqxmjbwrjvmpdxjuhqyktuwjvmbeswxuznumazgxvitdrzxmqzhaaudztgie";
        System.out.println(new NumberOfLinesToWriteAString().numberOfLines(widths, s)[1]);
    }


    public int[] numberOfLines(int[] widths, String S) {
        int sptr = 0;
        int lineCount = 0;
        int lineCapacity = 0;

        while (lineCapacity <= 100) {

            int width = widths[(int) S.charAt(sptr) - 97];
            if (lineCapacity + width <= 100) {
                lineCapacity += width;
                sptr++;
            } else {
                lineCapacity = 0;
                lineCount++;
            }

            if (sptr == S.length() - 1) break;

        }
        int[] ans = new int[]{lineCount, lineCapacity};
        return ans;

    }
}
