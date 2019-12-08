import java.util.ArrayList;

public class Merge {

    public ArrayList<Integer> sort(ArrayList<Integer> nums){
        ArrayList<Integer> left;
        ArrayList<Integer> right;
        int length = nums.size();

        if(length == 1){
            return nums;
        }else{
            left = sort(new ArrayList<Integer>( nums.subList(0, (length/2))) );
            right = sort(new ArrayList<Integer>( nums.subList(length/2, length ) ));
            return merge(left, right);
        }
    }

    public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        int l = 0;
        int r = 0;
        ArrayList<Integer> mergedList = new ArrayList<>();
        while ((l < left.size()) && (r < right.size())) {
            if (left.get(l) < right.get(r)) {
                mergedList.add(left.get(l));
                l++;
            } else {
                mergedList.add(right.get(r));
                r++;
            }
        }
        if(l == left.size()){
            for (int i = r; i < right.size(); i++) {
                mergedList.add(right.get(i));
            }
        }else{
            for (int i = l; i < left.size(); i++) {
                mergedList.add(left.get(i));
            }
        }

        return mergedList;
    }




}
