import java.util.ArrayList;
import java.util.List;

public class DesignOrderedStream {
    String[] letters;
    int ptr;
    int size;

    public DesignOrderedStream(int n) {
        letters = new String[n];
        ptr = 0;
        size = n;
    }

    public List<String> insert(int id, String value) {
        List<String> answer = new ArrayList<>();
        letters[id-1] = value;
        if(letters[ptr] == null){
            return answer;
        }
        answer.add(letters[ptr]);
        String prev = letters[ptr];
        while(++ptr < size && letters[ptr] != null){
            answer.add(letters[ptr]);
        }
        return answer;
    }

    private boolean checkOrder(String letter, String letter1) {
        char c1 = letter.charAt(4);
        char c2 = letter1.charAt(0);
        return c1 <= c2;

    }
}
