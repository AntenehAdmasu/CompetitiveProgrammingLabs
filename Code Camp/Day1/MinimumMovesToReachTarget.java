// Question link : https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/

import java.util.HashSet;
import java.util.LinkedList;

public class MinimumMovesToReachTarget {
    public int minimumMoves(int[][] grid) {

        HashSet<State> visited = new HashSet<>();
        LinkedList<State> queue = new LinkedList<>();
        int gridSize = grid[0].length;

        // order - x1, y1, x2, y2
        int[][] moves = new int[][]{
                new int[]{0, 1, 0, 1},     // One step to the right
                new int[]{1, 0, 1, 0},     // On step downwards
                new int[]{0, 0, 1, -1},    // Clockwise rotation
                new int[]{0, 0, -1, 1}     // Counter clockwise rotation
        };

        State start = new State(0, 0, 0, 1, 0);
        queue.add(start);
        State destination = new State(gridSize - 1, gridSize - 2, gridSize - 1, gridSize - 1, 0);

        while (!queue.isEmpty()) {
            State current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newx1 = current.x1 + moves[i][0];
                int newy1 = current.y1 + moves[i][1];
                int newx2 = current.x2 + moves[i][2];
                int newy2 = current.y2 + moves[i][3];

                State neighbour = new State(newx1, newy1, newx2, newy2, current.distance + 1);
                if (validMove(neighbour, i, gridSize, grid) && !visited.contains(neighbour)) {
                    if (neighbour.equals(destination)) {
                        return neighbour.distance;
                    }
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        return -1;
    }
    public boolean validMove(State neighbour, int moveId, int gridSize, int[][] grid) {

        // Check if it is inside the grid
        int N = gridSize;
        if (neighbour.x1 < 0 || neighbour.x1 >= N ||
                neighbour.x2 < 0 || neighbour.x2 >= N ||
                neighbour.y1 < 0 || neighbour.y1 >= N ||
                neighbour.y2 < 0 || neighbour.y2 >= N ||
                grid[neighbour.x1][neighbour.y1] == 1 ||
                grid[neighbour.x2][neighbour.y2] == 1) {
            return false;
        }

        // Clockwise rotation - has to be on horizontal position and diagonal cell must be 0
        if (moveId == 2) {
            if (neighbour.y1 != neighbour.y2 || grid[neighbour.x2][neighbour.y2 + 1] == 1) {
                return false;
            }
        }

        // Counter clockwise rotation - has to be in vertical position and diagonal cell must be 0
        if (moveId == 3) {
            if (neighbour.y1 == neighbour.y2 || grid[neighbour.x2 + 1][neighbour.y2] == 1) {
                return false;
            }
        }

        return true;
    }
}



class State {
    // x1 and y1 refer to the tail coordinates
    // x2 and y2 refer to the head coordinates
    int x1, y1, x2, y2;
    int distance;

    public State(int X1, int Y1, int X2, int Y2, int dis) {
        x1 = X1;
        y1 = Y1;
        x2 = X2;
        y2 = Y2;
        distance = dis;
    }

    @Override
    public boolean equals(Object o) {
        State newState = (State) o;
        return this.x1 == newState.x1 && this.y1 == newState.y1 && this.x2 == newState.x2 && this.y2 == newState.y2;
    }

    @Override
    public int hashCode() {
        String hash = "" + x1 + x2 + y1 + y2;
        return hash.hashCode();
    }
}



