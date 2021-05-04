package bishi;
/*建物流中转站
Shopee物流会有很多个中转站。在选址的过程中，会选择离用户最近的地方建一个物流中转站。
假设给你一个二维平面网格，每个格子是房子则为1，或者是空地则为0。
找到一个空地修建一个物流中转站，使得这个物流中转站到所有的房子的距离之和最小。
能修建，则返回最小的距离和。如果无法修建，则返回 -1。

若范围限制在100*100以内的网格，如何计算出最小的距离和？
当平面网格非常大的情况下，如何避免不必要的计算？

输入描述:
4
0 1 1 0
1 1 0 1
0 0 1 0
0 0 0 0
先输入方阵阶数，然后逐行输入房子和空地的数据，以空格分隔。

输出描述:
8
能修建，则返回最小的距离和。如果无法修建，则返回 -1。

输入例子1:
4
0 1 1 0
1 1 0 1
0 0 1 0
0 0 0 0
输出例子1:
8

输入例子2:
4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
输出例子2:
-1*/

import java.util.Scanner;

public class xiapi8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        int ans = Integer.MAX_VALUE;

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (arr[i][j] == 0) {
                    ans = Math.min(ans, distance(arr, n, i, j));
                }
            }
        }

        System.out.println(ans == Integer.MAX_VALUE?-1:ans);
    }

    private static int distance(int[][] arr, int n, int x, int y) {
        int total = 0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (arr[i][j] == 1) {
                    total += Math.abs(x-i) + Math.abs(y-j);
                }
            }
        }

        return total;
    }
}
