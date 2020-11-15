package bishi;
/*地鼠逃跑计划
时间限制：C/C++ 1秒，其他语言2秒
空间限制：C/C++ 64M，其他语言128M

有一只地鼠不小心跑进了一个m*n的矩形田地里，假设地鼠在这块田地的初始位置为（x,y），并且每次只能向相邻的上下左右四个方向移动一步，
那么在最多移动K次的情况下，有多少条路径可以逃出这片田地（一旦出去田地的边界就不能再往回走）？

输入描述:
输入数据包括五个参数：m,n,x,y,K
其中m和n的范围均为是[1,10]，K的范围是[0,10]。
0<=x<m,0<=y<n。

输出描述:
输出成功逃跑的路径数量。

输入例子1:
2
3
0
1
2

输出例子1:
6
*/

import java.util.Scanner;

public class DiShuTaoPao { //可优化：不用二维数组，边界值判断就行
    public int move(int x, int y, int k, int num, int[][] matrix) {
        if (k<=0)
            return num;

        if (matrix[x][y-1] == 1)
            num = move(x,y-1,k-1,num,matrix);
        else
            num++;

        if (matrix[x+1][y] == 1)
            num = move(x+1,y,k-1,num,matrix);
        else
            num++;

        if (matrix[x][y+1] == 1)
            num = move(x,y+1,k-1,num,matrix);
        else
            num++;

        if (matrix[x-1][y] == 1)
            num = move(x-1,y,k-1,num,matrix);
        else
            num++;

        return num;
    }

    public int count(int m, int n, int x, int y, int k) {
        int num = 0;
        int[][] matrix = new int[m+2][n+2];

        for (int i=1;i<=m;i++)
            for (int j=1;j<=n;j++)
                matrix[i][j] = 1;

        return move(x+1,y+1,k,num,matrix);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DiShuTaoPao dstp = new DiShuTaoPao();
        System.out.println(dstp.count(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
    }
}
