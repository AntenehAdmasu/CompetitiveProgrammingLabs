public class MaximumNestingDepth {

    public int[] maxDepthAfterSplit(String seq) {
        int aCnt = 0;
        int bCnt = 0;
        int n = seq.length();
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            char c = seq.charAt(i);
            if( c == '('){
                if(aCnt < bCnt){
                     res[i] = 0;
                    aCnt++;
                }else{
                    bCnt++;
                    res[i] = 1;
                }
            }else{
                if(aCnt > bCnt){
                     res[i] = 0;
                    aCnt--;
                }else{
                    res[i] = 1;
                    bCnt--;
                }
            }
        }

        return res;
    }
}
