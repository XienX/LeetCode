
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        ListNode result = new ListNode();
        ListNode p = result;

        for(ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {
            ListNode pollNode = pq.poll();
            if (pollNode.next != null) {
                pq.add(pollNode.next);
            }
            p.next = pollNode;
            p = p.next;
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
