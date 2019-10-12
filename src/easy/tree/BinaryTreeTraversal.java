package easy.tree;


import easy.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeTraversal {

    List<Integer> list = new ArrayList<>();

    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        if (root == null) {
            return list;
        }
        inorder(root);
        return list;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right);
        }
    }


}
