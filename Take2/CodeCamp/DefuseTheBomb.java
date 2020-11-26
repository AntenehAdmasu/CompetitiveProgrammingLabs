import java.util.Arrays;

public class DefuseTheBomb {

    public static void main(String[] args) {
        int[] inp = new int[]{2, 4, 9, 3};
        new DefuseTheBomb().decrypt(inp, -2);
    }

    public int[] decrypt(int[] code, int k) {

        int length = code.length;
        int[] sumArray = new int[length];
        int[] answer = new int[length];
        if(k == 0){
            return answer;
        }
        sumArray[0] = code[0];
        for (int i = 1; i < length ; i++) {
            sumArray[i] = sumArray[i-1] + code[i];
        }

        for (int i = 0; i < length; i++) {
            int decrypted;
            if(k > 0){
                decrypted = i + k >= length ? sumArray[length-1] - sumArray[i] + sumArray[k-(length-i)] : sumArray[i+k] - sumArray[i];
                answer[i] = decrypted;
            }else{
                decrypted = 0;
                if(i + k <= 0){
                    if(i > 0){
                        decrypted += sumArray[i-1];
                    }
                    decrypted += sumArray[length-1] - sumArray[length-1 - (-k-i)];
                }else{
                    decrypted = sumArray[i-1] - sumArray[i-1+k];
                }
                answer[i] = decrypted;
            }

        }
        return answer;
    }
}
