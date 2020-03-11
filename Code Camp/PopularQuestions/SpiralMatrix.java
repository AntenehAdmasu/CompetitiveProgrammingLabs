import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {

    private void traverse(int[][] matrix, int row, int column, Set<String> visited, List<Integer> nums, int direction) {
        String cell = "" + row + column;
        if(visited.contains(cell))
            return;
        visited.add(cell);
        nums.add(matrix[row][column]);

        // right
        if (direction == 0 ) {
            int dir = (visited.contains(("" + row + (column + 1))) || column + 1 >= matrix[0].length) ? 1 : 0;
            if(direction == dir){
                traverse(matrix, row, column + 1, visited, nums, dir);
                return;
            }else{
                direction = dir;
            }
        }

        // down
        if (direction == 1 ) {
            int dir = visited.contains(("" + (row+1) + column )) || row + 1 >= matrix.length ? 2 : 1;
            if(direction == dir){
                traverse(matrix, row + 1, column, visited, nums, dir);
                return;
            }else{
                direction = dir;
            }
        }

        // left
        if (direction == 2) {
            int dir = visited.contains("" + row + (column-1) ) || column - 1 < 0 ? 3 : 2;
            if(direction == dir){
                traverse(matrix, row, column - 1, visited, nums,dir);
                return;
            }else{
                direction = dir;
            }
        }

        // up
        if (direction == 3) {
            int dir = visited.contains("" + (row-1) + column) || row - 1 < 0 ? 0 : 3;
            if(direction == dir){
                traverse(matrix, row - 1, column, visited, nums,dir);
                return;
            }else{
                if(column + 1 < matrix[0].length)
                    traverse(matrix, row, column + 1, visited, nums,dir);
            }
        }

    }
}
