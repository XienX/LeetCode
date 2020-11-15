package medium;
/*402. 移掉K位数字
给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:
num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。

示例 1 :
输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。

示例 2 :
输入: num = "10200", k = 1
输出: "200"
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。

示例 3 :
输入: num = "10", k = 2
输出: "0"
解释: 从原数字移除所有的数字，剩余为空就是0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-k-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RemoveKDigits {
//    public String removeKdigits(String num, int k) { //超时，O(nk)
//        int len = num.length();
//
//        if (k == len)
//            return "0";
//
//        List<Character> list = new LinkedList<>();
//        int i;
//
//        for (i=0;i<len;i++)
//            list.add(num.charAt(i));
//
//        for (;k>0;k--) {
//            i=0;
//
//            while (i < len-1) {
//                if (list.get(i) > list.get(i+1)) {
//                    list.remove(i);
//                    break;
//                }
//
//                i++;
//            }
//
//            if (i == len-1)
//                list.remove(i);
//
//            len--;
//        }
//
//        while (!list.isEmpty() && list.get(0) == '0')
//            list.remove(0);
//
//        if (list.isEmpty())
//            return "0";
//
//        StringBuilder s = new StringBuilder();
//        for (Character character : list)
//            s.append(character);
//
//        return String.valueOf(s);
//    }

    public String removeKdigits(String num, int k) { //O(n)
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
