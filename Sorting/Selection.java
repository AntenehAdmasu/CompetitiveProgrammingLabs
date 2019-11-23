import java.util.ArrayList;

public class Selection {

    public ArrayList<Integer> sort(ArrayList<Integer> nums){
        for (int i = 0; i < nums.size() ; i++) {

            for (int j = i; j < nums.size(); j++) {
                if(nums.get(j) < nums.get(i)){
                    int temp = nums.get(i);
                    int J = nums.get(j);
                    nums.remove(i);
                    nums.add(i, J);
                    nums.remove(j);
                    nums.add(j,temp);
                }
            }
        }
        return nums;
    }
}
