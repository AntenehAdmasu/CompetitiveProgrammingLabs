// Question : http://codeforces.com/contest/1272/problem/B

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SnowWalkingRobot {

    public static void main(String[] args) {
        ArrayList<String> userinputs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < numberOfInputs; i++) {
            String uinput = scanner.nextLine();
            userinputs.add(uinput);
        }

        for (int k = 0; k < userinputs.size(); k++) {
            getPath(userinputs.get(k));
        }

    }

    public static void getPath(String path){
        int Ucount = 0 ;
        int Dcount = 0 ;
        int Lcount = 0 ;
        int Rcount = 0 ;
        StringBuilder output = new StringBuilder(path);
        int counter = 0;

        for (int i = 0; i < path.length(); i++) {

            Character c = path.charAt(i);
            if(c.equals('U')){
                Ucount++;
            }else if(c.equals('D')){
                Dcount++;
            }else if(c.equals('R')){
                Rcount++;
            }else if(c.equals('L')){
                Lcount++;
            }
        }

        int minHorizontal = Math.min(Lcount, Rcount);
        int minVertical = Math.min(Ucount, Dcount);

        if(minHorizontal == 0 && minVertical != 0) minVertical = 1;
        if(minHorizontal != 0 && minVertical == 0) minHorizontal = 1;

        int total = (2 * minHorizontal ) + (2 * minVertical);

        for (int i = 0; i < minHorizontal; i++) {
            output.setCharAt(counter, 'R');
            counter++;
        }
        for (int i = 0; i < minVertical; i++) {
            output.setCharAt(counter, 'U');
            counter++;

        }
        for (int i = 0; i < minHorizontal; i++) {
            output.setCharAt(counter, 'L');
            counter++;
        }
        for (int i = 0; i < minVertical; i++) {
            output.setCharAt(counter, 'D');
            counter++;
        }

        System.out.println(output.substring(0,counter));

    }
}
