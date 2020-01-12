// Question link : https://leetcode.com/problems/complex-number-multiplication/

public class ComplexNumberMultiplication {

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i" ,"1+-1i"));
        }

    public static String complexNumberMultiply(String a, String b) {

        String[] first = a.split("\\+");
        String[] second = b.split("\\+");
        int A = Integer.parseInt(first[0]);
        int B = Integer.parseInt(first[1].substring(0, first[1].length()-1));

        int C = Integer.parseInt(second[0]);
        int D = Integer.parseInt(second[1].substring(0, second[1].length()-1));

        int realPart = A*C + (B*D*-1);
        String realpart = ""+realPart;

        int imaginaryPart = (B*C) + (A*D);
        String imaginarypart = "" + imaginaryPart + "i";

        return realpart + "+" + imaginarypart;
    }
}
