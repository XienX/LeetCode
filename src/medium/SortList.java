package medium;
/*148. 排序链表
给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
进阶：你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

示例 1：
输入：head = [4,2,1,3]
输出：[1,2,3,4]

示例 2：
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]

示例 3：
输入：head = []
输出：[]

提示：
链表中节点的数目在范围[0, 5 * 104]内
-105<= Node.val <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(0, head);
        ListNode prev, curr, next, head1, head2;
        ListNode node = head;
        int i, j, length = 0;

        while (node != null) {
            length++;
            node = node.next;
        }

        for (i = 1; i < length; i <<= 1) {
            prev = newHead;
            curr = newHead.next;

            while (curr != null) {
                head1 = curr;
                for (j = 1; j < i && curr.next != null; j++)
                    curr = curr.next;

                head2 = curr.next;
                curr.next = null;
                curr = head2;

                for (j = 1; j < i && curr != null && curr.next != null; j++)
                    curr = curr.next;

                next = null;

                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }

                prev.next = merge(head1, head2);

                while (prev.next != null)
                    prev = prev.next;

                curr = next;
            }
        }

        return newHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null)
            temp.next = head1;
        else if (head2 != null)
            temp.next = head2;

        return newHead.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
