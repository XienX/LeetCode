package bishi;
/*字符串命名转换
孔乙己说“回”字有四种写法，编程语言中常见的命名风格有如下四种：
 - 全部首字母大写
 - 第一个单词首字母小写，其余单词首字母大写
 - 单词全部小写，由下划线连接
 - 单词全部小写，由减号连接

请设计并实现一个caseTransform函数，使得一个字符串str可以被方便地转成四种形式，并且将四种形式通过空格拼接成一个字符串返回
为方便起见，这里假设输入字符串全部符合以上四种形式的英文字母组合

输入描述:
PascalCaseTest

输出描述:
PascalCaseTest  pascalCaseTest  pascal_case_test pascal-case-test

输入例子1:
PascalCaseTest

输出例子1:
PascalCaseTest pascalCaseTest pascal_case_test pascal-case-test*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class xiapi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(caseTransform(scanner.nextLine()));
    }

    public static String caseTransform(String s) {
        String[] words;

        if (s.contains("_")) {
            words = s.split("_");
        }
        else if (s.contains("-")) {
            words = s.split("-");
        }
        else {
            List<String> list = new ArrayList<>();
            int len = s.length();
            int start = 0;

            for (int i=1;i<len;i++) {
                if(Character.isUpperCase(s.charAt(i))) {
                    list.add(s.substring(start, i).toLowerCase());
                    start = i;
                }
            }
            list.add(s.substring(start, len).toLowerCase());

            words = list.toArray(new String[0]);
        }

        StringBuilder sb = new StringBuilder();
        int l = words.length;

        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1));
        }
        sb.append(" ");

        sb.append(words[0]);
        for (int i=1;i<l;i++) {
            sb.append(Character.toUpperCase(words[i].charAt(0)));
            sb.append(words[i].substring(1));
        }
        sb.append(" ");

        sb.append(words[0]);
        for (int i=1;i<l;i++) {
            sb.append("_");
            sb.append(words[i]);
        }
        sb.append(" ");

        sb.append(words[0]);
        for (int i=1;i<l;i++) {
            sb.append("-");
            sb.append(words[i]);
        }

        return sb.toString();
    }
}
