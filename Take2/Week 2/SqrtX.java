public class SqrtX {

    public static void main(String[] args) {
        int sqrt = new SqrtX().mySqrt(17);
        System.out.println(sqrt);
    }

    public int mySqrt(int x) {
        if(x == 1) return x;
        int low = 0;
        int high = (x / 2);

        while(low <= high){
            int mid = (low + high) / 2;
            mid = Math.min(mid, 46341);

            double square = (double) Math.pow(mid, 2);
            double nextSquare = (double)(Math.pow((mid + 1),2));
            if((square <= x && nextSquare > x)){
                return mid;
            }
            if(square > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return 0;

    }
}
