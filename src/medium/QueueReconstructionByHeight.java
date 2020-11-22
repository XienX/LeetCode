package medium;
/*406. 根据身高重建队列
假设有打乱顺序的一群人站成一个队列。每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。编写一个算法来重建这个队列。

注意：总人数少于1100人。

示例
输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
//    public int[][] reconstructQueue(int[][] people) { // 超时
//        List<int[]> list = new LinkedList<>(Arrays.asList(people));
//        int[] node;
//        int i = 0, j, nodeK;
//
//        while (i<people.length) {
//            node = list.get(i);
//
//            // 获取当前k
//            nodeK = 0;
//            for (j=0;j<i;j++)
//                if (list.get(j)[0] >= node[0])
//                    nodeK++;
//
//            // 不满足，移至临时正确位置
//            if (nodeK < node[1]) {
//                while (nodeK < node[1])
//                    if (list.get(++j)[0] >= node[0])
//                        nodeK++;
//
//                list.remove(node);
//                list.add(j, node);
//            }
//            else if (nodeK > node[1]) {
//                while (nodeK > node[1])
//                    if (list.get(--j)[0] >= node[0])
//                        nodeK--;
//
//                list.remove(node);
//                list.add(j, node);
//                i = ++j;
//            }
//            else i++;
//        }
//
//        return list.toArray(new int[0][]);
//    }

    public int[][] reconstructQueue(int[][] people) { // O(n2)
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode-sol/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
