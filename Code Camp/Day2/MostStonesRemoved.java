// Question link : https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MostStonesRemoved {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                new int[]{0,0},
                new int[]{0,1},
                new int[]{1,0},
                new int[]{1,2},
                new int[]{2,1},
                new int[]{1,3}
        };
        System.out.println(new MostStonesRemoved().removeStones(test));
    }
    public int removeStones(int[][] stones) {

        HashMap<Integer, ArrayList<Node>> rowNeighbours = new HashMap<>();
        HashMap<Integer, ArrayList<Node>> columnNeighbours = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        int pathCount = 0;

        //  Constructing neighbourlist of grids with the same row and column
        constructAdjacencyList(stones, rowNeighbours, columnNeighbours);

        for (int i = 0; i < stones.length ; i++) {
            Node node = new Node(stones[i][0], stones[i][1]);
            if(visited.contains(node)) continue;
            int nodeCount = 0;
            queue.add(node);

            // One while loop can identify the number of nodes in a connected network
            while(!queue.isEmpty()){
                Node current = queue.poll();
                visited.add(current);

                ArrayList<Node> neighbours = new ArrayList<>();
                neighbours.addAll(rowNeighbours.get(current.row));
                neighbours.addAll(columnNeighbours.get(current.column));

                for (Node neighbour: neighbours) {

                    if(!visited.contains(neighbour)){
                        // If we reach here, it means we have found one more connected node
                        nodeCount++;
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            pathCount += nodeCount;

        }

        return pathCount;
    }

    public void constructAdjacencyList(int[] stones, HashMap<Integer, ArrayList<Node>> rowNeighbours, HashMap<Integer, ArrayList<Node>> columnNeighbours){
        
        for (int[] stone: stones) { 
            if (rowNeighbours.containsKey(stone[0])) {
                rowNeighbours.get(stone[0]).add(new Node(stone[0],stone[1]));
            } else {
                ArrayList<Node> neigh = new ArrayList<>();
                neigh.add(new Node(stone[0],stone[1]));
                rowNeighbours.put(stone[0], neigh);
            }

            if (columnNeighbours.containsKey(stone[1])) {
                columnNeighbours.get(stone[1]).add(new Node(stone[0],stone[1]));
            } else {
                ArrayList<Node> neigh = new ArrayList<>();
                neigh.add(new Node(stone[0],stone[1]));
                columnNeighbours.put(stone[1], neigh);
            }
        }
    }
}



class Node {
    int row, column;

    public Node(int r, int c) {
        row = r;
        column = c;
    }

    @Override
    public boolean equals(Object o){
        Node newNode = (Node) o;
        return this.row == newNode.row && this.column == newNode.column;
    }

    @Override
    public int hashCode() {
        String hash = "" + row + column;
        return hash.hashCode();
    }
}