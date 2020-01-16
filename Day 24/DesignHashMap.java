// Question link : https://leetcode.com/problems/design-hashmap/

public class DesignHashMap {

    public static void main(String[] args) {
        String[] x = new String[2];
//        System.out.println(x[1]);
    }
    String[] myhashmap;
    public DesignHashMap() {
        myhashmap = new String[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
       myhashmap[key] = ""+value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return myhashmap[key] == null ? -1 : Integer.parseInt(myhashmap[key]);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        myhashmap[key] = null;
    }
}
