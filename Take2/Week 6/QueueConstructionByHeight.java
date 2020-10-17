import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class QueueConstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new TwoDArrayComp());
        LinkedList<int[]> answer = new LinkedList<>();
        for (int[] person : people) {
            answer.add(person[1], person);
        }
        return answer.toArray(people);
    }
}


class TwoDArrayComp implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
            return o1[1] - o2[1];
        } else {
            return o2[0] - o1[0];
        }
    }
}