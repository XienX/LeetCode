package bishi;
/*
对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。给定int矩阵mat，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
输入描述
每次启动程序，输入由stdin给到程序，为字符串格式。
输入: 1,2#3,4
需要写程序转成数组格式[[1,2], [3,4]]
输出描述
程序应该将计算结果，输出到stdout。
输出：1,2,4,3
两个元素间不要有空格
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class meicai1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] line = s.split("#");
        String[][] mat = new String[line.length][];
        for (int i=0;i<line.length;i++)
            mat[i] = line[i].split(",");
        int minx=0,maxx=line.length-1,miny=0,maxy=mat[0].length-1;
        int x=0,y=0;
        List<String> out = new ArrayList<>();
        out.add(mat[0][0]);
        while (true) {
            if (miny<=maxy) {
                for (y++;y<=maxy;y++)
                    out.add(mat[x][y]);
                minx++;
                y--;
            }
            else break;
            if (minx<=maxx) {
                for (x++;x<=maxx;x++)
                    out.add(mat[x][y]);
                maxy--;
                x--;
            }
            else break;
            if (miny<=maxy) {
                for (y--;y>=miny;y--)
                    out.add(mat[x][y]);
                maxx--;
                y++;
            }
            else break;
            if (minx<=maxx) {
                for (x--;x>=minx;x--)
                    out.add(mat[x][y]);
                miny++;
                x++;
            }
            else break;
        }

        for (int i=0;i<out.size()-1;i++) {
            System.out.print(out.get(i)+",");
        }
        System.out.print(out.get(out.size()-1));
    }
}
