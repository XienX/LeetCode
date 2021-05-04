package easy;
/*剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：
输入：head = [1,3,2]
输出：[2,3,1]

限制：
0 <= 链表长度 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        int len = stack.size();
        int[] ans = new int[len];
        for (int i=0;i<len;i++)
            ans[i] = stack.pop();
        return ans;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
