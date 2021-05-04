package bishi;
/*查找二叉搜索树的叶子节点
给一个二叉查找树（Binary Search Tree）的前序遍历结果数组，打印出所有的叶子节点。

输入描述:
输入为二叉查找树的前序遍历结果数组，元素之间用空格分隔：
9 8 7 10

输出描述:
所有的叶子节点元素，用空格分隔

解释：因为二叉搜索树的表示为:
       9
   8    10
7

输出的叶子节点为: 7 10

输入例子1:
9 8 7 10

输出例子1:
7 10*/

import java.util.Scanner;

public class xiapi3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(parse(scanner.nextLine()));
    }

    public static String parse(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        int len = ss.length;
        int[] node = new int[len];

        for (int i=0;i<len;i++)
            node[i] = Integer.parseInt(ss[i]);

        for (int i=1;i<len-1;i++) {
            if (node[i] < node[i+1]) {
                sb.append(node[i]);
                sb.append(" ");
            }
        }

        sb.append(node[len - 1]);
        return sb.toString();
    }
}
