import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Counting {
    public ArrayList<Integer> sort(ArrayList<Integer> numbers){ 
        
        HashMap<Integer, Integer> occurence = new HashMap<>();
        ArrayList<Integer> sorted = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (!(occurence.containsKey(number))){
                occurence.put(number, 1);
            }else{
                occurence.put(number, occurence.get(number) + 1);
            }
        }

        for (int x: occurence.keySet()) {
            while (occurence.get(x) != 0){
                sorted.add(x);
                occurence.put(x, occurence.get(x) - 1);
            }
        }
        return sorted;
    }
}
