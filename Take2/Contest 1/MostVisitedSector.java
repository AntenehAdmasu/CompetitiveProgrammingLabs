import java.util.ArrayList;
import java.util.List;

public class MostVisitedSector {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] sectors = new int[n];
        int maxVisited = 0;
        for(int i = 1; i < rounds.length; i++){
            if(rounds[i-1] < rounds[i]){
                int start = i == 1 ? rounds[i - 1] : rounds[i - 1] + 1;
                for(int j = start; j <= rounds[i]; j++){
                    sectors[j-1]++;
                    maxVisited = Math.max(maxVisited, sectors[j-1]);
                }
            }else{
                int start = i == 1 ? rounds[i - 1] : rounds[i - 1] + 1;
                for(int j = start; j <= n; j++){
                    sectors[j-1]++;
                    maxVisited = Math.max(maxVisited, sectors[j-1]);
                }
                for(int k = 0; k < rounds[i]; k++){
                    sectors[k]++;
                    maxVisited = Math.max(maxVisited, sectors[k]);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int index = 0; index < n; index++){
            if(sectors[index] == maxVisited){
                answer.add(index+1);
            }
        }
        return answer;
    }
    public List<Integer> mostVisitedII(int n, int[] rounds) {
        int start = rounds[0];
        int end = rounds[rounds.length - 1];

        List<Integer> res = new ArrayList<>();
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                res.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                res.add(i);
            }
            for (int i = start; i <= n; i++) {
                res.add(i);
            }
        }

        return res;
    }
}
