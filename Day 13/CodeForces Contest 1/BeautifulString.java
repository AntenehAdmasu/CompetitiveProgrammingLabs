// Question : https://codeforces.com/contest/1265/problem/A

import java.util.ArrayList;
import java.util.Scanner;

public class BeautifulString {

    public static void main(String[] args) {

        ArrayList<String> userinputs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();

        for (int i = 0; i < numberOfInputs; i++) {
            String input = scanner.next();
            userinputs.add(input);

        }

        for (int k = 0; k < userinputs.size(); k++) {
            System.out.println(beautifulString(userinputs.get(k)));
        }

    }


    public static String beautifulString(String input){

        StringBuilder sample = new StringBuilder(input);

        String chars = "abc";

        for (int i = 0; i < sample.length(); i++) {

            char character = sample.charAt(i);
            if(i < sample.length() -1){
                if ((character != '?') && (character == sample.charAt(i+1))) {
                    return "-1";
                }else{
                    if(character !='?' ) {
                        sample.setCharAt(i,sample.charAt(i));

                    }else{
                        char before;
                        if (i == 0){
                            before = '1';
                        }else{
                            before = sample.charAt(i-1);
                        }

                        for (int j = 0; j < 3; j++) {

                            if ( (chars.charAt(j) != before) & (chars.charAt(j) != sample.charAt(i+1))){

                                sample.setCharAt(i, chars.charAt(j));
                                break;
                            }
                        }
                    }

                }
            }else{
                if(character == '?'){
                    char before;

                    if (i == 0){
                        before = '1';
                    }else{
                        before = sample.charAt(i-1);
                    }
                    for (int j = 0; j < 3; j++) {
                        if (chars.charAt(j) != before){

                            sample.setCharAt(i, chars.charAt(j));
                            break;
                        }
                    }
                }else{
                    sample.setCharAt(i, character);
                }
            }

        }

        return sample.toString();


    }

}
