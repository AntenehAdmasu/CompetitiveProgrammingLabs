// Question link : https://leetcode.com/problems/top-k-frequent-words/

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String a = "abcaa";
        String b = "bca";
        String c = "bca";

        String[] words = new String[]{a,b,c};
        new TopKFrequentWords().topKFrequent(words,2);

    }


    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<WordFreqPair> heap = new PriorityQueue<>(k);

        HashMap<String, Integer> wordsCounter = new HashMap<>();

        for (String word: words) {
            wordsCounter.put(word, wordsCounter.containsKey(word) ? wordsCounter.get(word) + 1 : 1);
        }
        for (String word: wordsCounter.keySet()) {
            addToHeap(heap,new WordFreqPair(word,wordsCounter.get(word)),k);
        }
        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.poll().word);
        }
        Collections.reverse(ans);

        return ans;
    }

    public void addToHeap(PriorityQueue<WordFreqPair> heap, WordFreqPair word, int k){
        if(heap.size() >= k){
            if(heap.peek().compareTo(word) < 0){
                heap.poll();
                heap.add(word);
            }
        }else{
            heap.add(word);
        }
    }
}


class WordFreqPair implements Comparable<WordFreqPair>{
    String word;
    int frequency;

    public WordFreqPair(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(WordFreqPair o) {
        WordFreqPair newPair = (WordFreqPair) o;
        if(frequency > newPair.frequency) return 1;

        //Returns a negative number with value of differences if the first word precedes lexicographically
        if (frequency == newPair.frequency){
            if(word.compareTo(newPair.word) < 0) return 1;
        }
        return -1;
    }
}