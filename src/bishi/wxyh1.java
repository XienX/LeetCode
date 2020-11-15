package bishi;
/*
朱望仔吃串串，串串由n个0到9的个数字组成，若其中一个子串的和等于它的长度，则可以被吃掉，这个串串可不一般，
被吃掉后原串串不会改变并且同一位置上相同的子串不能被重复吃掉，作为一个十足的吃货，朱望仔总想吃到更多的串串，现在需要聪明的你帮他计算出他最多能吃多少个串串。
例如：串串的组成为102，则a1…1=|1|=1，a2…3=|0,2|=0+2，a1…3=|1,0,2|=1+0+2；可知他最多可吃到3个串串.

输入描述
第一行为t (1≦t≦1000)，表示t组测试用例
接下来的第2i-1行n为串串的长度，第2i行为串串的具体组成
输出描述
对于每组测试用例在单行输出其结果
样例输入
3
3
120
5
11011
6
600005
样例输出
3
6
1
 */

import java.util.Scanner;

public class wxyh1 {
    public static int getMax(int len, String s){
        char[] temp = s.toCharArray();
        int total = 0, val;
        int i = 0, j, k;
        int[] nums = new int[len];

        for (;i<len;i++) {
            if (temp[i] == '1')
                total++;
            nums[i] = temp[i] - '0';
        }

        for (i=2;i<=len;i++) { //算几个
            for (j=0;j<=len-i;j++) {
                val = 0;
                for (k=0;k<i;k++)
                    val += nums[j+k];
                if (val == i)
                    total++;
            }
        }

        return total;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i=0;i<t;i++) {
            int len = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(getMax(len, s));
        }
    }
}
