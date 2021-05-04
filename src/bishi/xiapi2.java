package bishi;
/*字符串算术运算
给定一个字符串式子，返回它的计算结果。算术规则为: k*[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
注意 k 保证为正整数。e.g. s = "3*[a2*[c]]", 返回 “accaccacc”

输入例子1:
"3*[a2*[c]]"

输出例子1:
"accaccacc"*/

import java.util.Deque;
import java.util.LinkedList;

public class xiapi2 {
    public String computeString (String str) {
        Deque<Character> stack = new LinkedList<>();
        int len = str.length();

        for (int i=0;i<len;i++) {
            char tem = str.charAt(i);
            if (tem == ']') {
                StringBuilder sb = new StringBuilder();

                while (true) {
                    char t = stack.removeLast();
                    if (t == '[') {
                        break;
                    }
                    else if (t == '*') {
                        int n = stack.removeLast() - '0';
                        int k = 0;

                        while (!stack.isEmpty()) {
                            char tt = stack.removeLast();
                            if (Character.isDigit(tt)) {
                                n += 10 * ++k * (tt - '0');
                            }
                            else {
                                stack.offerLast(tt);
                                break;
                            }
                        }

                        String now = sb.toString();

                        for (int j=1;j<n;j++)
                            sb.append(now);
                    }
                    else {
                        sb.append(t);
                    }
                }

                for (int j=sb.length()-1;j>=0;j--)
                    stack.offerLast(sb.charAt(j));

            }
            else {
                stack.offerLast(tem);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            char t = stack.removeLast();
            if (t == '*') {
                int n = stack.removeLast() - '0';
                int k = 0;

                while (!stack.isEmpty()) {
                    char tt = stack.removeLast();
                    if (Character.isDigit(tt)) {
                        n += 10 * ++k * (tt - '0');
                    }
                    else {
                        stack.offerLast(tt);
                        break;
                    }
                }

                String now = sb.toString();

                for (int j=1;j<n;j++)
                    sb.append(now);
            }
            else {
                sb.append(t);
            }
        }

        return sb.reverse().toString();
    }
}
