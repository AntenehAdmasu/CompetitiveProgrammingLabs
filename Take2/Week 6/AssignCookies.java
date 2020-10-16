import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        findContentChildren(g,s);
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int greedCounter = 0;
        int sizeCounter = 0;
        int result = 0;
        while (greedCounter < g.length && sizeCounter < s.length){
            if(s[sizeCounter] >= g[greedCounter]){
                result++;
                greedCounter++;
            }
            sizeCounter++;
        }
        return result;
    }
}
