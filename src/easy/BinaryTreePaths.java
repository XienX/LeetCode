package easy;
/*257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明:叶子节点是指没有子节点的节点。

输入:
   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> list = new ArrayList<>();
    StringBuilder s = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null)
            return list;

        s.append(root.val);
        paths(root);

        return list;
    }

    public void paths(TreeNode node) {
        if (node.left == null && node.right == null) {
            list.add(String.valueOf(s));
        }
        else {
            if (node.left != null) {
                s.append("->").append(node.left.val);
                paths(node.left);
            }
            if (node.right != null) {
                s.append("->").append(node.right.val);
                paths(node.right);
            }
        }

        int index = s.lastIndexOf("->");
        if (index>0)
            s.delete(index,s.length());
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}