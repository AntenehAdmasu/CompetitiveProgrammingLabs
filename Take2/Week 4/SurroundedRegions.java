class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null|| board.length == 0){
            return;
        }
        int rowLength = board.length;
        int columnLength = board[0].length;

        // Go through the top and bottom border of the board
        for(int column = 0; column < columnLength; column++){
            // top border
            if(board[0][column] == 'O'){
                runDfs(0, column, board);
            }
            // bottom border
            if(board[rowLength-1][column] == 'O'){
                runDfs(rowLength - 1, column, board);
            }
        }
        for(int row = 0; row < rowLength; row++){
            // left border
            if(board[row][0] == 'O'){
                runDfs(row, 0, board); // Change all existsing Os to some character
            }
            // right border
            if(board[row][columnLength-1] == 'O'){
                runDfs(row, columnLength - 1, board);
            }
        }

        for(int r = 0; r < rowLength; r++){
            for(int c = 0; c < columnLength; c++){
                if(board[r][c] == 'B'){
                    board[r][c] = 'O';
                }else{
                    board[r][c] = 'X';
                }
            }
        }

    }

    public void runDfs(int row, int column, char[][] board){
        if(row < 0 || row > board.length - 1|| column < 0 || column > board[0].length - 1 || board[row][column] == 'B' || board[row][column] == 'X'){
            return;
        }
        board[row][column] = 'B';
        runDfs(row - 1, column, board);
        runDfs(row + 1, column, board);
        runDfs(row, column - 1, board);
        runDfs(row, column + 1, board);
    }

}