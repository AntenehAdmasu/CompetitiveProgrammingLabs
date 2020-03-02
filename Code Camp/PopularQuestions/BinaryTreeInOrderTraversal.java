class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root == null){
            return answer;
        }
        TreeNode node = root;
        
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                answer.add(node.val);
                node = node.right;
            }    
        }
        
        return answer;
        
    } 
}