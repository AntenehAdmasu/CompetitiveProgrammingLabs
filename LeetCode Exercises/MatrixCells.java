import java.util.ArrayList;

public class MatrixCells {
//    public static void main(String[] args) {
//        int[][] ans = allCellsDistOrder(2,3,1,2);
//        for (int i = 0; i < 6; i++) {
//            System.out.print(ans[i][0]);
//            System.out.println(ans[i][1]);
//        }
//
//    }
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<int[]> distanceCellMap = new ArrayList<>();
        ArrayList<Integer> cellDistances = new ArrayList<>();
         int[][] answer = new int[R*C][2];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C ; j++) {
                int distance = Math.abs(r0 - i) + Math.abs(c0 - j);
                distanceCellMap.add(new int[]{distance,i,j});
                cellDistances.add(distance);
             }
        }
        ArrayList<Integer> sortedDistance = sort(cellDistances);


        for (int i = 0; i < sortedDistance.size() ; i++) {

            for (int j = 0; j < distanceCellMap.size(); j++) {
                if(sortedDistance.get(i) == distanceCellMap.get(j)[0]){
                    System.out.println("distance found " + sortedDistance.get(i) + " at " + distanceCellMap.get(j)[1] + distanceCellMap.get(j)[2]);
                    answer[i] = new int[]{distanceCellMap.get(j)[1],distanceCellMap.get(j)[2]};
                    System.out.println("**********");

                        System.out.print(answer[i][0]);
                        System.out.println(answer[i][1]);
                    System.out.println("i is " + i);

                    distanceCellMap.remove(j);
                    break;

                }
            }
        }

        System.out.println("the size of dismap is " + distanceCellMap.size());
        return answer;


    }


    public static ArrayList<Integer> sort(ArrayList<Integer> nums){
        ArrayList<Integer> left;
        ArrayList<Integer> right;
        int length = nums.size();

        if(length == 1){
            return nums;
        }else{
            left = sort(new ArrayList<Integer>( nums.subList(0, (length/2))) );
            right = sort(new ArrayList<Integer>( nums.subList(length/2, length ) ));
            return merge(left, right);
        }
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        int l = 0;
        int r = 0;
        ArrayList<Integer> mergedList = new ArrayList<>();
        while ((l < left.size()) && (r < right.size())) {
            if (left.get(l) < right.get(r)) {
                mergedList.add(left.get(l));
                l++;
            } else {
                mergedList.add(right.get(r));
                r++;
            }
        }
        if(l == left.size()){
            for (int i = r; i < right.size(); i++) {
                mergedList.add(right.get(i));
            }
        }else{
            for (int i = l; i < left.size(); i++) {
                mergedList.add(left.get(i));
            }
        }

        return mergedList;
    }
}
