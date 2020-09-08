import java.util.HashMap;

public class SparseArrays {

    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];
        int i = 0;
        HashMap<String, Integer> stringsMap = new HashMap<>();
        for(String s: strings){
            stringsMap.put(s, stringsMap.containsKey(s) ? stringsMap.get(s) + 1 : 1);
        }
        for(String q : queries){
            result[i++] = stringsMap.containsKey(q) ? stringsMap.get(q) : 0;
        }
        return result;
    }

}
