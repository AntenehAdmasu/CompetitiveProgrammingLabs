// Question : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

import java.util.Stack;

public class RemoveAdjecentDuplicate {

    public static void main(String[] args) {
        String s = "adccde";
        String before = s.substring(0, 0);
        String after = s.substring(3);
        System.out.println(before);
        System.out.println(remove("pbbcggttciiippooaais", 2 ));
        System.out.println(remove("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4 ));
    }

    public static String removeDuplicates(String s, int k) {
        return removeDuplicatesII(new StringBuilder(s), k);
    }

    public static String removeDuplicatesII(StringBuilder s, int k) {

        for (int i = 0; i < s.length(); i++) {
            if (checkDuplicates(s, i, i + k)) {
                StringBuilder before = new StringBuilder(s.substring(0, i));
                StringBuilder after = new StringBuilder(s.substring(i + k));
                return removeDuplicatesII(before.append(after), k);
            }
        }
        return s.toString();
    }

    public static boolean checkDuplicates(StringBuilder s, int start, int end) {

        if (end > s.length()) return false;
        char test = s.charAt(start);
        for (int i = end - 1; i >= start; i--) {
            if (s.charAt(i) != test) return false;
        }
        return true;
    }


    public static String remove(String s, int k) {
        Stack<MyMap> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                MyMap elt = new MyMap(s.charAt(i), 1);
                stack.push(elt);
                continue;
            }
            MyMap top = stack.peek();
            if (top.getC() == s.charAt(i)) {
                top.setOcc(top.getOcc() + 1);
                if (top.getOcc() == k) {
                    stack.pop();
                }
            } else {
                MyMap elt = new MyMap(s.charAt(i), 1);
                stack.push(elt);
            }

        }
        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()){
            MyMap element = stack.pop();
            for (int i = 0; i < element.getOcc(); i++){
                ans.insert(0,element.getC() );
            }
        }
        return ans.toString();
    }
}

class MyMap {
    private Character c;
    private int occ;

    public MyMap(Character character, int occurence) {
        c = character;
        occ = occurence;
    }

    public void setC(Character c) {
        this.c = c;
    }

    public void setOcc(int occ) {
        this.occ = occ;
    }

    public Character getC() {
        return c;
    }

    public int getOcc() {
        return occ;
    }
}
