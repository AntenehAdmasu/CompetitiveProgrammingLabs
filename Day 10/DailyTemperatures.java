// Question : https://leetcode.com/problems/daily-temperatures

public class DailyTemperatures {


    public int[] dailyTemperatures(int[] T) {

        if(T == null) return null;

        int[] result = new int[T.length];
        for (int i = 0; i < T.length ; i++) {
            for (int j = 0; j < T.length - i ; j++) {

                if(T[i+j] > T[i]){
                    result[i] = j;
                    break;
                }
            }

        }

        return result;
    }

}
