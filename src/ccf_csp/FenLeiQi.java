package ccf_csp;
/*202006-1 线性分类器
【题目描述】
考虑一个简单的二分类问题——将二维平面上的点分为A和B两类。
训练数据包含 n个点，其中第i个点（1≤i≤n）可以表示为一个三元组 (xi,yi,typei), 即该点的横坐标、纵坐标和类别。
在二维平面上，任意一条直线可以表示为 θ0 + θ1x+ θ2y = 0 的形式，即由 θ0、θ1 和 θ2 三个参数确定该直线，且满足θ1、θ2不同时为0。
基于这n个已知类别的点，我们想要在平面上找到一条直线作为一个线性分类器。
具体来说，这条线要把训练数据中的A、B两类点完美分隔开来，即一侧只有A类点、另一侧只有B类点。
这样，对于任意一个的未知类别的点，我们就可以根据它是位于直线的哪一侧来预测它的类别了。
在本题中我们仅需要处理 m个如下查询：给定一条直线，判断它是否能将训练数据中的A、B 两类点完美分开。

【输入格式】
从标准输入读入数据。 输入共 n + m + 1 行。
第一行包含用空格分隔的两个正整数 n 和 m，分别表示点和查询的个数。
第二行到第n+1行依次输入n个点的信息。第i+1行（1≤i≤n）包含用空格分隔的三项xi、yi和typei，分别表示第i个点的横、纵坐标和类别，其中坐标为整数、类别为一个大写英文字母A或B。
第 n + 2 行到第 n + m + 1 行依次输 m个查询。第 j + n + 1 行（1≤ j≤m）包含用空格分隔的三个整数 θ0、θ1 和 θ2，表示第j个查询中给定直线的三个参数。

【输出格式】
输出到标准输出。输出共m行，每行输出一个字符串。第j行（1 ≤ j ≤ m）输出的字符串对应第j个查询的结果：如果给定直线可以完 美分隔A、B两类点，则输出Yes；否则输出No。

【样例 1 输入】
9 3
1 1 A
1 0 A
1 -1 A
2 2 B
2 3 B
0 1 A
3 1 B
1 3 B
2 0 A
0 2 -3
-3 0 2
-3 1 1
【样例 1 输出】
No
No
Yes
【样例 1 解释】
只有第3个查询给出的直线能将A、B 两类点完美分隔

【子任务】
• 输入数据保证不存在恰好落在给定直线上的点；
• 0 < n ≤ 10^3、0 < m ≤ 20，且A、B两类点的数量均不为0；
• 所有点的坐标和给定直线的三个参数均为整数，且绝对值 ≤ 10^6；
• 任意两个点的坐标不完全相同。*/

import java.util.Scanner;

public class FenLeiQi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 点个数
		int m = sc.nextInt(); // 查询个数
		int[][] points = new int[n][3]; // 点
		int[][] lines = new int[m][3]; // 线
		int i, j;
		
		for(i=0;i<n;i++) {
			int[] temp = new int[] {sc.nextInt(), sc.nextInt(), sc.next().charAt(0)-'A'};
			points[i] = temp;
		}
		for(i=0;i<m;i++) {
			int[] temp = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
			lines[i] = temp;
		}
		
		for(i=0;i<m;i++) {
			int moreThanZero;
			if(lines[i][0]+lines[i][1]*points[0][0]+lines[i][2]*points[0][1] > 0)
				moreThanZero = points[0][2];
			else
				moreThanZero = points[0][2]==1 ? 0 : 1;
			
			for(j=1;j<n;j++) {
				if((lines[i][0]+lines[i][1]*points[j][0]+lines[i][2]*points[j][1]>0 && points[j][2]!=moreThanZero) || (lines[i][0]+lines[i][1]*points[j][0]+lines[i][2]*points[j][1]<0 && points[j][2]==moreThanZero)) {
					System.out.println("No");
					break;
				}
			}
			
			if(j == n)
				System.out.println("Yes");
		}
	}
}
