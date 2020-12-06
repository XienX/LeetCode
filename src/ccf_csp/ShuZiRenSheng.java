package ccf_csp;
/*	202009-3 点亮数字人生
问题描述
本题中，你需要实现一个简单的数字逻辑电路模拟器。这种电路仅由逻辑门构成。
一个逻辑门可以理解为一个多输入单输出的函数，输入端连接至少一个信号，而后经过一定的逻辑运算输出一个信号。
常见的逻辑门包括与（AND）、或（OR）、非（NOT）、异或（XOR）等，均与编程语言中的按位运算是对应的。
无论复杂程度，这类电路的特点是：它不维持任何的状态，任何时刻输出只与输入有关，随输入变化。
为了简单起见，本题中我们模拟的组合逻辑电路不考虑延时：一旦输入变化，输出立刻跟着变化。
考虑到组合逻辑电路的这一特性，设计时不能允许组合环路（combinational loop）的存在，即某逻辑门的输入经过了一系列器件之后又被连接到了自己的输入端。
因此，你也需要探测可能的环路。需要注意，环路的存在性与逻辑门的具体功能没有任何关系；只要连接关系上存在环路，电路就无法正常工作。

输入格式
输入数据包括若干个独立的问题，第一行一个整数 Q，满足 1<=Q<=Qmax。接下来依次是这 Q 个问题的输入，你需要对每个问题进行处理，并且按照顺序输出对应的答案。
每一个问题的输入在逻辑上可分为两部分。第一部分定义了整个电路的结构，第二部分定义了输入和输出的要求。实际上两部分之间没有分隔，顺序读入即可。

第一部分
第一行是两个空格分隔的整数 M,N，分别表示了整个电路的输入和器件的数量，满足 1<=N<=Nmax 并且 0<=M<=kmaxN。其中 kmax 和 Nmax 都是与测试点编号有关的参数。
接下来 N 行，每行描述一个器件，编号从 1 开始递增，格式如下：
FUNC k L_1 L_2 ... L_k
其中 FUNC 代表具体的逻辑功能，k 表示输入的数量，后面跟着该器件的 k 个输入端描述 L，格式是以下二者之一：
Im：表示第 m 个输入信号连接到此输入端，保证 1<=m<=M；
On：表示第 n 个器件的输出连接到此输入端，保证 1<=n<=N。
所有可能的 FUNC 和允许的输入端数量如下表所述：

FUNC	最少输入数量	最多输入数量	功能描述
NOT     	1			1			非
AND			2			kmax		与
OR			2			kmax		或
XOR			2			kmax		异或
NAND		2			kmax		与非（先全部与后取非）
NOR			2			kmax		或非（先全部或后取非）
所有的器件均只有一个输出，但这个输出信号可以被用作多个器件的输入。

第二部分
第一行是一个整数 S，表示此电路需要运行 S 次。每次运行，都会给定一组输入，并检查部分器件的输出是否正确。S 满足 1<=S<=Smax，其中 Smax 是一个与测试点编号有关的参数。
接下来的 S 行为输入描述，每一行的格式如下：
I_1 I_2 ... I_M
每行有 M 个可能为 0 或 1 的数字，表示各个输入信号（按编号排列）的状态。
接下来的 S 行为输出描述，每一行的格式如下：
s_i O_1 O_2 ... O_s
第一个整数 1<=si<=N(1<=i<=S) 表示需要输出的信号数量。后面共有 si 个在 1 到 N 之间的数字，表示在对应的输入下，组合逻辑完成计算后，需要输出结果的器件编号。
注意 O 序列不一定是递增的，即要求输出的器件可能以任意顺序出现。

输出格式
对于输入中的 Q 个问题，你需要按照输入顺序输出每一个问题的答案：
如果你检测到电路中存在组合环路，则请输出一行，内容是 LOOP，无需输出其他任何内容。
如果电路可以正常工作，则请输出 S 行，每一行包含 si 个用空格分隔的数字（可能为 0 或 1），依次表示“输出描述”中要求的各个器件的运算结果。

样例输入1
1
3 5
XOR 2 I1 I2
XOR 2 O1 I3
AND 2 O1 I3
AND 2 I1 I2
OR 2 O3 O4
4
0 1 1
1 0 1
1 1 1
0 0 0
2 5 2
2 5 2
2 5 2
2 5 2
Data
样例输出1
1 0
1 0
1 1
0 0
样例1说明
本样例只有一个问题，其功能是一位全加器，即将三个信号相加，得到一个两位二进制数。要求的器件 2 的输出是向更高位的进位信号，器件 5 的输出是本位的求和信号。
对于第一组输入 0 1 1，输出是 1 0；对于第二组输入 1 0 1，输出恰好依旧是 1 0（但电路内部状态不同）。

样例输入2
1
2 6
NOR 2 O4 I2
AND 2 O4 O6
XOR 2 O5 O1
NOT 1 O6
NAND 2 O2 O2
AND 2 I1 O3
2
0 0
1 0
3 2 3 4
6 1 2 3 4 5 6
样例输出2
LOOP
样例2说明
本样例也只有一个问题，这是一个带组合环路的电路，因此无法正常工作。特别地，其中最短的环路有以下三条：
6 - 2 - 5 - 3 - 6
4 - 1 - 3 - 6 - 4
2 - 5 - 3 - 6 - 2

评测用例规模与约定
本题共有 10 个测试点，每个测试点占 10 分。*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShuZiRenSheng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		
		for(int i=0;i<Q;i++) {
			int M = sc.nextInt(); // 输入端个数
			int N = sc.nextInt(); // 元器件个数
			Node[] nodeList = new Node[N]; // 所有元器件
			String[][] temp = new String[N][]; // 临时存储元器件输入口
			List<Integer>[] input = new ArrayList[M]; // 每个输入端连接的元器件
			
			for(int j=0;j<N;j++) {
				String type = sc.next();
				int inputLen = sc.nextInt();
				Node node = new Node(j+1, type, inputLen);
				nodeList[j] = node;
				
				String[] tem = new String[inputLen];
				for(int k=0;k<inputLen;k++)
					tem[k] = sc.next();
				temp[j] = tem;
			}
			
			for(int j=0;j<M;j++)
				input[j] = new ArrayList();

			for(int j=0;j<N;j++) {
				for(int k=0;k<temp[j].length;k++) {
					if(temp[j][k].startsWith("I")) {
						input[Integer.parseInt(temp[j][k].substring(1))-1].add(j);
					}
					else {
						nodeList[Integer.parseInt(temp[j][k].substring(1))-1].next.add(nodeList[j]);
					}
				}
			}

			
			int S = sc.nextInt();
			int[][] inputVal = new int[S][M]; // 每组的初始值
			int[][] show = new int[S][]; // 每组的输出格式
			for(int j=0;j<S;j++) {
				int[] tem = new int[M];
				for(int k=0;k<M;k++)
					tem[k] = sc.nextInt();
				inputVal[j] = tem;
			}
			for(int j=0;j<S;j++) {
				int len = sc.nextInt();
				int[] tem = new int[len];
				for(int k=0;k<len;k++)
					tem[k] = sc.nextInt();
				show[j] = tem;
			}
			
			try {
				for(int j=0;j<S;j++) {
					for(int k=0;k<M;k++) {
						boolean a = inputVal[j][k] == 1;
						for(int n: input[k])
							nodeList[n].setInputVal(a);
					}
					
					for(Node node: nodeList)
						if (!node.isGetOut)
							throw new Exception();
					
					for(int k=0;k<show[j].length-1;k++) 
						System.out.print(nodeList[show[j][k]-1].out == false?0+" ":1+" ");
					System.out.println(nodeList[show[j][show[j].length-1]-1].out == false?0:1);
					
					for(Node node: nodeList)
						node.reset();
				}
			}
			catch (Exception e) {
				System.out.println("LOOP");
			}
		}
	}
}

class Node {
	public int no; // 编号
	String type; // 类型
	public int inputLen; // 输入端总数
	public List<Boolean> input = new ArrayList<>(); // 输入值
	public List<Node> next = new ArrayList<>(); // 后继结点
	public boolean out; // 输出结果
	public boolean isGetOut; // 是否计算过结果
	
	Node(int no, String type, int inputLen) {
		this.no = no;
		this.type = type;
		this.inputLen = inputLen;
	}
	
	public void reset() {
		input = new ArrayList<>();
		isGetOut = false;
	}
	
	public void setInputVal(boolean val) throws Exception {
		input.add(val);
		
		if(input.size() >= inputLen)
			Out();
	}
	
	private void Out() throws Exception {
		if (isGetOut)
			throw new Exception();
		
		isGetOut = true;
		out = input.get(0);
		input.remove(0);
		
		switch(type) {
		case "NOT":
			out = !out;
			break;
			
		case "AND":
			for(boolean v: input) 
				out = out & v;
			break;
			
		case "OR":
			for(boolean v: input) 
				out = out | v;
			break;
			
		case "XOR":
			for(boolean v: input) 
				out = out ^ v;
			break;
			
		case "NAND":
			for(boolean v: input) 
				out = out & v;
			out = !out;
			break;
			
		case "NOR":
			for(boolean v: input) 
				out = out | v;
			out = !out;
			break;
		}
		
		for(Node node: next) {
			node.setInputVal(out);
		}
	}
}
