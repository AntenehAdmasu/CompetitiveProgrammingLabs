// Question link : https://leetcode.com/problems/word-search-ii/submissions/

import java.util.ArrayList;
import java.util.List;

class WordSearchII{
    public List<String> findWords(char[][] board, String[] words) {
        // char[][] original = board;
        List<String> result = new ArrayList<>();
        for(String word: words){
            char[][] boardForWord = board;
            if(exist(boardForWord, word)){
                result.add(word);
            }
        }

        return result;
    }


    public boolean exist(char[][] board, String word) {

        if(word.length() == 0 || board.length == 0){
            return false;
        }

        boolean isWordFound = false;
        char wordInitial = word.charAt(0);

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length ; column++) {
                if(board[row][column] == wordInitial){
                    if(traverse(word, 1, row, column,board)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean traverse(String word, int index, int row, int column, char[][] board){
        if(index == word.length()){
            return true;
        }

        boolean found = false;
        char currentChar = board[row][column];
        // left
        board[row][column] = '0';
        if(row - 1 >= 0 && board[row-1][column] == word.charAt(index)){
            found |= traverse(word, index+1, row-1,column,board);
            if(found == true){
                board[row][column] = currentChar;
                return found;
            }
        }

        // right
        if(row + 1 < board.length  && board[row+1][column] == word.charAt(index)){
            found |= traverse(word, index+1, row+1,column,board);
            if(found == true){
                board[row][column] = currentChar;
                return found;
            }
        }

        // top
        if(column - 1 >= 0 && board[row][column-1] == word.charAt(index)){
            found |= traverse(word, index+1, row,column-1,board);
            if(found == true){
                board[row][column] = currentChar;
                return found;
            }
        }

        //bottom
        if(column + 1 < board[0].length && board[row][column+1] == word.charAt(index)){
            found |= traverse(word, index+1, row, column+1,board);
            if(found == true){
                board[row][column] = currentChar;
                return found;
            }
        }

        board[row][column] = currentChar;

        return found;
    }
}