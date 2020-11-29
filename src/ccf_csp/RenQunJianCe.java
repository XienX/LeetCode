package ccf_csp;
/*202009-2 风险人群筛查
问题描述
想要找出经过高危区域的居民，分析位置记录是一种简单有效的方法。
具体来说，一位居民的位置记录包含 t 个平面坐标。
高危区域则可以抽象为一个矩形区域（含边界），左下角和右上角的坐标分别为 (xl,yd) 和 (xr,yu)，
满足 xl<xr 且 yd<yu。
考虑某位居民的位置记录，如果其中某个坐标位于矩形内（含边界），则说明该居民经过高危区域；
进一步地，如果其中连续 k 个或更多坐标均位于矩形内（含边界），则认为该居民曾在高危区域逗留。
需要注意的是，判定经过和逗留时我们只关心位置记录中的 t 个坐标，而无需考虑该居民在时刻之间位于何处。
给定高危区域的范围和 n 位居民过去 t 个时刻的位置记录，试统计其中经过高危区域的人数和曾在高危区域逗留的人数。

输入格式
输入共 n+1 行。
第一行包含用空格分隔的七个整数 n、k、t、xl、yd、xr 和 yu，含义如上文所述。
接下来 n 行，每行包含用空格分隔的 2t 个整数，按顺序表示一位居民过去 t 个时刻的位置记录。

输出格式
输出共两行，每行一个整数，分别表示经过高危区域的人数和曾在高危区域逗留的人数。

样例输入1
5 2 6 20 40 100 80
100 80 100 80 100 80 100 80 100 80 100 80
60 50 60 46 60 42 60 38 60 34 60 30
10 60 14 62 18 66 22 74 26 86 30 100
90 31 94 35 98 39 102 43 106 47 110 51
0 20 4 20 8 20 12 20 16 20 20 20

样例输出1
3
2

样例1说明
前三条位置记录经过了高危区域；但第三条位置记录只有一个时刻位于高危区域内，不满足逗留条件。

样例输入2
1 3 8 0 0 10 10
-1 -1 0 0 0 0 -1 -1 0 0 -1 -1 0 0 0 0

样例输出2
1
0

样例2说明
该位置记录经过了高危区域，但最多只有连续两个时刻位于其中，不满足逗留条件。

评测用例规模与约定
全部的测试点满足 1<=n<=20，1<=k<=t<=10^3，所有坐标均为整数且绝对值不超过 10^6。*/

import java.util.Scanner;

public class RenQunJianCe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int t = sc.nextInt();
		int xl = sc.nextInt();
		int yd = sc.nextInt();
		int xr = sc.nextInt();
		int yu = sc.nextInt();
		int[][][] points = new int[n][t][2];
		int across= 0, stay = 0;
		int i, j, p;
		Boolean flag;
		
		for(i=0;i<n;i++)
			for(j=0;j<t;j++)
				points[i][j] = new int[] {sc.nextInt(), sc.nextInt()};
		
		for(i=0;i<n;i++) {
			flag = false;
			for(p=0,j=0;j<t;j++) {
				if (xl<=points[i][j][0] && points[i][j][0]<=xr && yd<=points[i][j][1] && points[i][j][1]<=yu) {
					flag = true;
					p++;
					
					if (p >= k) {
						stay++;
						break;
					}
				}
				else p = 0;
			}
			
			if (flag) across++;
		}
		
		System.out.println(across);
		System.out.println(stay);
	}
}
