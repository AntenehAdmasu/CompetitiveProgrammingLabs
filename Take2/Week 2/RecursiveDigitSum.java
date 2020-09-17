public class RecursiveDigitSum {
    public static void main(String[] args) {
        System.out.println(superDigit("9875", 4));
    }
    static int superDigit(String n, int k) {
        StringBuilder concatenated = new StringBuilder("");
        for (int i = 0; i < k; i++) {
            concatenated.append(n);
        }
        String first = "" + getSumRecursively(n);
        for (int i = 0; i < k; i++) {
            concatenated.append(first);
        }
        return getSumRecursively(concatenated.toString());
    }
    static int getSumRecursively(String num){
        if( num.length() == 1){
            return Integer.parseInt(num);
        }
        int sum = 0;
        String digit = num;
        while (digit.length() > 1){
            int intVal = Character.getNumericValue(digit.charAt(digit.length()-1));
            sum += intVal;
            digit = digit.substring(0, digit.length()-1);
        }
        sum += Character.getNumericValue(digit.charAt(0));
        return getSumRecursively(""+sum);
    }

}
