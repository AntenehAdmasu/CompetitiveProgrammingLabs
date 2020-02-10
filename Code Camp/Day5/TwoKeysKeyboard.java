// Question link : https://leetcode.com/problems/2-keys-keyboard/

public class TwoKeysKeyboard {

    public static void main(String[] args) {
//        new TwoKeysKeyboard().minSteps(9);
//        new TwoKeysKeyboard().minSteps(2);
        new TwoKeysKeyboard().minSteps(20);
    }

    public int minSteps(int n) {
        int count = 0;
        int characters = 0;
        int letters = 1;

        while(letters < n){
            if(n % (letters) == 0){
                characters = letters;
                count++;     // After copying
            }
            letters += characters;
            count++;     // After pasting

        }
        System.out.println("==>>>>>> " + count );
        return count;

    }
}
