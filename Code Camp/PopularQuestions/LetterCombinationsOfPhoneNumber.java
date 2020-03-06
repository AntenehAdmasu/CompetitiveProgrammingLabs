// Question link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        HashMap<String, ArrayList<String>> numberLetterMap = new HashMap<>();
        List<String> answer = new ArrayList<>();
        if(digits.length() == 0) return answer;
        int charCode = (97);
        for (int i = 0; i <= 7; i++) {
            int range = (i == 5 || i == 7) ? 4 : 3;
            ArrayList<String> letters = new ArrayList<>();
            int counter = 0;
            String letter = "";

            while (counter < range) {
                letter = Character.toString((char) charCode++);
                letters.add(letter);
                counter++;
            }
            numberLetterMap.put("" + (i + 2), letters);
        }

        answer.add("");
        for (int i = 0; i < digits.length() ; i++) {
            answer = generateCombination(Character.toString(digits.charAt(i)), answer,numberLetterMap);
        }
        return answer;
    }

    public List<String> generateCombination(String number, List<String> currentCombination, HashMap<String, ArrayList<String>> numberLetterMap){
        List<String> newCombination = new ArrayList<>();

        for (String comb: currentCombination) {
            for (String letter: numberLetterMap.get(number)) {
                String newcomb = comb + letter;
                newCombination.add(newcomb);
            }
        }
        return newCombination;
    }
}
