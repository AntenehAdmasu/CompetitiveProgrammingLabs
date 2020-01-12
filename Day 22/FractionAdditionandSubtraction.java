// Question link : https://leetcode.com/problems/fraction-addition-and-subtraction/

import java.util.ArrayList;

public class FractionAdditionandSubtraction {
    public static void main(String[] args) {
        String n = fractionAddition("1/10+1/10+1/10+1/10+1/10+1/10+1/10+1/10+1/10+1/10+1/10+1/10+1/10");

        System.out.println("answer is " + n);
    }

    public static String fractionAddition(String expression) {
        ArrayList<Integer> numerators = new ArrayList<>();
        ArrayList<Integer> denominators = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();

        int typeflag = 0;
        boolean firstNumNegative = false;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '+' || c == '-'){
                operators.add(c);
                if(i == 0) firstNumNegative = true;
            }else if (c != '/'){
                if(typeflag == 0){
                    if(c == '1' && i != expression.length() - 1 && expression.charAt(i+1) == '0'){
                        numerators.add(10);
                        i++;
                    }else{
                        numerators.add(Integer.parseInt(Character.toString(c)));
                    }
                    typeflag = 1;
                }else{
                    if(c == '1' && i != expression.length() - 1 && expression.charAt(i+1) == '0'){
                        denominators.add(10);
                        i++;
                    }else{
                        denominators.add(Integer.parseInt(Character.toString(c)));
                    }
                    typeflag = 0;
                }
            }
        }
        return calculateExpression(numerators, denominators, operators, firstNumNegative);
    }

    public static String calculateExpression(ArrayList<Integer> numerators, ArrayList<Integer> denominators, ArrayList<Character> operators, boolean firstNumNegative) {

        long denominatorsProduct = 1;
        long numeratorsSum = 0;

        for (int d: denominators) denominatorsProduct *= d;

        int opCounter = 0;
        for (int i = 0; i < numerators.size() ; i++) {
            long temp = (denominatorsProduct / denominators.get(i)) * numerators.get(i);
            if(i == 0 ){
                temp *= (firstNumNegative) ? -1 : 1;
                numeratorsSum += temp;
                opCounter += (firstNumNegative)? 1 : 0;
                continue;
            }
            numeratorsSum += (operators.get(opCounter) == '-') ? (-1 * temp) : temp;
            opCounter++;
        }


        long gcdNumDenum = getGCD(Math.abs(Math.max(numeratorsSum,denominatorsProduct)), Math.abs(Math.min(numeratorsSum,denominatorsProduct)));
        long simplifiedNum = numeratorsSum / gcdNumDenum;
        long simplifiedDen = denominatorsProduct / gcdNumDenum;

        String answer = "" + simplifiedNum + "/" + simplifiedDen;
        return answer;

    }

    public static long getGCD(long a, long b){
        return (b == 0) ? a :getGCD(b,a % b);
    }

}
