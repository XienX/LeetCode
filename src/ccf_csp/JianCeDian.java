package ccf_csp;
/*202009-1 称检测点查询
问题描述
某市设有 n 个核酸检测点，编号从 1 到 n，其中 i 号检测点的位置可以表示为一个平面整数坐标。
为方便预约核酸检测，请根据市民所在位置，查询距其最近的三个检测点。
多个检测点距离相同时，编号较小的视为更近。

输入格式
输入共 n+1 行。
第一行包含用空格分隔的三个整数 n、X 和 Y，表示检测点总数和市民所在位置。
第二行到第 n+1 行依次输入 n 个检测点的坐标。第 i+1 行包含用空格分隔的两个整数，表示 i 号检测点所在位置。

输出格式
输出共三行，按距离从近到远，依次输出距离该市民最近的三个检测点编号。

样例输入1
3 2 2
2 2
2 3
2 4

样例输出1
1
2
3

样例输入2
5 0 1
-1 0
0 0
1 0
0 2
-1 2

样例输出2
2
4
1

评测用例规模与约定
全部的测试点满足 3<=n<=200，所有坐标均为整数且绝对值不超过 1000。*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JianCeDian {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int[][] nums = new int[len][3];
		int i;
		for(i=0;i<len;i++)
			nums[i] = new int[] {sc.nextInt(),sc.nextInt(),i+1};
		
		
		Arrays.sort(nums, Comparator.comparingInt(num -> (num[0]-X)*(num[0]-X)+(num[1]-Y)*(num[1]-Y)));
		
		for(i=0;i<3;i++)
			System.out.println(nums[i][2]);
	}
}


/*以下必须全部满足才能提交：
没有使用package语句来定义包的信息。
主类名称是Main，主类的定义是public class Main。运行的入口是主类Main中的main函数，定义为public static void main(String[] args)。
从标准输入(System.in)中读入数据的（使用Scanner等类来处理System.in的输入视为满足条件），结果是输出到标准输出(System.out)的。*/
