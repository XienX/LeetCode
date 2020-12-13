package ccf_csp;
/*201912-3 化学方程式
题目
给出一组化学方程式，请你编写程序判断每个方程式是否配平（也就是方程式中等号左右两边的元素种类和对应的原子个数是否相同）。
本题给出的化学方程式由大小写字母、数字和符号（包括等号=、加号+、左圆括号和右圆括号）组成，不会出现其他字符（包括空白字符，如空格、制表符等），
化学方程式的格式与化学课本中的形式基本相同（化学式中表示元素原子个数的下标用正常文本），用自然语言描述如下：
	化学方程式由左右两个表达式组成，中间用一个等号=连接，如2H2+O2=2H2O；
	表达式由若干部分组成，每部分由系数和化学式构成，部分之间用加号+连接，如2H2+O2、2H2O；
	系数是整数或空串，如为空串表示系数为1；
	整数由一个或多个数字构成；
	化学式由若干部分组成，每部分由项和系数构成，部分之间直接连接，如H2O、CO2、Ca(OH)2、Ba3(PO4)2；
	项是元素或用左右圆括号括起来的化学式，如H、Ca、(OH)、(P04)；
	元素可以是一个大写字母，也可以是一个大写字母跟着一个小写字母，如H、O、Ca。
	
输入
从标准输入读入数据。
输入的第一行包含一个正整数n，表示输入的化学方程式个数。
接下来n行，每行是一个符合定义的化学方程式。

输出
输出到标准输出。
输出共n行，每行是一个大写字母Y或N，回答输入中相应的化学方程式是否配平。

输入样例1
11
H2+O2=H2O
2H2+O2=2H2O
H2+Cl2=2NaCl
H2+Cl2=2HCl
CH4+2O2=CO2+2H2O
CaCl2+2AgNO3=Ca(NO3)2+2AgCl
3Ba(OH)2+2H3PO4=6H2O+Ba3(PO4)2
3Ba(OH)2+2H3PO4=Ba3(PO4)2+6H2O
4Zn+10HNO3=4Zn(NO3)2+NH4NO3+3H2O
4Au+8NaCN+2H2O+O2=4Na(Au(CN)2)+4NaOH
Cu+As=Cs+Au

输出样例1
N
Y
N
Y
Y
Y
Y
Y
Y
Y
N

提示
1<=n<=100
输入的化学方程式都是符合题目中给出的定义的，且长度不超过1000
系数不会有前导零，也不会有为零的系数
化学方程式的任何一边，其中任何一种元素的原子总个数都不超过10^9*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HuaXueFangChengShi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int n = sc.nextInt();n>0;n--) {
			String[] s = sc.next().split("=");
			
			List<Element> left = getElementsList(s[0]);
			List<Element> right = getElementsList(s[1]);
			
			int leftLen = left.size(), rightLen = right.size();
			if(leftLen != rightLen)
				System.out.println("N");
			else {
				boolean flag = true;
				for(int i=0;i<leftLen;i++) {
					if(!left.get(i).name.equals(right.get(i).name) || left.get(i).count != right.get(i).count) {
						System.out.println("N");
						flag = false;
						break;
					}
				}
				if(flag)
					System.out.println("Y");
			}
		}
	}

	private static List<Element> getElementsList(String s) {
		List<Element> ans = new ArrayList<>();
		String[] ss = s.split("\\+");
		
		for(String sss : ss) {
			int len = sss.length();
			int initVal = 1;
			int i = 0, j = 0;
			
			if(Character.isDigit(sss.charAt(0))) { // 首位
				j = 1;
				while(j < len && Character.isDigit(sss.charAt(j)))
					j++;
				initVal = Integer.parseInt(sss.substring(0, j));
				i = j;
			}
			
			while(i<len) {
				if(sss.charAt(i) == '(') {
					ans.add(new Element("(", 0));
					i++;
				}
				else if(sss.charAt(i) == ')') {
					i++;
					
					if(i<len && Character.isDigit(sss.charAt(i))) { // 括号后跟数字
						j = i+1;
						while(j < len && Character.isDigit(sss.charAt(j)))
							j++;
						
						int num = Integer.parseInt(sss.substring(i, j));
						int l = ans.size() - 1;
						while(!ans.get(l).name.equals("(")) {
							ans.get(l).count *= num;
							l--;
						}
						ans.remove(l);
						i = j;
					}
					else {
						int l = ans.size() - 1;
						while(!ans.get(l).name.equals("("))
							l--;
						ans.remove(l);
					}
				}
				else if(Character.isDigit(sss.charAt(i))) {
					j = i+1;
					while(j < len && Character.isDigit(sss.charAt(j)))
						j++;
					
					int num = Integer.parseInt(sss.substring(i, j));
					ans.get(ans.size() - 1).count *= num;
					i = j;
				}
				else {
					j = i+1;
					while(j < len && Character.isLowerCase(sss.charAt(j)))
						j++;
					ans.add(new Element(sss.substring(i, j), initVal));
					i = j;
				}
			}
		}
		
		Collections.sort(ans, new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                return e1.name.compareTo(e2.name);
            }
        });
		
		int i = 0, max = ans.size()-1;
		while(i < max) {
			if (ans.get(i).name.equals(ans.get(i+1).name)) {
				ans.get(i).count += ans.get(i+1).count;
				ans.remove(i+1);
				max--;
			}
			else 
				++i;
		}
		
		return ans;
	}
}

class Element{
	public String name;
	public int count;
	
	public Element(String name, int count) {
		this.name  = name;
		this.count = count;
	}
}
