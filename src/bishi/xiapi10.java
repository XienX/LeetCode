package bishi;
/*上台阶的游戏
详细描述
一个上台阶的游戏，如果每次只能上1步或者2步；那么一个n级的台阶一共有多少种上法？
要求时间占用、空间占用尽量少，复杂度尽量低。

输入输出描述
输入描述
一个整数

输出描述
一个整数

输入输出示例
示例1
输入
n = 1
输出
f(n) = 1
示例2
输入
n = 4
输出
f(n) = 5*/

import java.util.Scanner;

public class xiapi10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n < 2) {
            System.out.println(n);
            return;
        }

        int s0 = 1;
        int s1 = 1;
        int s2 = 2;

        for (int i=1;i<n;i++) {
            s2 = s0 + s1;

            s0 = s1;
            s1 = s2;
        }

        System.out.println(s2);

//        int[] nums = new int[n+1];
//        nums[0] = 1;
//        nums[1] = 1;
//
//        for (int i=2;i<=n;i++) {
//            nums[i] = nums[i-1] + nums[i-2];
//        }
//
//        System.out.println(nums[n]);
    }
}
