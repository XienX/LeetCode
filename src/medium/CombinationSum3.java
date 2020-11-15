package medium;
/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
说明：
所有数字都是正整数。
解集不能包含重复的组合。 

示例
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, k, n);
        return ans;
    }

    public void dfs(int cur, int k, int target) {
        // 剪枝
        if (cur>=candidates.length || target<=0 || k<=0) {
            return;
        }

        temp.add(candidates[cur]);
        // 记录合法的答案
        if (candidates[cur] == target && k==1) {
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }

        // 考虑选择当前位置
        dfs(cur+1, k-1, target-candidates[cur]);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, k, target);
    }
}
