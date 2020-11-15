package medium;
/*给出集合[1,2,3,…,n]，其所有元素共有n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定n 和k，返回第k个排列。

说明：
给定 n的范围是 [1, 9]。
给定 k的范围是[1, n!]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {
    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int index;
        char c;

        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i)
            factorial[i] = factorial[i - 1] * i;

        for (int i = 1;i<=n;i++)
            list.add(i);

        for (k--;n>0;n--){
            index = k/factorial[n-1];
            k = k%factorial[n-1];
            s.append(list.get(index));
            list.remove(index);
        }

        return String.valueOf(s);
    }
}
