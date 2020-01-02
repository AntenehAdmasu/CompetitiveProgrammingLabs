// Question : 

class CarFleet {
    public static void main(String[] args) {
        int[] position = new int[]{10,8,0,5,3};
        int[] speed = new int[]{2,4,1,1,3};


        int[] position2 = new int[]{0,4,2};
        int[] speed2 = new int[]{2,1,3};


        System.out.println("Fleet is " + new CarFleet().carFleet(12,position,speed));
    }
     public int carFleet(int target, int[] position, int[] speed){

        if(position.length == 0 || position.length == 1) return position.length;

        quickSort(0, position.length - 1, position, speed);


        float[] timeRemaining = new float[position.length];
        float mintime = 0;
        
         for (int i = 0; i < position.length; i++) {
            timeRemaining[i] = (float)(target - position[i])/speed[i];
        }
        int length = timeRemaining.length;

        boolean isFleet = false;
        int fleet = 1;
        for (int i = 0; i < length - 1; i++) {
            if (i == 0) mintime = timeRemaining[i];
            mintime = timeRemaining[i] > mintime ? timeRemaining[i]: mintime;


            if ((timeRemaining[i] >= timeRemaining[i+1])){
                if (timeRemaining[i] < mintime){
                    continue;
                }
                else{
                    if (isFleet == false){
                        isFleet = true;
                    }
                }

            }else {
                if(timeRemaining[i+1] < mintime) continue;
                fleet++;
                isFleet = false;
            }

        }

       
        return fleet;
    }
    public static void quickSort(int initialIndex, int finalIndex, int[] array, int array2[]) {

        if (initialIndex < finalIndex) {
            int pivIndex = getIndex(initialIndex, finalIndex, array, array2);
            quickSort(initialIndex, pivIndex - 1, array, array2);
            quickSort(pivIndex + 1, finalIndex, array, array2);
        }
    }

    public static int getIndex(int intialIndex, int finalIndex, int[] array, int[] array2) {
        int pivot = array[intialIndex];
        int pivotIndex = intialIndex;

        while (intialIndex < finalIndex) {

            try {
                while (array[intialIndex] >= pivot) intialIndex++;
                while (array[finalIndex] <= pivot) finalIndex--;

            } catch (Exception e) {
            }

            if (intialIndex < finalIndex) {
                int temp = array[intialIndex];
                int temp2 = array2[intialIndex];

                array[intialIndex] = array[finalIndex];
                array[finalIndex] = temp;

                array2[intialIndex] = array2[finalIndex];
                array2[finalIndex] = temp2;
            }
        }

        if (finalIndex > pivotIndex) {
            int temp = array[pivotIndex];
            int temp2 = array2[pivotIndex];

            array[pivotIndex] = array[finalIndex];
            array[finalIndex] = temp;

            array2[pivotIndex] = array2[finalIndex];
            array2[finalIndex] = temp2;

            return finalIndex;
        }
        return pivotIndex;
    }

}









