import java.util.ArrayList;

public class KClosestPoints {

    public int[][] kClosest(int[][] points, int K) {
        int[][] answer = new int[K][2];

        return answer;

    }


    public int[][] allCellsDistOrder(int[][] points, int K) {
        int[][] distanceCellMap = new int[points.length][3];
        int[][] answer = new int[K][2];


        for (int i = 0; i < points.length; i++) {
            int distance = (int)(( Math.pow(points[i][0], 2)) + ( Math.pow(points[i][1], 2)));
            distanceCellMap[i] = new int[]{distance, points[i][0],points[i][1]};
         }
        quickSort(0, distanceCellMap.length - 1, distanceCellMap);


        for (int j = 0; j < K; j++) {
            answer[j] = new int[]{distanceCellMap[j][1],distanceCellMap[j][2]};
        }

        for (int i = 0; i < answer.length ; i++) {
            System.out.print("Co-1 " + answer[i][0] + "   ");
            System.out.println("Co-1 " + answer[i][1] + "   ");

         }

        return null;


    }


    public void quickSort(int initialIndex, int finalIndex, int[][] array) {

        if (initialIndex < finalIndex) {
            int pivIndex = getSortedPivotIndex(initialIndex, finalIndex, array);
            quickSort(initialIndex, pivIndex - 1, array);
            quickSort(pivIndex + 1, finalIndex, array);
        }
    }

    public int getSortedPivotIndex(int intialIndex, int finalIndex, int[][] array) {
        int pivot = array[intialIndex][0];
        int pivotIndex = intialIndex;

        while (intialIndex < finalIndex) {

            try {
                while (array[intialIndex][0] <= pivot) intialIndex++;
                while (array[finalIndex][0] >= pivot) finalIndex--;

            } catch (Exception e) {
            }

            if (intialIndex < finalIndex) {
                int[] temp = array[intialIndex];
                int[] temp2 = array[finalIndex];

                array[intialIndex] = temp2;
                array[finalIndex] = temp;
            }
        }

        if (finalIndex > pivotIndex) {
            int[] temp = array[pivotIndex];
            int[] temp2 = array[finalIndex];

            array[pivotIndex] = temp2;
            array[finalIndex] = temp;

            return finalIndex;
        }
        return pivotIndex;
    }



}
