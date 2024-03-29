package bishi;
/*Shopee的零食柜
shopee的零食柜，有着各式各样的零食，但是因为贪吃，小虾同学体重日益增加，终于被人叫为小胖了，他终于下定决心减肥了，
他决定每天晚上去操场跑两圈，但是跑步太累人了，他想转移注意力，忘记痛苦，正在听着音乐的他，突然有个想法，他想跟着音乐的节奏来跑步，
音乐有7种音符，对应的是1到7，那么他对应的步长就可以是1-7分米，这样的话他就可以转移注意力了，
但是他想保持自己跑步的速度，在规定时间m分钟跑完。为了避免被累死，他需要规划他每分钟需要跑过的音符，
这些音符的步长总和要尽量小。下面是小虾同学听的歌曲的音符，以及规定的时间，你能告诉他每分钟他应该跑多少步长？

输入描述:
输入的第一行输入 n（1 ≤ n ≤ 1000000，表示音符数），m（1<=m< 1000000, m <= n）组成，
第二行有 n 个数，表示每个音符（1<= f <= 7）

输出描述:
输出每分钟应该跑的步长

输入例子1:
8 5 6 5 6 7 6 6 3 1

输出例子1:
11*/

import java.util.Scanner;
import java.lang.Class;

public class xiapi6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        int min = 0;
        int max = 0;

        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();

            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        while (min < max) {
            int mid = (max - min) / 2 + min;
            if (compare(arr, mid, m)) {
                max = mid;
            }
            else {
                min = mid + 1;
            }

        }

        System.out.println(min);
    }

    public static boolean compare(int[] arr, int mid, int m) {
        int mm = 1;
        int val = 0;

        for (int v : arr) {
            if (val + v > mid) {
                mm++;
                val = v;
            }
            else {
                val += v;
            }
        }

        return mm <= m;
    }
}
