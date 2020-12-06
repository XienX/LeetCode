package ccf_csp;
/*201912-1 报数
甲乙丙丁决定玩一个报数的游戏来打发时间。游戏规则为四个人从1开始轮流进行报数，但如果需要报出的数是7的倍数或含有数字7直接跳过。
此外大家约定，在总共报出了n个数后(不计入被跳过的数)游戏结束。现在需要你来帮帮忙统计，游戏过程中每个人各自跳过了几次。

输入格式：
输入仅一行，包含一个正整数n，表示报出了多少个数后游戏结束

输出格式：
输出到标准输出
输出共四行，每行一个整数，一次表示甲乙丙丁四人在游戏过程中跳过的次数。

样例输入：
20
样例输出:
2
1
1
0*/

import java.util.Scanner;

public class BaoShu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ans = new int[4];
		
		for(int i=1;i<=n;i++) 
			if (i%7==0 || String.valueOf(i).contains("7")) {
				n++;
				ans[(i-1)%4]++;
			}
		
		System.out.println(ans[0]+"\n"+ans[1]+"\n"+ans[2]+"\n"+ans[3]);
	}
}
