package easy;
/*剑指 Offer 58 - II. 左旋转字符串
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

示例 1：
输入: s = "abcdefg", k = 2
输出: "cdefgab"

示例 2：
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"

限制：
1 <= k < s.length <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class ZuoXuanZhuanZiFuChuanLcof {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /*public String reverseLeftWords(String s, int n) {
        return (s + s).substring(n, s.length() + n);
    }*/

//    public String reverseLeftWords(String s, int n) {
//        int length = s.length();
//        char[] chars = s.toCharArray();
//        reverse(chars, 0, length - 1);//先反转全部的元素
//        reverse(chars, 0, length - n - 1);//在反转前length - n个元素
//        reverse(chars, length - n, length - 1);//接着反转剩余的
//        return new String(chars);
//    }
//
//    //把数组中从[start，end]之间的元素两两交换,也就是反转
//    private void reverse(char[] chars, int start, int end) {
//        while (start < end) {
//            char temp = chars[start];
//            chars[start++] = chars[end];
//            chars[end--] = temp;
//        }
//    }

    /*作者：sdwwld
    链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/shu-ju-jie-gou-he-suan-fa-duo-chong-fang-zwe7/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
