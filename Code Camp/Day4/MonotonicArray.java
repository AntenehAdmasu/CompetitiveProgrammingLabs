public class MonotonicArray {
    public static void main(String[] args) {
        int[] test = new int[]{-2,-2,-2,-2,-2,-2};
        int[] test2 = new int[]{3,3,4,5,67,-8};
        int[] test1 = new int[]{3};
        System.out.println(new MonotonicArray().isMonotonic(test1));
        System.out.println("###########");
//        System.out.println(new MonotonicArray().isMonotonic(test2));

    }

    public boolean isMonotonic(int[] A) {
        int firstChange = 0;
        boolean increasinng = true;
        while (firstChange < A.length-1 && A[firstChange] == A[firstChange+1]) firstChange++;
        if(firstChange == A.length -1){
            return true;
        }
        if(A[firstChange] >= A[firstChange+1]) increasinng = false;

       for (int i = firstChange; i < A.length-1; i++) {
            if(increasinng){
                if(A[i] > A[i+1]) return false;
            }else{
                if(A[i] < A[i+1]) return false;
            }
        }
        return true;
    }
}
