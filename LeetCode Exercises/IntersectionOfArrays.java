import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOfArrays {
    public static HashMap<Integer, Integer> numbers = new HashMap<>();

//    public static void main(String[] args) {
//        int[] A = new int[] {1,2,2,2,2,4,3,4,5,7};
//        int[] B= new int[] {2,5,4,8,9,0,7};
//        int[] ans = intersection(A, B);
//        System.out.println("&&&&&&&&&&&&&&&&&&&");
//        for (int i = 0; i < ans.length; i++) {
//            System.out.println(ans[i]);
//        }
//    }
    public static int[] intersection(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    if(numbers.get(nums1[i]) == null){
                        numbers.put(nums1[i],1);
                    }
                }
            }
        }
        System.out.println(numbers.size() + " *****");

        int[] ans = new int[numbers.size()];
        int counter = 0;
        for (Integer x : numbers.keySet()){
            ans[counter] = x;
            counter++;
        }
        return ans;
    }

}
