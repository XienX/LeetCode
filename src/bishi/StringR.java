package bishi;
/*翻转字符串指定字符。 输入一个字符串，以及一个字符数组，实现翻转字符串功能。
输入描述    两个字符串（两行输入），前者为源字符串，后者为指定的翻转子串

输出描述    翻转后的字符串结果

样例输入
        "abcdef"
        "bcd"
样例输出
        "adcbef"
*/
//40% ???

import java.util.*;

public class StringR {
    static String reverse(String sourceStr, String changeStr) {
        /*int index = sourceStr.indexOf(changeStr);
        if (index == -1) return sourceStr;
        StringBuilder s = new StringBuilder();
        s.append(sourceStr, 0, index);
        for (int i=changeStr.length()-1;i>=0;i--)
            s.append(changeStr.charAt(i));
        s.append(sourceStr.substring(index+changeStr.length()));
        return String.valueOf(s);*/
        int index = sourceStr.indexOf(changeStr);
        StringBuilder s = new StringBuilder();
        while (index != -1){
            s.append(sourceStr, 0, index);
            sourceStr = sourceStr.substring(index+changeStr.length());
            for (int i=changeStr.length()-1;i>=0;i--)
                s.append(changeStr.charAt(i));
            index = sourceStr.indexOf(changeStr);
        }
        s.append(sourceStr);
        return String.valueOf(s);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _sourceStr;
        try {
            _sourceStr = in.nextLine();
        } catch (Exception e) {
            _sourceStr = null;
        }

        String _changeStr;
        try {
            _changeStr = in.nextLine();
        } catch (Exception e) {
            _changeStr = null;
        }

        res = reverse(_sourceStr, _changeStr);
        System.out.println(res);
    }
}