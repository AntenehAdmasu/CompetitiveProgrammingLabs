import java.util.*;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();
        // Construct adjacency list
        Arrays.sort(words, new StringComparator());
        for(int i = 0; i < words.length; i++){
            ArrayList<String> neighbours = new ArrayList<>();
            for(int j = i + 1; j < words.length; j++){
                if(i == j){
                    continue;
                }
                if(isNeighbour(words[i], words[j])){
                    neighbours.add(words[j]);
                }
            }
            adjList.put(words[i], neighbours);
        }

        int maxLength = 1;
        // Run dfs
        for(String word: words){
            HashSet<String> visited = new HashSet<>();
            int length = runDfs(word, 1, adjList, visited);
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public int runDfs(String word, int length, HashMap<String, ArrayList<String>> adjList, HashSet<String> visited){
        visited.add(word);
        ArrayList<String> neighbours = adjList.containsKey(word) ? adjList.get(word) : null;
        int maxLen = length;
        if(neighbours != null){
            for(String neigh: neighbours){
                if(!visited.contains(neigh)){
                    int newLen = runDfs(neigh, length + 1, adjList, visited);
                    maxLen = Math.max(maxLen, newLen);
                }
            }
        }
        return maxLen;
    }

    public boolean isNeighbour(String word1, String word2){
        if(word1.length() + 1 != word2.length()){
            return false;
        }
        int i = 0;
        int j = 0;
        int deviation = 0;
        while(i < word1.length() && j < word2.length()){
            if(word1.charAt(i) == word2.charAt(j)){
                i++;
                j++;
            }else{
                deviation++;
                j++;
            }
            if(deviation > 1){
                return false;
            }
        }
        return deviation == 1|| i == word1.length();
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        return str1.length() - str2.length();
    }
}
