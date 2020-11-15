package bishi;
/*
小明还是非常喜欢各种数字。
最近他在思考这么一个问题：如果有X和Y两个十进制正整数，其中，X是Y的真因数（真因数是包括1但不包括这个数本身的约数）；如果将X和Y对应的二进制数进行比较，
发现至少有一个1在相同的数位上（按照从右向左，即从低位到高位的顺序计数）。
请编写一个程序，当给定一个指定的正整数Y时，统计满足要求的正整数X有多少个？

输入描述
单组输入，包含一个正整数Y(Y<=100)。
输出描述
输出满足要求的X的个数。

样例输入
10
样例输出
1
 */

import java.util.Scanner;

public class guangxun {
    public static int getTotal(int y) {
        int[] nums = new int[20];
        int total = 0;
        int i, j, k=1;
        int max = (int) Math.sqrt(y);
        nums[0] = 1;

        for (i=2;i<=max;i++) {
            j = y/i;
            if (i==j && i*j==y) {
                nums[k++] = i;
                break;
            }
            if (i*j == y) {
                nums[k++] = i;
                nums[k++] = j;
            }
        }

        while (y != 0) {
            if (y%2 == 1) {
                for (i=0;i<k;i++) {
                    if (nums[i]%2 == 1)
                        total++;
                    nums[i] = nums[i]/2;
                }
            }
            else {
                for (i=0;i<k;i++) {
                    nums[i] = nums[i]/2;
                }
            }
            y /= 2;
        }

        return total;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(getTotal(sc.nextInt()));
    }
}
