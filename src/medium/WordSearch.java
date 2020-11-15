package medium;
/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class WordSearch {
    char[][] board;
    boolean[][] matrix;
    String word;
    int len, X, Y;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.len = word.length();
        this.X = board.length;
        this.Y = board[0].length;
        for (int x=0;x<X;x++)
            for (int y=0;y<Y;y++) {
                this.matrix = new boolean[X][Y];
                if (search(x, y, 0))
                    return true;
            }
        return false;
    }

    public boolean search(int x,int y,int i) {
        if (i == len ||(i==len-1 && board[x][y] == word.charAt(i)))
            return true;

        if (board[x][y] != word.charAt(i))
            return false;

        matrix[x][y] = true;

        if (y < Y - 1 && !matrix[x][y + 1] && search(x, y+1, i+1))
            return true;
        if (x < X - 1 && !matrix[x + 1][y] && search(x+1, y, i+1))
            return true;
        if (y > 0 && !matrix[x][y - 1] && search(x, y-1, i+1))
            return true;
        if (x > 0 && !matrix[x - 1][y] && search(x-1, y, i+1))
            return true;
        matrix[x][y] = false;
        return false;
    }

    /*public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }*/
}
