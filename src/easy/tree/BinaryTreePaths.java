package easy.tree;

import easy.basic.TreeNode;
import easy.basic.TreeNodeNPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Example:
 *
 *     1
 *   /   \
 *  2     3
 *   \
 *    5
 *
 * All root-to-leaf paths are:
 *  [
 *   "1->2->5",
 *   "1->3"
 * ]
 *
 */
public class BinaryTreePaths {


    List<String> paths = new ArrayList<>();

    /**
     * Recursive
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        if (root == null) {
            return paths;
        }
        getTreePaths(root, root.val + "");
        return paths;
    }

    private void getTreePaths(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            paths.add(path);
        }
        if (root.left != null) {
            getTreePaths(root.left, path + "->" + root.left.val);
        }
        if (root.right != null) {
            getTreePaths(root.right, path + "->" + root.right.val);
        }

    }


    /**
     * Stack
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        Stack<TreeNodeNPath> stack = new Stack<>();
        stack.push(new TreeNodeNPath(root, String.valueOf(root.val)));
        while (!stack.isEmpty()) {
            TreeNodeNPath tempNode = stack.pop();

            if (tempNode.treeNode.left == null && tempNode.treeNode.right == null) {
                list.add(tempNode.path);
            }
            if (tempNode.treeNode.left != null) {
                String temp = tempNode.path + "->" + tempNode.treeNode.left.val;
                stack.push(new TreeNodeNPath(tempNode.treeNode.left, temp));
            }
            if (tempNode.treeNode.right != null) {
                String temp = tempNode.path + "->" + tempNode.treeNode.right.val;
                stack.push(new TreeNodeNPath(tempNode.treeNode.right, temp));
            }
        }
        return list;

    }

}
