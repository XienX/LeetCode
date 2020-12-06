package ccf_csp;
/*202006-2 稀疏向量
题目
对于一个 n 维整数向量 v ∈ Zn，其在第 index 个维度上的取值记作 vindex。这里我们约定 index 的取值从 1 开始，即 v = (v1, v2, · · · , vn)。
下面介绍一种向量的稀疏表示方法。如果 v 仅在少量维度上的取值不为 0，则称其为稀疏向量。
例如当 n = 10 时，v = (0, 0, 0, 5, 0, 0, -3, 0, 0, 1) 就是一个稀疏向量。
由于稀疏向量的非零值较少，我们可以通过仅存储非零值的方式来节省空间。具体来说，每个非零值都可以用一个 (index, value) 对来表示，
即该向量在第 index 个维度上的取值 vindex = value ≠ 0。在上面的例子中，v 就可以表示为 [(4, 5), (7, -3), (10, 1)]。
接下来给出这种稀疏表示一般化的定义。
• 对于任意一个 n 维整数向量 v ∈ Zn，如果其在且仅在 a 个维度上取值不为 0，则可以唯一表示为：
[(index1, value1), (index2, value2), · · · , (indexa, valuea)]
• 其中所有的 index 均为整数且满足：1 ≤ index1 < index2 < · · · < indexa ≤ n
• valuei 表示向量 v 在对应维度 indexi 上的非零值。给出两个 n 维整数向量 u, v ∈ Zn 的稀疏表示，试计算它们的内积。u · v = ∑ ui · vi

输入
从标准输入读入数据。
输入的第一行包含用空格分隔的三个正整数 n、a 和 b，其中 n 表示向量 u、v 的维数，a 和 b 分别表示两个向量所含非零值的个数。
第二行到第 a + 1 行输入向量 u 的稀疏表示。第 i + 1 行（1 ≤ i ≤ a）包含用空格分隔的两个整数 indexi 和 valuei，表示 uindexi = valuei ≠ 0。
 第 a + 2 行到第 a + b + 1 行输入向量 v 的稀疏表示。第 j + a + 1 行（1 ≤ j ≤ b）包含用空格分隔的两个整数 indexj 和 valuej，表示 vindex j = value j ≠ 0

输出
输出到标准输出。输出一个整数，表示向量 u 和 v 的内积 u · v。

输入样例
10 3 4
4 5
7 -3
10 1
1 10
4 20
5 30
7 40

输出样例
-20

样例解释
u = (0, 0, 0, 5, 0, 0, -3, 0, 0, 1)
v = (10, 0, 0, 20, 30, 0, 40, 0, 0, 0)
u · v = 5 × 20 + (-3) × 40 = 20

子任务
• 输入数据保证0 < a,b < n;
• 向量 u 和 v 在每一个维度上的取值的绝对值<=10^6*/

import java.util.Scanner;

public class XiShuXiangLiang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int aLen = sc.nextInt();
		int bLen = sc.nextInt();
		int[][] a = new int[aLen][2];
		int[][] b = new int[bLen][2];
		int i, j;
		long ans = 0;
		
		for(i=0;i<aLen;i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
		}
		for(i=0;i<bLen;i++) {
			b[i][0] = sc.nextInt();
			b[i][1] = sc.nextInt();
		}
		
		i=0;j=0;
		while(i<aLen && j<bLen) {
			if(a[i][0] < b[j][0])
				i++;
			else if(a[i][0] > b[j][0])
				j++;
			else 
				ans += a[i++][1]*b[j++][1];
		}
		
		System.out.println(ans);
	}
}
