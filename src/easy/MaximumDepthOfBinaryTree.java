package easy;
/*给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明:叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度3 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
//    public int maxDepth(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode node;
//        int len;
//        int level = 0;
//
//        if (root == null)
//            return 0;
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            level++;
//
//            for (len=queue.size();len>0;len--) {
//                node = queue.poll();
//                if (node.left != null)
//                    queue.offer(node.left);
//                if (node.right != null)
//                    queue.offer(node.right);
//            }
//        }
//
//        return level;
//    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */