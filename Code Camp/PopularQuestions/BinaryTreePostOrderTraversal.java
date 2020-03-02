class BinaryTreePostOrderTraversal{

    
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return answer;
        }
        stack.add(root);
        
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            answer.add(current.val);
            
            if(current.left != null){
                stack.push(current.left);
            }
            if(current.right != null){
                stack.push(current.right);
            }
            
        }
        
        Collections.reverse(answer);
        return answer;

    }
}