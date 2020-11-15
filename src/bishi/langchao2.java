package bishi;
/*某条街道两侧分别种植了一排树木，并按如下编号：
1 3 5 7 .... 45 47 49 ... 99
2 4 6 8 ... 46 48 50 ... 100
但是有一些树被砍去，希望你能找出一边最长的连续的大树。

输入
第一行一个整数N
第二行N个整数表示被砍去树的编号
输出
M 和 X（表示从第M棵大树开始，共有连续的X棵大树，如果有多个解，输出M最小的解即可）

样例输入
5
9 15 27 35 6
样例输出
8 47
*/

import java.util.Scanner;

public class langchao2 {
    public static void main(String[] args) {
        int[] t1 = new int[50];
        int[] t2 = new int[50];
        Scanner sc = new Scanner(System.in);
        int i,v,max1=-1,start1=0,max2=-1,start2=0,m=0,q=-1;

        int n = sc.nextInt();
        for(i=0;i<n;i++) {
            v = sc.nextInt();
            if(v%2 == 1) //t1,1,3,5...99
                t1[v/2] = 1;
            else //t2,2,4,6...100
                t2[v/2-1] = 1;
        }

        for(i=0;i<50;i++) {
            if(t1[i] == 1) {
                if(m>max1) {
                    max1 = m;
                    start1 = q;
                }
                q = i;
                m = 0;
            }
            else m++;
        }
        m++;
        if(m>max1) {
            max1 = m-1;
            start1 = q;
        }

        m = 0;
        q = -1;
        for(i=0;i<50;i++) {
            if(t2[i] == 1) {
                if(m>max2) {
                    max2 = m;
                    start2 = q;
                }
                q = i;
                m = 0;
            }
            else m++;
        }
        m++;
        if(m>max2) {
            max2 = m-1;
            start2 = q;
        }

        if(max1>max2)
            System.out.println(2*(start1+1)+1 + " " + max1);
        else if (max1<max2)
            System.out.println(2*(start2+1)+2 + " " + max2);
        else {
            if (2*(start1+1)+1 < 2*(start2+1)+2)
                System.out.println(2*(start1+1)+1 + " " + max1);
            else
                System.out.println(2*(start2+1)+2 + " " + max2);
        }
    }
}