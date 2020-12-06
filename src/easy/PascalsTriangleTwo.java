package easy;
/*119. 杨辉三角 II
给定一个非负索引k，其中 k≤33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 3
输出: [1,3,3,1]

进阶：
你可以优化你的算法到 O(k) 空间复杂度吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleTwo {
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> ans = new ArrayList<>();
//        ans.add(1);
//
//        for (int i=1;i<=rowIndex;i++) {
//            List<Integer> tem = new ArrayList<>();
//            tem.add(1);
//
//            for (int j=1;j<i;j++)
//                tem.add(ans.get(j-1)+ans.get((j)));
//
//            tem.add(1);
//            ans = tem;
//        }
//
//        return ans;
//    }

    public List<Integer> getRow(int rowIndex) { // 找规律
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        int numRows = rowIndex + 1;
        for (int index = 0; index < numRows; index++){
            if (index == 0){
                res.add(1);
            }else {
                long eachValOfRow = (long) res.get(index - 1) * (long) (numRows - index) / index;
                res.add((int) eachValOfRow);
            }
        }
        return res;
    }

    /*作者：jun-mo-xiao-21
    链接：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/zhao-gui-lu-qiu-jie-yang-hui-san-jiao-mei-yi-xing-/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
