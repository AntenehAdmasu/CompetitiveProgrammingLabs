import java.util.ArrayList;
import java.util.Collections;

public class Selection {

    public ArrayList<Integer> sort(ArrayList<Integer> nums){
        for (int i = 0; i < nums.size() ; i++) {

            for (int j = i; j < nums.size(); j++) {
                if(nums.get(j) < nums.get(i)){
                    Collections.swap(nums, i, j);
                }
            }
        }
        return nums;
    }
}
