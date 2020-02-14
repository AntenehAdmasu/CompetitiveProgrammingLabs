// Question link : https://leetcode.com/contest/weekly-contest-88/problems/shifting-letters/

public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {

        StringBuilder word = new StringBuilder(S);
        int[] shiftArray = new int[shifts.length + 1];
        shiftArray[shiftArray.length-1] = 0;

        for (int i = shifts.length-1; i >= 0 ; i--) {
            shiftArray[i] = shiftArray[i+1] % 26 + shifts[i] % 26;
        }

        for (int i = 0; i < shiftArray.length-1; i++) {
            char prev = word.charAt(i);
            char newChar = (char) ((((prev - 97) + shiftArray[i]) % 26) + 97);
            word.setCharAt(i,newChar);
        }

        return word.toString();
    }

}
