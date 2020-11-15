package easy;
/*1122. 数组的相对排序
给你两个数组，arr1 和 arr2，
arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

示例：
输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]

提示：
arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-sort-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


import java.util.*;

public class RelativeSortArray {
//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        int[] ans = new int[arr1.length];
//        int i, j, k = 0;
//
//        for (i=0;i<arr2.length;i++)
//            for (j=0;j<arr1.length;j++)
//                if (arr1[j] == arr2[i]) {
//                    ans[k++] = arr2[i];
//                    arr1[j] = 1001;
//                }
//
//        Arrays.sort(arr1);
//        for (i=0;k<arr1.length;k++)
//            ans[k] = arr1[i++];
//
//        return ans;
//    }

//    public int[] relativeSortArray(int[] arr1, int[] arr2) { //自定义排序
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        for(int num : arr1) list.add(num);
//        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
//        Collections.sort(list, (x, y) -> {
//            if(map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
//            return x - y;
//        });
//        for(int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
//        return arr1;
//    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) { //计数排序
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/relative-sort-array/solution/shu-zu-de-xiang-dui-pai-xu-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
