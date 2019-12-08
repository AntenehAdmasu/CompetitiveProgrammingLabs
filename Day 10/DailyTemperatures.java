public class DailyTemperatures {


    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] worst = new int[30000];


        int[] answer = new DailyTemperatures().dailyTemperatures(null);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

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
