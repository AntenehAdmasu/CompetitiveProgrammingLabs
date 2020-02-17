// Question link : https://leetcode.com/contest/weekly-contest-176/problems/product-of-the-last-k-numbers

import java.util.ArrayList;
import java.util.HashSet;

public class ProductOfLastKNumbers {

    public static void main(String[] args) {
        ProductOfLastKNumbers p = new ProductOfLastKNumbers();
        p.add(3);
        p.add(0);
        p.add(2);
        p.add(5);
        p.add(4);
        p.add(8);
        System.out.println(p.getProduct(5));
    }

    ArrayList<Integer> productArray;
    HashSet<Integer> zeroesIndex;
    int lastZero;

    public ProductOfLastKNumbers() {
        productArray = new ArrayList<>();
        zeroesIndex = new HashSet<>();
        lastZero = Integer.MIN_VALUE;
    }

    public void add(int num) {
        if (productArray.size() == 0 || num == 0) {
            productArray.add(num);
            if (num == 0) {
                zeroesIndex.add(productArray.size() - 1);
                lastZero = productArray.size() - 1;
            }
        } else {
            int newProduct = productArray.get(productArray.size() - 1) * num;
            if (newProduct == 0) {
                productArray.add(num);
            } else {
                productArray.add(newProduct);
            }
        }

    }

    public int getProduct(int k) {

        if (productArray.size() - k <= lastZero) {
            return 0;
        }
        int last = productArray.get(productArray.size() - 1);
        if (k == productArray.size()) return last;

        int divisor = productArray.get(productArray.size() - k - 1);

        if (divisor == 0) return last;

        return last / divisor;
    }
}
