package bishi;
/*
人的视力不能看到掩体之后的事物，在一场战争中，我们希望对方尽可能的低估我方的战斗力这样才能出其不意。
某个军事参谋效仿孙膑，把某些小规模部队隐藏在大规模部队中，这样，就使得军队数量看起来变少了。
如果某部队A的人数小于等于另一支部队B人数的1/3，则可以将A藏于B中，且不被人发现。不支持嵌套，例如A小于B的三分之一，可将A藏于B，如果又存在B是C的三分之一，不可再将B藏于C。
现在已知我方共有n支部队，且知道每支部队的人数，请问，在最优方案下，我们暴露给敌人的部队数量有几支。

输入描述
输入第一行包含一个正整数n，表示我方有n支部队。(1<=n<=50000)
第二行有n个整数，表示每支部队的人数，中间用空格隔开。(1<=a_i<=10^8)
输出描述
输出仅包含一个整数，表示最少的游戏局数。

样例输入
5
2 6 7 7 10
样例输出
4
 */

import java.util.Arrays;
import java.util.Scanner;

public class fenghuo2 {
    public static int minArm(int len,int[] nums) {
        int ans = len;
        Arrays.sort(nums);
        int max = nums[len-1];
        int i,j,mid;
        for (i=0;i<len;i++)
            if (nums[i]>max/3)
                break;
        mid = i;
        i--;
        j = len-1;
        while (i>=0 && j>=mid) {
            if (nums[i]<=nums[j]/3) {
                ans--;
                j--;
            }
            i--;
        }

        return ans;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i=0;i<len;i++)
            nums[i] = sc.nextInt();

        System.out.println(minArm(len, nums));
    }
}
