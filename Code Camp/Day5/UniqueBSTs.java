// Question link : https://leetcode.com/problems/unique-binary-search-trees/

import com.sun.javafx.css.CalculatedValue;

import java.util.HashMap;

public class UniqueBSTs {
    public static void main(String[] args) {
        System.out.println(new UniqueBSTs().numTrees(2));
        System.out.println(new UniqueBSTs().numTrees(3));
        System.out.println(new UniqueBSTs().numTrees(4));
        System.out.println(new UniqueBSTs().numTrees(5));

    }

    public int numTrees(int n) {
        int[] mem = new int[n+1];
        mem[0] = 1;
        mem[1] = 1;

        return numberOfTrees(n, mem);
    }

    public int numberOfTrees(int n, int[] mem){

        if(mem[n] != 0){
            return mem[n];
        }
        int allTrees = 0;
        int i = 0;
        int j = n-1;
        while (i < n && j >= 0){
            int left = numberOfTrees(i,mem);
            int right = numberOfTrees(j,mem);

            allTrees += (left * right);
            i++;
            j--;
        }

        mem[n] = allTrees;

        return allTrees;
    }
}
