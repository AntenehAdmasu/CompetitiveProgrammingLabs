class Solution(object):
    def lcaDeepestLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        node, level = self.getLCA(root);
        return node
    
    def getLCA(self, node):
        if(node == None):
            return node, 0;
        
        leftNode, leftLevel = self.getLCA(node.left);
        rightNode, rightLevel = self.getLCA(node.right);
                
        if(leftLevel == rightLevel):
            return node, leftLevel + 1
        elif(leftLevel < rightLevel):
            return rightNode, rightLevel + 1
        
        return leftNode, leftLevel + 1;