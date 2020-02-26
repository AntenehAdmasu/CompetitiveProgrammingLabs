// Question link : https://leetcode.com/problems/shortest-common-supersequence/

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        new ShortestCommonSupersequence().shortestCommonSupersequence("abac", "cab");
    }
    
    public String shortestCommonSupersequence(String str1, String str2) {

        int[][] lettersMatrix = getLettersMatrix(str1,str2);

        int str1MatrixIndex = str1.length();
        int str2MatrixIndex = str2.length();

        StringBuilder result = new StringBuilder();

        // This loop tracks back characters from the bottom right corner of the letter matrix
        //  to find the result string
        while (str1MatrixIndex > 0 && str2MatrixIndex > 0){
            int str1Index = str1MatrixIndex - 1;
            int str2Index = str2MatrixIndex - 1;

            if(str1.charAt(str1Index) == str2.charAt(str2Index)){
                result.insert(0,str1.charAt(str1Index));
                str1MatrixIndex--;
                str2MatrixIndex--;
            }else{
                if(lettersMatrix[str1MatrixIndex][str2MatrixIndex-1] < lettersMatrix[str1MatrixIndex-1][str2MatrixIndex]){
                    result.insert(0,str2.charAt(str2Index));
                    str2MatrixIndex--;
                }else{
                    result.insert(0,str1.charAt(str1Index));
                    str1MatrixIndex--;
                }
            }
        }

        StringBuilder remaining = new StringBuilder();
        if(str2MatrixIndex > 0){
            remaining.append(str2.substring(0,str2MatrixIndex));
        }
        if (str1MatrixIndex > 0){
            remaining.append(str1.substring(0,str1MatrixIndex));
        }

        result.insert(0,remaining);
        
        return result.toString();

    }

    // Constructs a matrix that represents each character's relation with characters of the other string
    private int[][] getLettersMatrix(String str1, String str2) {

        int[][] lettersMatrix = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            lettersMatrix[i][0] = i;
        }

        for (int j = 0; j <= str2.length(); j++) {
            lettersMatrix[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lettersMatrix[i][j] = lettersMatrix[i - 1][j - 1] + 1;
                } else {
                    lettersMatrix[i][j] = Math.min(lettersMatrix[i - 1][j], lettersMatrix[i][j - 1]) + 1;
                }
            }
        }
        
        return lettersMatrix;
    }

}
