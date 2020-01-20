// Question : https://leetcode.com/problems/flood-fill/

public class FloodFill {

    public static void main(String[] args) {
        int[][] im = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 1}
        };

        floodFill(im, 1,1,2);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color == newColor) return image;
        image[sr][sc] = newColor;

        //left
        if (sr - 1 >= 0 && image[sr - 1][sc] == color) floodFill(image, sr - 1, sc, newColor);

        //right
        if (sr + 1 < image.length && image[sr + 1][sc] == color) floodFill(image, sr + 1, sc, newColor);

        //up
        if (sc - 1 >= 0 && image[sr - 1][sc] == color) floodFill(image, sr, sc - 1, newColor);

        //down
        if (sr + 1 >= image[0].length && image[sr - 1][sc] == color) floodFill(image, sr, sc + 1, newColor);

        return image;

    }
}
