
//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultListNode = new ListNode();
        ListNode resultPointer = resultListNode;

        while (list1 != null && list2 != null) {
            // result指向当前最小节点
            if (list1.val <= list2.val) {
                resultPointer.next = list1;
                list1 = list1.next;
            } else {
                resultPointer.next = list2;
                list2 = list2.next;
            }
            resultPointer = resultPointer.next;
        }

        // 剩余节点直接置于末尾
        resultPointer.next = list1 != null ? list1 : list2;

        return resultListNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
