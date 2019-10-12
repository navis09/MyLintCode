package easy.tree;


import easy.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
 *
 * A valid path is from root node to any of the leaf nodes.
 */
public class BinaryTreePathSum {

    List<List<Integer>> resultList = new ArrayList<>();
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        if (root == null) {
            return resultList;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        traverse(root, target, root.val, list);
        return resultList;
    }

    private void traverse(TreeNode root, int target, int total, List pathList) {

        if (root.left == null && root.right == null && total == target) {
            resultList.add(pathList);
        }
        if (root.left != null) {
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(pathList);
            tempList.add(root.left.val);
            traverse(root.left, target, total + root.left.val, tempList);
        }
        if (root.right != null) {
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(pathList);
            pathList.add(root.right.val);
            traverse(root.right, target, total + root.right.val, pathList);
        }
    }

}
