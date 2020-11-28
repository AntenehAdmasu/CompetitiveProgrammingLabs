import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class ShortestPathWithAtMostKObstacleRemoval {

    public int shortestPath(int[][] grid, int k) {
        HashMap<Node, Integer> nodeDistanceMap = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Node start = new Node(0, 0, k, 0);
        queue.add(start);
        nodeDistanceMap.put(start, 0);

        if (start.row == rowLen - 1 && start.col == colLen - 1) {
            return start.dis;
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int[] move : moves) {
                int newX = current.row + move[0];
                int newY = current.col + move[1];

                if (inBound(newX, newY, rowLen, colLen)) {
                    int newK = current.k - grid[newX][newY];
                    if (newK < 0) {
                        continue;
                    }
                    Node next = new Node(newX, newY, newK, current.dis + 1);
                    if (!nodeDistanceMap.containsKey(next)) {
                        queue.add(next);
                        nodeDistanceMap.put(next, next.dis);
                    }

                    if (next.row == rowLen - 1 && next.col == colLen - 1) {
                        return next.dis;
                    }

                }
            }
        }
        return -1;
    }

    public boolean inBound(int x, int y, int xSize, int ySize) {
        return (x >= 0 && x < xSize && y >= 0 && y < ySize);
    }
}


class Node {
    int row, col, k, dis;

    public Node(int row, int col, int k, int dis) {
        this.row = row;
        this.col = col;
        this.k = k;
        this.dis = dis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, k);
    }

    @Override
    public boolean equals(Object newNode) {
        Node newN = (Node) newNode;
        return this.row == newN.row && this.col == newN.col && this.k == newN.k;
    }
}

