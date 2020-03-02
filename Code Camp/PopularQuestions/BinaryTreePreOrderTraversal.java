class BinaryTreePreOrderTraversal{

 
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root == null){
            return answer;
        }
        
        stack.push(root);
        while(!stack.isEmpty()){
           TreeNode current = stack.pop();
           answer.add(current.val);
            
           if(current.right != null){
               stack.push(current.right);
           } 
           if(current.left != null){
               stack.push(current.left);
           } 
        }
        
        return answer;
    }

}