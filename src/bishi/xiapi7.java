package bishi;
/*实现字通配符*
在Linux Shell命令下通配符'*'表示0个或多个字符, 现编写一段代码实现通配符'*'的功能，注意只需要实现'*', 不用实现其他通配符。

输入描述:
第一行输入通配字符串
第二行输入要匹配查找的字符串

输出描述:
输出所有匹配的字串起始位置和长度，每行一个匹配输出
如果不匹配，则输出 -1 0
如果有多个按照起始位置和长度的正序输出。

输入例子1:
shopee*.com
shopeemobile.com
输出例子1:
0 16
例子说明1:
0 起始位置，16长度

输入例子2:
*.com
shopeemobile.com
输出例子2:
0 16
1 15
2 14
3 13
4 12
5 11
6 10
7 9
8 8
9 7
10 6
11 5
12 4

输入例子3:
o*m
shopeemobile.com
输出例子3:
2 5
2 14
7 9
14 2*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class xiapi7 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String s = sc.next();
//        String str = sc.next();
//
//        for (int i=0;i<s.length();i++) {
//            if (s.charAt(i) == '.') {
//                s = s.substring(0, i) + "\\" + s.substring(i);
//                i++;
//            }
//        }
//
//        int len = str.length();
//        boolean isMatched = false;
//
//        Pattern p = Pattern.compile(s);
//
//        for (int i=0;i<len;i++) {
//            for (int j=i+1;j<=len;j++) {
//                Matcher m = p.matcher(str.substring(i, j));
//                if (m.matches()) {
//                    System.out.println(i + " " + (j-i) + "\n");
//                    isMatched = true;
//                }
//            }
//        }
//
//        if (!isMatched)
//            System.out.println("-1 0");
//    }
}