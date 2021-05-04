package bishi;
/*找出数组所有可能的子集
详细描述
给出一个整数数组 nums ，数组中的元素互不相同 。返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。请按字典顺序返回解集。

输入输出描述
输入描述
输入一个含有不同元素的整型数组

输出描述
按字典顺序输出所有可能的幂集

输入输出示例
示例1
输入
[1,2]
输出
[[],[1],[1,2],[2]]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class xiapi12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        str = str.substring(1, str.length()-1);
        String[] s = str.split(",");
        int len = s.length;

        int[] array = new int[len];
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i=0;i<len;i++)
            array[i] = Integer.parseInt(s[i]);
        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        dfs(array, lists, list, 0);
        lists.sort((o1, o2) -> {
            int len1 = o1.size();
            if (len1 == 0)
                return -1;
            int len2 = o2.size();
            if (len2 == 0)
                return 1;

            int min = Math.min(len1, len2);
            for (int i=0;i<min;i++) {
                if (o1.get(i) != o2.get(i))
                    return o1.get(i) - o2.get(i);
            }

            return len1 - len2;
        });

        for (List<Integer> list1 : lists) {
            sb.append("[");
            if (list1.isEmpty()) {
                sb.append("],");
            }
            else {
                for (int val : list1) {
                    sb.append(val).append(",");
                }

                sb.deleteCharAt(sb.length()-1).append("],");
            }
        }

        sb.deleteCharAt(sb.length()-1).append("]");
        System.out.println(sb.toString());
    }

    private static void dfs(int[] array, List<List<Integer>> lists, List<Integer> list, int k) {
        if (k == array.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        dfs(array, lists, list, k+1);

        list.add(array[k]);
        dfs(array, lists, list, k+1);

        list.remove(list.size()-1);
    }
}
