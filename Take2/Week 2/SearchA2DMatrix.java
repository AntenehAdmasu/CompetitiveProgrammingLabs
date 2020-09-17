public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        // Identify the row to search
        int startCol = 0;
        int endCol = matrix.length - 1;
        int lastIndex = matrix[0].length-1;
        int row = -1;

        while (startCol <= endCol){
            int mid = (startCol + endCol) / 2;

            // If the target is in the mid row
            if(matrix[mid][0] <= target && matrix[mid][lastIndex] >= target){
                row = mid;
                break;
            }
            if (matrix[mid][0] > target){
                endCol = mid - 1;
            }else{
                startCol = mid + 1;
            }
        }
        if(row == -1){
            return false;
        }

        // Search in the identified row
        int startRow = 0;
        int endRow = lastIndex;
        while (startRow <= endRow){
            int mid = (startRow + endRow) / 2;
            if(matrix[row][mid] == target){
                return true;
            }
            if(matrix[row][mid] > target){
                endRow = mid - 1;
            }else{
                startRow = mid + 1;
            }
        }
        return false;
    }
}
