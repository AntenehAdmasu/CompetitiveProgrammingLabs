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
}
