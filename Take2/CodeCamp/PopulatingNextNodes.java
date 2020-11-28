import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextNodes {

    public Node2 connect(Node2 root) {
        if (root == null) {
            return null;
        }
        Queue<NodeState> queue = new LinkedList<>();
        queue.add(new NodeState(root, 0));
        while (!queue.isEmpty()) {
            NodeState current = queue.poll();
            if (!queue.isEmpty()) {
                NodeState nextNode = queue.peek();
                if (nextNode.level == current.level) {
                    current.node.next = nextNode.node;
                }
            } else {
                current.node.next = null;
            }

            if (current.node.left != null) {
                queue.add(new NodeState(current.node.left, current.level + 1));
            }
            if (current.node.right != null) {
                queue.add(new NodeState(current.node.right, current.level + 1));
            }
        }
        return root;
    }
}

class NodeState {
    Node2 node;
    int level;

    public NodeState(Node2 _node, int _level) {
        node = _node;
        level = _level;
    }
}

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {
    }

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right, Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
