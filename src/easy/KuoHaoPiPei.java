package easy;
/*
定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.ArrayDeque;
import java.util.Deque;

public class KuoHaoPiPei {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        int i;
        char c;

        if (len % 2 == 1) {
            return false;
        }
        for (i=0;i<len;i++) {
            c = s.charAt(i);
            switch (c) {
                case '(': case '[': case '{':
                    stack.addFirst(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.removeFirst()!='(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.removeFirst()!='[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.removeFirst()!='{')
                        return false;
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
