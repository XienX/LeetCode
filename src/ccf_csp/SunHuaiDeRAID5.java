package ccf_csp;
/*201903-3 损坏的RAID5 过80% 运行超时
完整题目 https://blog.csdn.net/wingrez/article/details/88676430

输入
从标准输入读入数据。
输入的第一行包含三个正整数 n（n ≥ 2）、s 和 l，表示阵列中硬盘的数目、阵列的条带大小（单位：块）和现存的硬盘数目。
接下来的 l 行，每行包含由空格分开的一个非负整数和一个不含空格，长度相等且为 8 的整数倍的字符串。该整数为从零开始的这个硬盘的顺序号。
该字符串仅包含数字 0～9 和大写字母 A～F，每两个字符构成一个 16 进制数字，表示一个字节的硬盘内容。
输入硬盘集合保证：向该硬盘集合补充若干适当内容的硬盘，即可使它们恰好组成一个合法的、数据没有差错的 RAID5 阵列。
输入数据保证：阵列的条带大小能整除每块硬盘的大小。
接下来的一行包含一个正整数 m，表示读取操作的数目。
接下来的 m 行，每行表示一个读取操作，包括一个非负整数 bi，表示要读取的块的编号。

输出
输出到标准输出。输出包含 m 行。
对于每一个读操作，产生一行输出。如果该读操作能进行，或能由现存的硬盘数据推算出来，则输出长度为 8 的字符串，该字符串仅包含数字 0～9 和大写字母 A～F，
每两个字符构成一个 16 进制数字，表示读取到的数据块的内容。如果该读操作由于下列情形之一无法进行，则输出一个减号（-）：
• 阵列不完整，且被读取的块所在的硬盘缺失，且该数据无法由现存的硬盘数据推算出来；
• 指定的块超出阵列总长度。

输入样例1
2 1 2
0 000102030405060710111213141516172021222324252627
1 000102030405060710111213141516172021222324252627
2
0
1
输出样例1
00010203
04050607
样例解释1
由题意，给出的 RAID5 阵列由两块盘组成，条带大小是 1 块（4 字节）长，并给出了两块盘的数据。
注意到当 RAID5 的阵列中只有两块盘时，有 p = a1，因此两块盘中数据是相同的，都是 RAID 阵列中的内容，因此可以任取一块盘进行读取操作。

输入样例2
3 2 2
0 000102030405060710111213141516172021222324252627
1 A0A1A2A3A4A5A6A7B0B1B2B3B4B5B6B7C0C1C2C3C4C5C6C7
2
2
5
输出样例2
A0A1A2A3
A0A0A0A0

样例解释2
由题意，给出的 RAID5 阵列由三块盘组成，条带大小是 2 块（8 字节）长，并给出了 0 号、1 号盘的数据，缺失 2 号盘，因此整个 RAID5 阵列的布局情况如图所示。
图中，用虚线隔开的长方形表示一个块，连续的两个长方形组成的正方形表示一个条带。当读取编号为 2 的块时，该数据位于编号为 1 的盘的编号为 0 的块，因此结果是 A0A1A2A3；
当读取编号为 5 的块时，该数据位于编号为 2 的盘的编号为 3 的块，该盘缺失，因此需要用其余两块盘相应位置处的数据进行异或运算得到 14151617 ⊕B4B5B6B7 = A0A0A0A0。*/

import java.util.Scanner;

public class SunHuaiDeRAID5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int l = sc.nextInt();
		String[] S = new String[n];
		
		for(int i=0;i<l;i++)
			S[sc.nextInt()] = sc.next();
		
		int m = sc.nextInt();
		for(int i=0;i<m;i++) {
			int k = sc.nextInt();
			int startS = k/(s*(n-1));
			int start = (startS*s + k%(s*(n-1))%s)<<3;
			int num = ((n-startS%n) + k%(s*(n-1))/s) % n;
			
			if(S[num]!=null && S[num].length()>start) 
				System.out.println(S[num].substring(start, start+8));
			else {
				int[] ans = new int[4];
				int j;

				for(j=0;j<n;j++) 
					if(j!=num) {
						if(S[j]==null || S[j].length()<start)
							break;
						
						for(int a=0;a<4;a++) 
							ans[a] ^= Integer.parseInt(S[j].substring(start+(a<<1), start+(a<<1)+2), 16);
					}
				
				if(j<n)
					System.out.println("-");
				else 
					System.out.println((Integer.toHexString(ans[0])+Integer.toHexString(ans[1])+Integer.toHexString(ans[2])+Integer.toHexString(ans[3])).toUpperCase());
			}
		}
	}
}
