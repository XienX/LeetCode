package medium;
/*2. 两数相加
给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode ans = l1;
        int add = 0, tem;

        while (true) {
            tem = l1.val + l2.val + add;
            if (tem > 9) {
                l1.val = tem % 10;
                add = 1;
            }
            else {
                l1.val = tem;
                add = 0;
            }

            if (l1.next == null) {
                l1.next = l2.next;

                while (add == 1) {
                    if (l1.next == null) {
                        l1.next = new ListNode(1);
                        break;
                    }

                    l1 = l1.next;
                    if (l1.val == 9)
                        l1.val = 0;
                    else {
                        l1.val++;
                        add = 0;
                    }
                }

                break;
            }
            if (l2.next == null) {
                while (add == 1) {
                    if (l1.next == null) {
                        l1.next = new ListNode(1);
                        break;
                    }

                    l1 = l1.next;
                    if (l1.val == 9)
                        l1.val = 0;
                    else {
                        l1.val++;
                        add = 0;
                    }
                }

                break;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return ans;
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