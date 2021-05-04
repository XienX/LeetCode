package easy;
/*剑指 Offer 54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第k大的节点。

示例 1:
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4

示例 2:
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4

限制：
1 ≤ k ≤ 二叉搜索树元素个数

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class ErChaSouSuoShuDeDiKDaJieDianLcof {
    int ans = 0;
    int k = 0;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        DFS(root);
        return ans;
    }

    public void DFS(TreeNode node) {
        if(node == null)
            return;

        DFS(node.right);

        if(k == 0)
            return;

        if(--k == 0)
            ans = node.val;

        DFS(node.left);
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