// Question : https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

import java.util.List;

public class MaximumDepthOfTree {


    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxDepth = maxDepthFinder(root, 1);
        return maxDepth;
    }

    public int maxDepthFinder(Node node, int level) {

        int max = level;

        if(node.children == null) return level;

        for (Node n: node.children){
            int depth = maxDepthFinder(n,level+1);
            max = depth > max ? depth : max;
        }
        return max;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


