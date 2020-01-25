// Question : https://leetcode.com/problems/delete-columns-to-make-sorted/

import java.util.ArrayList;

public class DeleteColumns {
    public static void main(String[] args) {
        String[] A = new String[]{"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(A));
    }
    public static int minDeletionSize(String[] A) {
        ArrayList<Integer> deleted = new ArrayList<>();
        for (int i = 0; i < A[0].length(); i++) {
            int current = 0;
            int prev = 0;
            for (String word: A) {
                current = word.charAt(i);
                if(prev > current){
                    deleted.add(i);
                    break;
                }
                prev = current;
            }

        }
        return deleted.size();
    }
}
