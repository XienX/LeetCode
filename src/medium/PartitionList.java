package medium;
/*86. 分隔链表
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。

示例：
输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode insertNode = newHead;
        while (insertNode.next != null && insertNode.next.val < x)
            insertNode = insertNode.next;

        if (insertNode.next == null)
            return head;

        ListNode node = insertNode.next;
        while (node.next != null) {
            if (node.next.val < x) {
                ListNode tem = node.next;
                node.next = tem.next;
                tem.next = insertNode.next;
                insertNode.next = tem;
                insertNode = tem;
            }
            else
                node = node.next;
        }

        return newHead.next;
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
