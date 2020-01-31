// Question : https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

import java.util.ArrayList;

public class MinimumCostTree {

    public static void main(String[] args) {
        int[] test = new int[]{6,15,5,2 };
        System.out.println(new MinimumCostTree().mctFromLeafValues(test));
    }

    public int mctFromLeafValues(int[] arr) {

        ArrayList<Integer> array = new ArrayList<>();
        for (int x: arr) array.add(x);
        int total = 0;

        while (array.size() > 1) {
            int[] res = getMinAndSmallestNeighbour(array);
            int minElementIndex = res[0];
            int minNeighbourIndex = res[1];
            int product = array.get(minElementIndex) * array.get(minNeighbourIndex);
            total += product;
            System.out.println("total is " + total);
            array.remove(minElementIndex);
        }
        return total;

    }

    public int[] getMinAndSmallestNeighbour(ArrayList<Integer> arr) {
        for (int x: arr) System.out.println("ds " + x);
        int minimum = Integer.MAX_VALUE;
        int minIndex = 0;
        int minNeighIndex;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != -1 && arr.get(i)< minimum) {
                minIndex = i;
                minimum = arr.get(i);
            }
        }
        if(minIndex - 1 < 0){
            minNeighIndex = minIndex + 1;
        }else if(minIndex+1 >= arr.size()){
            minNeighIndex = minIndex-1;
        }else{
            minNeighIndex = arr.get(minIndex - 1) <= arr.get(minIndex+1) ? minIndex -1 : minIndex + 1;
        }

        return new int[]{minIndex, minNeighIndex};
    }
}
