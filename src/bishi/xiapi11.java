package bishi;
/*/*字符串包含
详细描述
我们定义字符串包含关系：字符串A=abc，字符串B=ab，字符串C=ac，则说A包含B，A和C没有包含关系。

输入输出描述
输入描述
两个字符串，判断这个两个字符串是否具有包含关系，测试数据有多组，请用循环读入。

输出描述
如果包含输出1，否则输出0

输入输出示例
示例1
输入
abef be
输出
1
示例2
输入
abc ab
输出
1*/

import java.util.Scanner;

public class xiapi11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.next();
            String m = sc.next();

            int sLen = s.length();
            int mLen = m.length();
            int i = 0;

            for (;i<=sLen-mLen;i++) {
                int j = 0;
                int k = i;
                while (j<mLen && k<sLen && s.charAt(k) == m.charAt(j)) {
                    k++;
                    j++;
                }

                if (j == mLen) {
                    System.out.println("1");
                    break;
                }
            }
            if (i>sLen-mLen)
                System.out.println("0");
        }
    }
}
