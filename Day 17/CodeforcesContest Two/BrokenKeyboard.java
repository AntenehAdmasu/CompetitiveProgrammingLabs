import java.util.ArrayList;
import java.util.Scanner;

public class BrokenKeyboard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wordlen = scanner.nextInt();
        int sublen = scanner.nextInt();
        scanner.nextLine();

        String word = scanner.nextLine();
        String sub = scanner.nextLine();
        String[] subs = sub.split(" ");
        getSubstringsNumber(wordlen,sublen,word,subs);
    }
    public static void getSubstringsNumber(int wordlen, int charslen, String word, String[] subs){

        ArrayList<Long> others = new ArrayList<>();
        long total = 0;

        boolean found = false;
        for (int i = 0; i < wordlen; i++) {

            for (int j = 0; j < charslen; j++) {
                if(word.charAt(i) == (subs[j]).charAt(0)){
                    found = true;
                    break;
                }
            }
            if(!found){
                others.add((long)i);
            }
            found = false;
        }

        if(others.size() == 0){
            int max = (word.length() * (word.length() + 1)) / 2;
            return;
        }

        for (int i = 0; i < others.size(); i++) {
            long n;
            if(i == 0){
                n = others.get(0);
            }else{
                n = others.get(i) - others.get(i-1) - 1;
            }
            total += (n * (n+1)) / 2;
        }
        long last = word.length() - others.get(others.size() -1) - 1;
        long lastMult = (last * (last+1)) /2;

        total += lastMult;

        System.out.println(total);
    }
}
