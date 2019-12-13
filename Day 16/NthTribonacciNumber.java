public class NthTribonacciNumber {

    public static void main(String[] args) {
        int ans = new NthTribonacciNumber().tribonacci(25);

    }

    public int tribonacci(int n) {

        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;

        int[] mylist = new int[n+1];

        mylist[0] = 0;
        mylist[1] = 1;
        mylist[2] = 1;

        System.out.println(mylist.length);

        for (int i = 3; i < mylist.length; i++) {
            mylist[i] = mylist[i-1] + mylist[i-2] + mylist[i-3];
        }
        return mylist[n];

    }

}
