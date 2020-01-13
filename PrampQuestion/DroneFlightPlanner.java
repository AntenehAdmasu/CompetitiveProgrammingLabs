import java.util.Arrays;

public class MergeMultidimensional {


    public static void main(String[] args) {
        int[][] test = new int[][]{
                  {0,   2, 10},
                  {3,   5,  0},
                  {9,  20,  6},
                  {10, 12, 15},
                  {10, 10,  8}
        };

       int cost = calcDroneMinEnergy(test);
       System.out.println(cost);
    }

    public static int calcDroneMinEnergy(int[][] route) {
        // your code goes here
        if(route.length == 1) return 0;
        int start = route[0][2];
        int[][] sortedPos = sort(Arrays.copyOfRange(route, 1,route.length));

        int cost = start - sortedPos[sortedPos.length-1][2];
        return (cost < 0) ? Math.abs(cost) : 0;
    }
    

    public static int[][] sort(int[][] nums) {

        int length = nums.length;
        int[][] left = new int[length / 2][3];
        int[][] right = new int[length - length / 2][3];

        if (length == 1) {
            return nums;
        } else {
            left = sort(Arrays.copyOfRange(nums, 0, length / 2));
            right = sort(Arrays.copyOfRange(nums, length / 2, length));
        }
        return merge(left, right);
    }


    public static int[][] merge(int[][] left, int[][] right) {

        int l = 0;
        int r = 0;
        int[][] mergedList = new int[left.length + right.length][3];
        int inserted = 0;

        while ((l < left.length) && (r < right.length)) {
            if (left[l][2] < right[r][2]) {
                mergedList[inserted] = left[l];
                l++;
            } else {
                mergedList[inserted] = right[r];
                r++;
            }
            inserted++;
        }

        // Filling the remaining slots
        if (l == left.length) {
            for (int i = r; i < right.length; i++) {
                mergedList[inserted] = right[i];
                inserted++;
            }
        } else {
            for (int i = l; i < left.length; i++) {
                mergedList[inserted] = left[i];
                inserted++;
            }
        }

        return mergedList;
    }

}
