// Question link : https://leetcode.com/problems/word-search/

import java.util.HashMap;

public class WordSearch {


    public boolean exist(char[][] board, String word) {

        if(word.length() == 0 || board.length == 0){
            return false;
        }
        HashMap<String,Boolean> lookup = new HashMap<>();

        boolean isWordFound = false;
        char wordInitial = word.charAt(0);

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length ; column++) {
                if(board[row][column] == wordInitial){
                    isWordFound |= traverse(word, 1, row, column,board,lookup);
                }
            }
        }

        return isWordFound;
    }


    public boolean traverse(String word, int index, int row, int column, char[][] board,HashMap<String,Boolean> lookup){
        if(index == word.length()){
            return true;
        }

        boolean found = false;
        char currentChar = board[row][column];
        // left
        String cell = "" + row + "," + column;
        if(lookup.containsKey(cell)){
            return  lookup.get(cell);
        }
        board[row][column] = '0';
        if(row - 1 >= 0 && board[row-1][column] == word.charAt(index)){
            found |= traverse(word, index+1, row-1,column,board,lookup);
        }

        // right
        if(row + 1 < board.length  && board[row+1][column] == word.charAt(index)){
            found |= traverse(word, index+1, row+1,column,board,lookup);
        }

        // top
        if(column - 1 >= 0 && board[row][column-1] == word.charAt(index)){
            found |= traverse(word, index+1, row,column-1,board,lookup);
        }

        //bottom
        if(column + 1 < board[0].length && board[row][column+1] == word.charAt(index)){
            found |= traverse(word, index+1, row, column+1,board,lookup);
        }

        board[row][column] = currentChar;
        lookup.put(cell,found);

        return found;
    }

}

