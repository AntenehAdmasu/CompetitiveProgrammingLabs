// Question : https://leetcode.com/problems/reorganize-string/


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ReorganizeString {

    public String reorganizeString(String S) {
        int length = S.length();
        ArrayList<Integer> characters = new ArrayList<>();
        int maxPossibleOccurrence = (length % 2 == 0) ? length / 2 : (length / 2) + 1;  //Allowable occurrence for a single character

        //  FILLING THE ARRAY WITH ZEROS
        for (int i = 0; i < 26; i++) {
            characters.add(0);
        }

        for (int i = 0; i < S.length(); i++) {
            int c = (int)(S.charAt(i)) - 97;
            characters.set(c,characters.get((int)S.charAt(i) - 97) + 1);
        }

        if(Collections.max(characters) > maxPossibleOccurrence) return "";

        StringBuilder answer = new StringBuilder(S);
        int tempvalue = 0;
        int tempindex = 0;
        int i = 0;

        boolean firstIteration = true;

        while (Collections.max(characters) > 0){

            int maxIndex = Collections.max(characters);
            int x = characters.indexOf(maxIndex); //index
            char a  = (char)(x + 97);

            if(!firstIteration) characters.set(tempindex, tempvalue);

            answer.setCharAt(i,a);
            tempvalue = maxIndex - 1;
            tempindex = x;

            characters.set(x,-1);

            if(firstIteration) firstIteration = false;
            i++;
        }

        return answer.toString();


    }


}
