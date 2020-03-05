// Question link : https://leetcode.com/problems/queens-that-can-attack-the-king/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class QueensThatCanAttackTheKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> answer = new ArrayList<>();
        HashSet<ChessCoordinate> queenCoordinates = new HashSet<>();
        for (int[] queen : queens) {
            ChessCoordinate queenPos = new ChessCoordinate(queen[0], queen[1]);
            queenCoordinates.add(queenPos);
        }

        for (int[] queen : queens) {
            if (canAttack(queen, queenCoordinates, king)) {
                List<Integer> attacker = new ArrayList<>();
                attacker.add(queen[0]);
                attacker.add(queen[1]);
                answer.add(attacker);
            }
        }
        return answer;
    }

    private boolean canAttack(int[] queen, HashSet<ChessCoordinate> queenCoordinates, int[] king) {
        if (!(queen[0] == king[0] || queen[1] == king[1] || Math.abs(queen[0] - king[0]) == Math.abs(queen[1] - king[1]))) {
            // queen can not find the king horizontally, vertically or diagonally
            return false;
        }

        // Vertical Attack
        if (queen[0] == king[0]) {
            boolean toLeft = queen[1] < king[1];
            int newX = queen[1];
            newX += toLeft ? 1 : -1;
            while (newX != king[1]) {
                ChessCoordinate nextCoord = new ChessCoordinate(queen[0], newX);
                // Checking for barriers
                if (queenCoordinates.contains(nextCoord)) {
                    return false;
                }
                newX += toLeft ? 1 : -1;
            }
            return true;
        }

        // For horizontal attack
        if (queen[1] == king[1]) {
            boolean isUp = queen[0] < king[0];

            int newX = queen[0];
            newX += isUp ? 1 : -1;
            while (newX != king[0]) {
                ChessCoordinate nextCoord = new ChessCoordinate(newX, queen[1]);
                // Checking for barriers
                if (queenCoordinates.contains(nextCoord)) {
                    return false;
                }
                newX += isUp ? 1 : -1;
            }
            return true;
        }

        // For diagonal attack
        if (Math.abs(queen[0] - king[0]) == Math.abs(queen[1] - king[1])) {

            boolean xLeft = queen[0] < king[0];
            boolean yUp = queen[1] < king[1];

            int newX = queen[0];
            int newY = queen[1];
            newX += xLeft ? 1 : -1;
            newY += yUp ? 1 : -1;

            while (newX != king[0] && newY != king[1]) {
                ChessCoordinate nextCoord = new ChessCoordinate(newX, newY);
                // Checking for barriers
                if (queenCoordinates.contains(nextCoord)) {
                    return false;
                }
                // updaating coordinates
                newX += xLeft ? 1 : -1;
                newY += yUp ? 1 : -1;
            }
            return true;
        }

        return true;
    }
}

class ChessCoordinate {
    int x;
    int y;

    public ChessCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object newObj) {
        ChessCoordinate newOb = (ChessCoordinate) newObj;
        return this.x == newOb.y && this.y == newOb.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}