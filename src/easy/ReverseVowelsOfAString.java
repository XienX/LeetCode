package easy;
/*345. 反转字符串中的元音字母
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1：
输入："hello"
输出："holle"

示例 2：
输入："leetcode"
输出："leotcede"

提示：
元音字母不包含字母 "y" 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int L = 0;
        int R = arr.length - 1;

        Set<Character> set = new HashSet<>();
        set.add('a');set.add('o');set.add('e');set.add('i');set.add('u');
        set.add('A');set.add('O');set.add('E');set.add('I');set.add('U');

        while(L < R){
            while(L < R && !set.contains(arr[L]))
                L++;
            while(L < R && !set.contains(arr[R]))
                R--;

            if(arr[L] != arr[R]){
                char temp = arr[L];
                arr[L] = arr[R];
                arr[R] = temp;
            }
            
            L++;
            R--;
        }

        return String.valueOf(arr);
    }
}
