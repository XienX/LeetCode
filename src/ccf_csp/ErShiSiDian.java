package ccf_csp;
/*201903-2 二十四点
题目
定义每一个游戏由 4 个从 1-9 的数字和 3 个四则运算符组成，保证四则运算符将数字两两隔开，不存在括号和其他字符，运算顺序按照四则运算顺序进行。
其中加法用符号 + 表示，减法用符号 - 表示，乘法用小写字母 x 表示，除法用符号 / 表示。在游戏里除法为整除，例如 2 / 3 = 0，3 / 2 = 1, 4 / 2 = 2。
老师给了你 n 个游戏的解，请你编写程序验证每个游戏的结果是否为 24 。

输入
从标准输入读入数据。第一行输入一个整数 n，从第 2 行开始到第 n + 1 行中，每一行包含一个长度为 7的字符串，为上述的 24 点游戏，保证数据格式合法。

输出
输出到标准输出。包含 n 行，对于每一个游戏，如果其结果为 24 则输出字符串 Yes，否则输出字符串 No。

输入样例
10
9+3+4x3
5+4x5x5
7-9-9+8
5x6/5x4
3+5+7+9
1x1+9-9
1x9-5/9
8/5+6x9
6x7-3x6
6x4+4/5

输出样例
Yes
No
No
Yes
Yes
No
No
No
Yes
Yes

样例解释
9+3+4 × 3 = 24
5+4 × 5 × 5 = 105
7 − 9 − 9+8= −3
5 × 6/5 × 4 = 24
3 + 5 + 7 + 9 = 24
1 × 1+9 − 9=1
1 × 9 − 5/9 = 9
8/5 + 6 × 9 = 55
6 × 7 − 3 × 6 = 24
6 × 4 + 4/5 = 24*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ErShiSiDian {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			Deque<String> deque = new LinkedList<>();
			String s = sc.next();
			for(int j=0;j<7;j++) {
				if(j%2 == 0)
					deque.offerLast(s.substring(j, j+1));
				else {
					if(s.charAt(j) == 'x') 
						deque.offerLast(String.valueOf(Integer.parseInt(deque.pollLast()) * Integer.parseInt(s.substring(++j, j+1))));
					else if(s.charAt(j) == '/') 
						deque.offerLast(String.valueOf(Integer.parseInt(deque.pollLast()) / Integer.parseInt(s.substring(++j, j+1))));
					else 
						deque.offerLast(s.substring(j, j+1));
				}
			}
			
			int ans = Integer.parseInt(deque.pollFirst());
			while(!deque.isEmpty()) 
				if("+".equals(deque.pollFirst()))
					ans += Integer.parseInt(deque.pollFirst());
				else
					ans -= Integer.parseInt(deque.pollFirst());
			
			if(ans == 24)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
