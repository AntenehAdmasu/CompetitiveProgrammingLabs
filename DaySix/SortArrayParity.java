import java.util.ArrayList;
import java.util.Collections;

public class SortArrayParity {

   public static int[] sortArrayByParityII(int[] A){
       int[] B = new int[A.length];
       int evenIndex = 0;
       int oddIndex = 1;
       for (int a = 0; a < A.length; a++) {

           if (A[a] % 2 == 0) {
               B[evenIndex] = A[a];
               evenIndex += 2;

           }else{
               B[oddIndex] = A[a];
               oddIndex += 2;
           }
       }

       return B;
   }
}
