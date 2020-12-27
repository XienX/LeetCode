package medium;
/*103. 二叉树的锯齿形层序遍历
给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：
[
  [3],
  [20,9],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//        if (root == null)
//            return ans;
//
//        List<Integer> first = new ArrayList<>();
//        first.add(root.val);
//        ans.add(first);
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        boolean flag = true;
//        while (true) {
//            List<Integer> tem = new ArrayList<>();
//            Stack<TreeNode> newStack = new Stack<>();
//
//            if (flag)
//                while (!stack.isEmpty()) {
//                    TreeNode node = stack.pop();
//                    if (node.right != null) {
//                        tem.add(node.right.val);
//                        newStack.push(node.right);
//                    }
//                    if (node.left != null) {
//                        tem.add(node.left.val);
//                        newStack.push(node.left);
//                    }
//                }
//            else
//                while (!stack.isEmpty()) {
//                    TreeNode node = stack.pop();
//                    if (node.left != null) {
//                        tem.add(node.left.val);
//                        newStack.push(node.left);
//                    }
//                    if (node.right != null) {
//                        tem.add(node.right.val);
//                        newStack.push(node.right);
//                    }
//                }
//
//            if (!tem.isEmpty()) {
//                ans.add(tem);
//                stack = newStack;
//                flag = !flag;
//            }
//            else break;
//        }
//
//        return ans;
//    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();

                if (isOrderLeft)
                    levelList.offerLast(curNode.val);
                else
                    levelList.offerFirst(curNode.val);

                if (curNode.left != null)
                    nodeQueue.offer(curNode.left);

                if (curNode.right != null)
                    nodeQueue.offer(curNode.right);
            }

            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/er-cha-shu-de-ju-chi-xing-ceng-xu-bian-l-qsun/
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