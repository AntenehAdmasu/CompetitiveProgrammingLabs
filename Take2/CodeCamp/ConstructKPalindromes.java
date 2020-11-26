public class ConstructKPalindromes {
    public boolean canConstruct(String s, int k) {
        int[] occ = new int[26];
        for (char c : s.toCharArray()) {
            occ[c - 'a']++;
        }
        int oddCount = 0;
        int totalEvens = 0;
        for(int i: occ){
            if(i % 2 == 0){
                totalEvens += i;
            }else{
                oddCount += 1;
                totalEvens += i - 1;
            }
        }
        if(oddCount > k){
            return false;
        }
        int palindromeCount = oddCount + totalEvens ;

        return palindromeCount >= k;
    }

    public int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
