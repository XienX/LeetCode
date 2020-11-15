package bishi;
/*
现在给你一个01串，请你编写一个程序计算在这个01串中不包含110的最长子串的长度。

输入描述
单组输入。
输入一行，包含一个01串S（在S中只包含0和1，有可能输入全为0或者1的串），其长度1<=|S|<=1000000。
输出描述
输出01串S中不包含110的最长子串的长度。

样例输入
1101010110010110
样例输出
8
 */

import java.util.Scanner;

public class fenghuo1 {
    public static int maxLen(String s){
        char[] chars = s.toCharArray();
        int i=2,j=3;
        int max = 2;

        if (chars.length<3)
            return chars.length;

        while (j<chars.length) {
            if (chars[i-2]=='1' && chars[i-1]=='1' && chars[i]=='0')
                i++;

            if (chars[j-2]=='1' && chars[j-1]=='1' && chars[j]=='0')
                i = j - 1;

            max = Math.max(max, j-i+1);
            j++;
        }

        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(maxLen(sc.nextLine()));
    }
}
