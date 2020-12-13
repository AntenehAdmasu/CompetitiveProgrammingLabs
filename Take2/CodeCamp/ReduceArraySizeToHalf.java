import java.util.Arrays;
import java.util.HashMap;

public class ReduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        int[] freq = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int prev = arr[0];
        freq[0] = 1;
        for(int i = 1; i < n; i++){
            if(arr[i] == prev){
                freq[index]++;
            }else{
                prev = arr[i];
                freq[++index]++;
            }
        }
        Arrays.sort(freq);
        int toDelete = 0;

        int ctr = 0;
        while(toDelete < n/2){
            toDelete += freq[n-1-ctr];
            ctr++;
        }
        return ctr;
    }
}
