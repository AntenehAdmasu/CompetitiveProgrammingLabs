public class KthSymbolInGrammar {

    public int kthGrammar(int N, int K) {
        return findInverse(N, K);
    }

    public int findInverse(int n, int k){
        if(n == 1){
            return 0;
        }
        int len = (int) Math.pow(2, n - 1);
        int mirror = len / 2;
        if(k <= mirror){
            return findInverse(n-1, k);
        }else{
            int bit = findInverse(n-1, k - mirror);
            return bit == 0 ? 1 : 0;
        }
    }
}
