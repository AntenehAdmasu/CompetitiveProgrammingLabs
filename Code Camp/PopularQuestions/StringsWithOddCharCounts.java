// Question link : https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/

public class StringsWithOddCharCounts {
    public static void main(String[] args) {
        System.out.println(new StringsWithOddCharCounts().generateTheString(4));
        System.out.println(new StringsWithOddCharCounts().generateTheString(5));
        System.out.println(Integer.MAX_VALUE);

    }

    public String generateTheString(int n) {

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append('a');
        }
        if(n % 2 == 0 ){
            answer.setCharAt(n-1,'b');
        }
        return answer.toString();
    }
}
