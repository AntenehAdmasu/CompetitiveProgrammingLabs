import java.util.HashMap;
import java.util.HashSet;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i <= 9; i++){
            frequencyMap.put(i, 0);
        }
        int cows = 0;
        int bulls = 0;
        for(int i = 0; i < guess.length(); i++){
            int secretD = Character.getNumericValue(secret.charAt(i));
            int guessD = Character.getNumericValue(guess.charAt(i));
            if(secretD == guessD){
                bulls++;
            }else{
                if(frequencyMap.get(secretD) < 0){
                    cows++;
                }
                if(frequencyMap.get(guessD) > 0){
                    cows++;
                }
                frequencyMap.put(secretD, frequencyMap.get(secretD) + 1);
                frequencyMap.put(guessD,frequencyMap.get(guessD) - 1);
            }
        }

        String answer = "" + bulls + "A" + cows + "B";
        return answer;
    }
}
