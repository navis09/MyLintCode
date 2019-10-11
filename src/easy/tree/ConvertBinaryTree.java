package easy.tree;


import easy.basic.ListNode;
import easy.basic.TreeNode;
import easy.basic.TreeNodeWithLevel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 * Definition of TreeNode:
 *      * public class TreeNode {
 *      *     public int val;
 *      *     public TreeNode left, right;
 *      *     public TreeNode(int val) {
 *      *         this.val = val;
 *      *         this.left = this.right = null;
 *      *     }
 *      * }
 *      * Definition for singly-linked list.
 *      * public class ListNode {
 *      *     int val;
 *      *     ListNode next;
 *      *     ListNode(int x) { val = x; }
 *      * }
 *
 */
public class ConvertBinaryTree {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeWithLevel(root, 0));

        while(!queue.isEmpty()) {
            TreeNodeWithLevel treeNodeLevel = queue.remove();
            TreeNode node = treeNodeLevel.treeNode;

            if (treeNodeLevel.level >= list.size()) {
                list.add(new ListNode(node.val));
            } else {
                ListNode listNode = list.get(treeNodeLevel.level);
                listNode.next = new ListNode(node.val);
            }
            if (node.left != null) {
                queue.add(new TreeNodeWithLevel(node.left, treeNodeLevel.level + 1));
            }
            if (node.right != null) {
                queue.add(new TreeNodeWithLevel(node.right, treeNodeLevel.level + 1));
            }

        }

        return list;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode rootLl = new TreeNode(4);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = rootLl;

        printListNode(new ConvertBinaryTree().binaryTreeToLists(root));
    }

    private static void printListNode(List<ListNode> list) {
        for (ListNode listNode : list) {
            while (listNode != null) {
                System.out.print(listNode.val + " ");
                listNode = listNode.next;
            }
            System.out.println();
        }
    }
}
