package ccf_csp;
/*201903-1 小中大
题目
老师给了你 n 个整数组成的测量数据，保证有序（可能为升序或降序），可能存在重复的数据。
请统计出这组测量数据中的最大值、中位数以及最小值，并按照从大到小的顺序输出这三个数。

输入
从标准输入读入数据。
第一行输入一个整数 n，在第二行中存在 n 个有序的整数，表示测量数据，可能为升序或降序排列，可能存在连续多个整数相等，整数与整数之间使用空格隔开。

输出
输出到标准输出。
包含一行，包括最大值、中位数以及最小值共三个数，并按照从大到小的顺序输出。数据与数据之间使用空格隔开。
对于整数请直接输出整数，对于可能出现的分数，请输出四舍五入保留 1 位小数的结果。

输入样例1
3
-1 2 4
输出样例1
4 2 -1
样例解释1
4 为最大值，2 为中位数，−1 为最小值。

输入样例2
4
-2 -1 3 4
输出样例2
4 1 -2
样例解释2
4 为最大值，(−1 + 3) ÷ 2=1 为中位数，−2 为最小值。*/

import java.util.Scanner;

public class XiaoZhongDa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		
		for(int i=0;i<n;i++)
			nums[i] = sc.nextInt();
		
		if (n%2==1)
			System.out.println(Math.max(nums[0], nums[n-1]) + " " + nums[n/2] + " " + Math.min(nums[0], nums[n-1]));
		else if ((nums[n/2-1]+nums[n/2-1])%2==0)
			System.out.println(Math.max(nums[0], nums[n-1]) + " " + (nums[n/2-1]+nums[n/2])/2 + " " + Math.min(nums[0], nums[n-1]));
		else
			System.out.println(Math.max(nums[0], nums[n-1]) + " " + String.format("%.1f", (nums[n/2-1]+nums[n/2])/2.0) + " " + Math.min(nums[0], nums[n-1]));
			// System.out.println(Math.max(nums[0], nums[n-1]) + " " + (nums[n/2-1]+nums[n/2])/2 + ".5 " + Math.min(nums[0], nums[n-1]));
	}
}
