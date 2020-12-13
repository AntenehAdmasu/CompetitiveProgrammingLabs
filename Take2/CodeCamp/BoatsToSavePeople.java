import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int extraPos = 0;
        int travelled = 0;
        int travels = 0;
        int i = n - 1;
        while(travelled < n){
            travelled++;
            int extra = limit - people[i];
            if(people[extraPos] <= extra){
                extraPos++;
                travelled++;
            }
            travels++;
            i--;
        }
        return travels;
    }
}
