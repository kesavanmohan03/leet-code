class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        
        traverse(root);

        // Swap the values of the two nodes found
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        // Standard BST Inorder: prev.val should always be < root.val
        if (prev != null && prev.val >= root.val) {
            // First anomaly: 'first' is the previous node
            if (first == null) {
                first = prev;
            }
            // Second anomaly: 'second' is the current node
            // We update 'second' every time an anomaly is found to handle adjacent swaps
            second = root;
        }
        
        prev = root;

        traverse(root.right);
    }
}
