package ccf_csp;
/*201909-3 字符画
题目描述
本题中，你需要将图片转换为终端中可以显示的字符画。
你将得到一张24位图片，这意味着其中的像素表示为RGB三原色的形式，而每种颜色的取值范围为0到255（一个字节），因此每个像素占用的空间为24比特。
你需要这张图片分割为指定数量的块。对于每一块，你需要计算所有像素的三个颜色分量的平均值，并输出对应颜色的字符形成字符画。
为了在终端中输出彩色的字符，你需要使用特殊的转义序列。在目前通行的终端规范中，与颜色相关的转义序列包括：
ESC [ 38;2;R;G;B m更改终端的前景色（字符的颜色）为（R，G，B）
ESC [ 48;2;R;G;B m更改终端的背景色（未被字符遮盖处的颜色）为（R，G，B）
ESC [ 0 m重置终端的颜色状态为默认值（前景色为白色（255，255，255），背景色为黑色（0，0，0））
你只需要在输出中加入这些转义序列，就能够控制终端中显示的字符颜色。在书写转义序列时，有以下注意事项：
所有空格都是为了方便辨认而添加的，不需要出现在实际的转义序列输出中
ESC不是字面上的三个字符，而是ASCII序号为27（八进制表示为033）的一个字符，代表转义序列的开始。
在C/C++/Java/Python中，你都可以使用\033或\x1b来在字符串中使用这个字符。
每个颜色分量的值需要在0到255的范围内
对终端状态的更改在当前转义序列结束（即最后的m字符）后立刻生效，直到下一个序列再次改变状态为止
特别需要注意的是，在程序完成输出后，应该主动恢复终端的颜色状态，否则可能让之后运行的程序表现异常。

输入格式
从标准输入读入数据。
输入的第一行为两个整数m，n，分别表示图片的宽和高。第二行为两个整数p，q，分别表示每一小块的宽和高。保证p整除m，并且q整除n，也就是说图片总是能被分割成整数块。
接下来共有m×n行，每一行是图片中的一个像素，按照从左到右、从上到下的顺序列出。
每个像素的颜色以HTML颜色代码的形式表示，格式为#abcdef，表示该像素的R、G、B三个分量分别是（0xab，0xcd，0xef）（注意为16进制）。
此外，为了使得表达简洁，#aabbcc可以被缩写为#abc，#aaaaaa可以被缩写为#a，你需要处理这些情况。

输出格式
输出到标准输出。
输出包含两部分，每一个输出中应该有恰好（mm）/（pg）个空格（' '）以及n/g个换行符（'\n'），和若干个转义序列。
空格用于绘制色块（呈现出的即为其背景色），转义序列用于改变颜色。
每一个色块都由p×g个像素组成，其三个颜色分量值分别是对应区域中所有像素该分量值的平均值（除法向零取整即可）。
由于正确的答案显然不止一种，为了方便判定，我们有以下的约定：
初始时终端的前景色和背景色都为默认值（前景白色，背景黑色）
减少控制序列的冗余，这包含以下的情况：
如果下一个字符的颜色刚好与默认值完全相同，你应当直接使用重置转义序列，而非手动更改颜色
如果某个字符的前景色/背景色与其前一个字符相同，或者对颜色的更改并不影响最终显示效果，则不应该出现更改这个属性的控制序列
在输出每一行字符后，如果终端颜色不是默认值，你应该重置终端的颜色状态
为了便于观察和评测，你需要将输出中的所有字符转换为ASCII编码转义后的格式再进行输出。
即，如果某个字符的16进制编码是0xAB，则你应该在输出文件中写入\xAB，注意大小写。所有的字符都需要被转义（包括空格、换行等空白字符）;
所有字符的转义序列顺序输出，不需要任何形式的分隔符号;在输出所有的转义序列后，不需要写入换行符。
也就是说，最终的输出文件只有一行，并且其中所有内容都是原本输出字符的ASCII转义序列。
如果你使用的是Linux系统，你可以在终端中运行如下的命令查看输出文件的真实显示效果（其中1.out是文件名）：
  echo-ne $（cat 1.out）

样例1输入
1 1
1 1
#010203
样例1输出
\x1B\x5B\x34\x38\x3B\x32\x3B\x31\x3B\x32\x3B\x33\x6D\x20\x1B\x5B\x30\x6D\x0A
样例1解释
输入文件图片大小为1x1，要求的色块大小为1x1，因此原样输出即可。在输出后需要重置背景色。

样例2输入
2 2
1 2
#111111
#0
#000000
#111
样例2输出
\x1B\x5B\x34\x38\x3B\x32\x3B\x38\x3B\x38\x3B\x38\x6D\x20\x20\x1B\x5B\x30\x6D\x0A
样例2解释
输入文件图片大小为2×2，要求的色块大小为1×2，因此将被切为两个色块。
第一个色块的颜色是左侧两个像素的平均值，三个颜色分量为（8，8，8）;第二个色块同理，计算得到的颜色分量相同。
因此最终只需要更改一次终端的背景色，并输出两个空格用于显示即可。*/

import java.util.Collections;
import java.util.Scanner;

public class ZiFuHua {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(), n = sc.nextInt();
		int p = sc.nextInt(), q = sc.nextInt();
		int col = n/q, row = m/p;
		String[][] pixels = new String[n][m];
		int i, j;
		String tem;
		
		StringBuilder sb = new StringBuilder();
		String space = "\\x20";
		String LF = "\\x0A";
		String reSet = "\\x1B\\x5B\\x30\\x6D";
		String defaultColor = "\\x30\\x3B\\x30\\x3B\\x30";
		
		for(i=0;i<n;i++)
			for(j=0;j<m;j++) {
				tem = sc.next();
				if (tem.length() == 2)
					pixels[i][j] = String.join("", Collections.nCopies(6, tem.substring(1)));
				else if (tem.length() == 4)
					pixels[i][j] = tem.substring(1,2)+tem.substring(1,2)+tem.substring(2,3)+tem.substring(2,3)+tem.substring(3)+tem.substring(3);
				else
					pixels[i][j] = tem.substring(1);
			}
		
		String[][] outs = pixelCount(m, n, p, q, col, row, pixels);
		String last = "\\x30\\x3B\\x30\\x3B\\x30";
		
		for(i=0;i<col;i++) {
			for(j=0;j<row;j++) {
				if(!outs[i][j].equals(last)) {
					last = outs[i][j];
					
					if(outs[i][j].equals(defaultColor)) 
						sb.append(reSet);
					else 
						sb.append("\\x1B\\x5B\\x34\\x38\\x3B\\x32\\x3B").append(outs[i][j]).append("\\x6D");
				}
				
				sb.append(space);
			}
		
			if(!last.equals("\\x30\\x3B\\x30\\x3B\\x30")) {
				sb.append(reSet);
				last = "\\x30\\x3B\\x30\\x3B\\x30";
			}

			sb.append(LF);
		}
		
		System.out.print(sb.toString());
	}

	private static String[][] pixelCount(int m, int n, int p, int q, int col, int row, String[][] pixels) {
		String[][] outs = new String[col][row];
		int i, j;
		
		for(i=0;i<col;i++)
			for(j=0;j<row;j++) {
				int red = 0, green = 0, blue = 0;
				int nowCol = i*q, nowRow = j*p;
				int a, b;
				for(a=0;a<q;a++)
					for(b=0;b<p;b++) {
						red += Integer.parseInt(pixels[nowCol+a][nowRow+b].substring(0, 2), 16);
						green += Integer.parseInt(pixels[nowCol+a][nowRow+b].substring(2, 4), 16);
						blue += Integer.parseInt(pixels[nowCol+a][nowRow+b].substring(4), 16);
					}
				
				String v = Integer.toString(red/(p*q)) +";"+ Integer.toString(green/(p*q)) +";"+ Integer.toString(blue/(p*q));
				
				StringBuilder sb = new StringBuilder();  
			    char[] chars = v.toCharArray();   
			    for (char c : chars)
			            sb.append("\\x").append(Integer.toHexString((int) c).toUpperCase());
			            
			    outs[i][j] = sb.toString();
			}
		
		return outs;
	}
}
