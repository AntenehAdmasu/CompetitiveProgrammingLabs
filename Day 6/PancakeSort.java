import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSort {
    public static void main(String[] args) {
        int[] B = new int[]{2,10,5,6,3,8,9};
        int[] D = new int[]{2,4,20,3,5,6,8,9,15};

        List<Integer> ans = pancakeSort(D);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("*"+ans.get(i));
        }
    }
    public static List<Integer> pancakeSort(int[] A) {

        List<Integer> flips = new ArrayList<>();
        int[] sortedList = Arrays.copyOfRange(A,0,A.length);
        int length = A.length;
        Arrays.sort(sortedList);

        for (int i = 0; i < A.length ; i++) {
            int val = sortedList[length-(i+1)];

            if(A[length-(i+1)] == val) continue;
            int index = 0;
            for (int j = 0; j < A.length ; j++) {

                if(A[j] == val){
                    if(index == 0){
                        flips.add(length - (i));
                        reverse(A, length-(i));
                        break;
                    }else{
                        flips.add(index+1);
                        flips.add(length - (i));
                        reverse(A,index+1);
                        reverse(A, length-(i));
                        break;
                    }
                }
                index++;
            }
        }

        return flips;
    }

    public static void reverse(int[] A,int k){
        int lastIndex = k - 1;
        for (int i = 0; i < k/2; i++) {
            int temp1 = A[i];
            int temp2 = A[lastIndex-i];
            A[i] = temp2;
            A[lastIndex-i] = temp1;
        }
    }
}
