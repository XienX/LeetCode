package bishi;
/*
朱望仔的滑冰场，朱望仔比较喜欢滑冰，某天决定在一些柱子上面修建自己的滑冰场，他想要从右往左滑，因此左边不能出现比右边高的地方，
但是这些柱子的高度并不满足，他拥有一个超能力，可将其中部分或者全部柱子的高度分别进行加1，前提是操作的这些柱子不能出现左边比右边高的，
他想用最少的超能力操作次数把这些柱子变得满足自己要求以便于修建滑冰场，现在需要你帮他计算出最少的操作次数。
输入描述
第一行为t （1≤t≤100），表示t组测试用例
接下来的第2i-1行n为楼梯的个数，第2i行为这n个楼梯的高度
输出描述
对于每组测试用例在单行输出其结果
例如第一个用例变化如下：
第一次操作[5,3,2,5]→[5,3,3,5] 第二次操作[5,3,3,5]→[5,4,4,5]
第三次操作[5,4,4,5]→[5,5,5,5]

样例输入
3
4
5 3 2 5
5
1 2 3 5 3
3
1 1 1
样例输出
3
2
0

提示
第一次操作[5,3,2,5]→[5,3,3,5]
第二次操作[5,3,3,5]→[5,4,4,5]
第三次操作[5,4,4,5]→[5,5,5,5]
 */

import java.util.Scanner;

public class wxyh2 {
    public static int count(int len, int[] nums) {
        int ans = 0,i;
        boolean flag;
        while (true) {
            flag = true;
            for (i=1;i<len;i++)
                if (nums[i-1]>nums[i]) {
                    flag = false;
                    break;
                }
            if (flag) break;
            ans++;

            /*for (i=1;i<len-1;i++)
                if (nums[0]>nums[i] && nums[i-1]<=nums[i+1])
                    nums[i]++;
            if (nums[0]>nums[len-1])
                nums[len-1]++;*/
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i=0;i<t;i++) {
            int len = sc.nextInt();
            int[] temp = new int[len];
            for (int j=0;j<len;j++)
                temp[j] = sc.nextInt();
            System.out.println(count(len, temp));
        }
    }
}
