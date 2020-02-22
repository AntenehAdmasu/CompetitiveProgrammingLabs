import java.util.Arrays;

public class MergeMultidimensional {


    public static void main(String[] args) {
        int[][] test = new int[][]{
                  {0,   2, 10},
                  {3,   5,  0},
                  {9,  20,  6},
                  {10, 12, 15},
                  {10, 10,  8}
        };

       int cost = calcDroneMinEnergy(test);
       System.out.println(cost);
    }


    public static int calcDroneMinEnergy(int[][] route) {
    
        int height = route[0][2];
        for(int i = 1; i < route.length; i++){
            if(route[i][2] > height){
            height = route[i][2];
            }
        }
        return (height - route[0][2]);
    
    }
    
}
