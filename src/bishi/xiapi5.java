package bishi;
/*Shopee的办公室（二）
hopee的办公室非常大，小虾同学的位置坐落在右上角，而大门却在左下角，可以把所有位置抽象为一个网格（门口的坐标为0，0），
小虾同学很聪明，每次只向上，或者向右走，因为这样最容易接近目的地，但是小虾同学不想让自己的boss们看到自己经常在他们面前出没，
或者迟到被发现。他决定研究一下如果他不通过boss们的位置，他可以有多少种走法？

输入描述:
第一行 x,y,n (0<x<=30, 0<y<=30, 0<=n<= 20) 表示x,y小虾的座位坐标,n 表示boss的数量（ n <= 20）
接下来有n行, 表示boss们的坐标(0<xi<= x, 0<yi<=y，不会和小虾位置重合)
x1, y1
x2, y2
……
xn, yn

输出描述:
输出小虾有多少种走法

输入例子1:
3 3 2
1 1
2 2

输出例子1:
4*/

import java.util.Scanner;

public class xiapi5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();

        boolean[][] arr = new boolean[x+1][y+1];

        for (int i=0;i<n;i++) {
            arr[sc.nextInt()][sc.nextInt()] = true;
        }

        long[][] ans = new long[x+1][y+1];

        for (int i=0;i<=y;i++) {
            if (!arr[0][i]) {
                ans[0][i] = 1;
            }
        }

        for (int i=1;i<=x;i++) {
            ans[i][0] = 1;

            for (int j=1;j<=y;j++) {
                if (!arr[i][j]) {
                    ans[i][j] = ans[i-1][j] + ans[i][j-1];
                }
            }
        }

        System.out.println(ans[x][y]);
    }
}
