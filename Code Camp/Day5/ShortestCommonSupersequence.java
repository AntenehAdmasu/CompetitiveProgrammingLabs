// Question link : https://leetcode.com/problems/shortest-common-supersequence/

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        new ShortestCommonSupersequence().shortestCommonSupersequence("abac", "cab");
    }
    public String shortestCommonSupersequence(String str1, String str2) {

        int[][] arr = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            arr[i][0] = i;
        }

        for (int j = 0; j <= str2.length(); j++) {
            arr[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;

                } else {
                    arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + 1;
                }
            }
        }

        int currentI = str1.length();
        int currentJ = str2.length();

        String result = "";

        while (currentI > 0 && currentJ > 0){
            int currenti = currentI - 1;
            int currentj = currentJ - 1;

            if(str1.charAt(currenti) == str2.charAt(currentj)){
                result = str1.charAt(currenti) + result;
                currentI--;
                currentJ--;
            }else{
                if(arr[currentI][currentJ-1] < arr[currentI-1][currentJ]){
                    result = str2.charAt(currentj) + result;
                    currentJ--;
                }else{
                    result = str1.charAt(currenti) + result;
                    currentI--;
                }
            }
        }
        String remaining = "";
        if(currentJ > 0){
            remaining = str2.substring(0,currentJ);
        }
        if (currentI > 0){
            remaining = str1.substring(0,currentI);

        }

        result = remaining + result;

        return result;

    }

}
