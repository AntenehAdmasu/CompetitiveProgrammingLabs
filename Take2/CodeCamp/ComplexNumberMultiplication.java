public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] first = a.split("\\+");
        String[] second = b.split("\\+");

        int n = first[1].length();
        int m = second[1].length();

        int A = Integer.parseInt(first[0]);
        int B = Integer.parseInt(first[1].substring(0, n-1));

        int C = Integer.parseInt(second[0]);
        int D = Integer.parseInt(second[1].substring(0, m-1));

        int realPart = A*C + (B*D*-1);
        String realpart = ""+realPart;

        int imaginaryPart = (B*C) + (A*D);
        String imaginarypart = "" + imaginaryPart + "i";

        return realpart + "+" + imaginarypart;
    }
}
