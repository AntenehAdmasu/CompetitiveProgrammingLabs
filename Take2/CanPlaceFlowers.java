public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int possibleSpots = 0;
        int len = flowerbed.length;
        for (int i = 0; i < flowerbed.length; i++) {

            if(flowerbed[i] == 0){
                boolean left = i == 0 ? true : flowerbed[i-1] == 0;
                boolean right = i == len - 1 ? true : flowerbed[i+1] == 0;
                if(left && right){
                    if(++possibleSpots >= n){
                        return true;
                    }
                    flowerbed[i] = 1;
                }
            }
        }
        return possibleSpots >= n;

    }
}
