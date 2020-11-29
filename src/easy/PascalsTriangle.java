package easy;
/*118. 杨辉三角
给定一个非负整数numRows，生成杨辉三角的前numRows行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0)
            return list;

        list.add(Collections.singletonList(1));

        for (int i=1;i<numRows;i++) {
            List<Integer> last = list.get(i-1);
            List<Integer> line = new ArrayList<>();
            line.add(1);
            for (int j=1;j<i;j++)
                line.add(last.get(j-1)+last.get((j)));
            line.add(1);
            list.add(line);
        }

        return list;
    }
}
