package bishi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class oppo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        Set<String> ans = new HashSet<>();
        int i, j;

        res = in.nextLine();
        int len = res.length();

        for (i=1;i<len-1;i++)
            for (j=1;i-j>=0 && i+j<len;j++)
                if (res.charAt(i-j) == res.charAt(i+j))
                    ans.add(res.substring(i-j, i+j+1));
                else
                    break;

        for (i=1;i<len;i++)
            for (j=1;i-j>=0 && i+j-1<len;j++)
                if (res.charAt(i-j) == res.charAt(i+j-1))
                    ans.add(res.substring(i-j, i+j));
                else
                    break;

        for (String s: ans)
            System.out.println(s);
    }
}
