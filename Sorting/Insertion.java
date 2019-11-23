import java.util.ArrayList;

public class Insertion {
    public ArrayList<Integer> sort(ArrayList<Integer> nums) {
        if(nums.size() == 0) return nums;
        for (int key = 1; key < nums.size(); key++) {

            int i = key;
            int j = i -1;

            while( j >= 0 && (nums.get(key) < nums.get(j))){
                int temp = nums.get(key);
                int J = nums.get(j);

                nums.remove(key);
                nums.add(key, J);
                nums.remove(j);
                nums.add(j,temp);

                key --;
                j --;
            }
        }
        return nums;
    }
}
