package tree;

import java.util.*;

public class BTVerticalTraveral314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // create a List of List to store the result
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        // Key = col, Val = node.val on the col
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> idx = new LinkedList<Integer>();
        q.offer(root);
        idx.offer(0);

        // arrange
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (q != null) {
            TreeNode n = q.poll();
            int index = idx.poll();
            min = Math.min(index, min);
            max = Math.max(index, max);
            // if index is not a key in the colMap, add it
            if (!colMap.containsKey(index)) {
                colMap.put(index, new LinkedList<>());
            }
            // if index is a key in the colMap
            colMap.get(index).add(n.val);

            if (n.left != null) {
                q.offer(n.left);
                idx.offer(index - 1);
            }
            if (n.right != null) {
                q.offer(n.right);
                idx.offer(index + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(colMap.get(i));
        }

        return res;

    }

    public TreeNode createNewNode(int val) {
        TreeNode newNode = new TreeNode();
        newNode.val = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public static void main(String[] args) {
        BTVerticalTraveral314 a = new BTVerticalTraveral314();

        TreeNode root = a.createNewNode(3);
        root.left = a.createNewNode(9);
        root.right = a.createNewNode(20);
        root.right.left = a.createNewNode(15);
        root.right.right = a.createNewNode(7);

        List<List<Integer>> solution = a.verticalOrder(root);
        for (List<Integer> list : solution) {
            System.out.print(list);
        }
    }
}
