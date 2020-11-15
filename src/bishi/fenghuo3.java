package bishi;
/*
有n个人排成一条直线，从左到右编号分别为1到n。现在从第1个人开始报数，在报数过程中，如果有人报到m则出列，下一个人将继续从1开始报数。
第n个人报数完之后再接着往回报数，即倒数第2个人继续报下一个数；当报到第1个人后，第2个人再接着报数。如此循环，直到只留下一个人为止。
例如当n=2，m=3时，第1个人报1，第2个人报2，接下来第1个人报3，出列，留下第2个人。
当输入n和m时，请问通过（n-1）轮报数后，最后留下的那个人的编号是多少？

输入描述
单组输入。
输入两个正整数n和m，n<=10000，m<=1000。两个正整数之间用空格隔开。
输出描述
输出最后留下的那个人的编号。

样例输入
5 3
样例输出
1
 */

import java.util.Scanner;

public class fenghuo3 {
    public static int theLast(int len,int m) {
        int[] ints = new int[len+1];
        int i=1, num=0, live = len;
        boolean flag = true;
        if (len == 1) return 1;

        while (flag) {
            for (;i<=len;i++) {
                if (ints[i] == 0) {
                    num++;
                    if (num == m) {
                        ints[i] = 1;
                        num = 0;
                        if (--live == 1){
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (!flag) break;
            for (i=i-2;i>=2;i--) {
                if (ints[i] == 0) {
                    num++;
                    if (num == m) {
                        ints[i] = 1;
                        num = 0;
                        if (--live == 1){
                            flag = false;
                            break;
                        }
                    }
                }
            }
        }

        for (i=1;i<=len;i++)
            if (ints[i] == 0)
                return i;
        return 1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(theLast(sc.nextInt(), sc.nextInt()));
    }
}
