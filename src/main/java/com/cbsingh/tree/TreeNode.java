package com.cbsingh.tree;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = getTreeNode();

        System.out.println(inOrderTraversalIterative(root));
        System.out.println(inorderTraversalRecursive(root));
        //System.out.println(postOrderTraversalUsing2Stacks(root));
        //System.out.println(postOrderTraversalUsing1Stack(root));
        //System.out.println(postOrderTraversalIterative(root));
        //System.out.println(preOrderTraversalIterative(root));
       // System.out.println(levelOrderTraversalIterative(root));
    }

    private static TreeNode getTreeNode() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        return new TreeNode(1, left, right);
    }

    static List<Integer> inOrderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        while (true) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            if (stack.isEmpty())
                break;

            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }

    static List<Integer> preOrderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        while (true) {
            while (current != null) {
                list.add(current.val);
                stack.add(current);
                current = current.left;
            }
            if (stack.isEmpty())
                break;

            current = stack.pop();
            current = current.right;
        }
        return list;
    }

    static List<Integer> postOrderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        TreeNode previous = null;

        while (true) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            if (stack.isEmpty()) break;
            while (current == null && !stack.isEmpty()) {
                current = stack.peek();
                if (current.right == null || current.right == previous) {
                    list.add(current.val);
                    stack.pop();
                    previous = current;
                    current = null;
                } else {
                    current = current.right;
                }
            }
        }
        return list;
    }

    static List<Integer> postOrderTraversalUsing2Stacks(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            if (current.left != null) stack1.push(current.left);
            if (current.right != null) stack1.push(current.right);
            stack2.push(current.val);
        }

        Collections.reverse(stack2);
        return stack2;
    }

    public static List<Integer> levelOrderTraversalIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        var list = new ArrayList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            list.add(current.val);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return list;
    }

    static List<Integer> postOrderTraversalUsing1Stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, prev = root;
        List<Integer> resultList = new ArrayList<>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            if (current.right != null && current.right != prev) {
                current = current.right;
            } else {
                current = stack.pop();
                resultList.add(current.val);
                prev = current;
                current = null;
            }
        }
        return resultList;

    }

    static List<Integer> inorderTraversalRecursive(TreeNode root) {
        var result = new ArrayList<Integer>();
        inorderTraversalRecursiveHelper(root, result);
        return result;
    }

    private static void inorderTraversalRecursiveHelper(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        inorderTraversalRecursiveHelper(root.left, result);
        result.add(root.val);
        inorderTraversalRecursiveHelper(root.right, result);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}


