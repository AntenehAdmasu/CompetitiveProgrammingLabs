import java.util.ArrayList;

public class RecentCounter {

    ArrayList<Integer> calls;
    public RecentCounter() {
        calls = new ArrayList<>();
    }

    public int ping(int t) {
        calls.add(t);
        int counter = 0;
        for (int i = calls.size()-1; i > 0 ; i--) {
            int timeRange = calls.get(i) - calls.get(-1);
            if(timeRange >= 3000){
                counter++;
            }else{
                break;
            }
        }
        return counter;
    }
}
