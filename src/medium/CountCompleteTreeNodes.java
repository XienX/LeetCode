package medium;
/*222. 完全二叉树的节点个数
给出一个完全二叉树，求出该树的节点个数。

说明：
完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
若最底层为第 h 层，则该层包含 1~2h个节点。

示例:
输入:
    1
   / \
  2   3
 / \  /
4  5 6
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class CountCompleteTreeNodes {
    int ans;
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode node = root.left;
        int depth = 1;

        while (node != null) {
            depth++;
            node = node.left;
        }

        ans = (int) Math.pow(2, depth-1) - 1;

        countNodes(root, depth);

        return ans;
    }

    private boolean countNodes(TreeNode root, int depth) {
        if (root == null)
            return false;

        if (depth == 1) {
            ans++;
            return true;
        }

        return countNodes(root.left, depth-1) && countNodes(root.right, depth-1);
    }
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
