
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 新增虚拟头节点，处理头节点大于x问题
        ListNode result = new ListNode(Integer.MIN_VALUE);
        result.next = head;
        ListNode lessPoint = result;

        // 找到最后一个小于x的节点，后续不满足条件的节点都插入此节点之后
        while (head != null) {
            if (head.val >= x) {
                break;
            }
            lessPoint = head;
            head = head.next;
        }

        // 所有元素都小于x，直接返回
        if (head == null) {
            return result.next;
        }

        // 寻找小于x的节点，并插入到lessPoint节点之后
        while (head.next != null) {
            if (head.next.val >= x) {
                head = head.next;
                continue;
            }

            // 删除此节点
            ListNode next = head.next;
            head.next = next.next;

            // 插入至less节点
            next.next = lessPoint.next;
            lessPoint.next = next;
            lessPoint = next;
        }

        return result.next;
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