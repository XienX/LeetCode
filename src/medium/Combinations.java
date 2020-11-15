package medium;
/*给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
示例:
输入: n = 4, k = 2
输出:[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /*List<List<Integer>> lists = new ArrayList<>();
    int n,k;

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nList = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        this.n = n;
        this.k = k;

        for (int i = 1;i<=n;i++)
            nList.add(i);

        addList(newList, nList);

        return  lists;
    }

    public void addList (List list,List nList) {
        if (list.size() == k) {
            lists.add(list);
            return;
        }

        int size = nList.size();
        for (int i = 0;i<size;i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add((Integer) nList.get(0));
            nList.remove(0);
            List<Integer> newNList = new ArrayList<>(nList);
            addList(newList, newNList);
        }
    }*/


    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
