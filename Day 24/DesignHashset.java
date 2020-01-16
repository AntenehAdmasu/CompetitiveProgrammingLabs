// Question link : https://leetcode.com/problems/design-hashset/

public class DesignHashset {

    String[] myhashset;
    public DesignHashset() {
        myhashset = new String[1000001];
    }

    /** value will always be non-negative. */
    public void add(int value) {
        myhashset[value] = ""+value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public void remove(int key) {
        if(myhashset[key] != null) myhashset[key] = null;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public boolean contains(int key) {
        return myhashset[key] != null;
    }
}
