package medium;
/*49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

说明：
所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Character, Integer> c2i = new HashMap<>();
        c2i.put('a', 2);c2i.put('b', 3);c2i.put('c', 5);c2i.put('d', 7);c2i.put('e', 11);c2i.put('f', 13);c2i.put('g', 17);
        c2i.put('h', 19);c2i.put('i', 23);c2i.put('j', 29);c2i.put('k', 31);c2i.put('l', 37);c2i.put('m', 41);c2i.put('n', 43);
        c2i.put('o', 47);c2i.put('p', 53);c2i.put('q', 59);c2i.put('r', 61);c2i.put('s', 67);c2i.put('t', 71);
        c2i.put('u', 73);c2i.put('v', 79);c2i.put('w', 83);c2i.put('x', 89);c2i.put('y', 97);c2i.put('z', 101);

        Map<Long, List<String>> map = new HashMap<>();
        int i, len;
        long value;

        for (String s : strs) {
            len = s.length();
            for (i=0,value=1;i<len;i++)
                value *= c2i.get(s.charAt(i));

            List<String> tem = map.getOrDefault(value, new ArrayList<>());
            tem.add(s);
            map.put(value, tem);
        }

        return new ArrayList<>(map.values());
    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        for (String str : strs) {
//            int[] counts = new int[26];
//            int length = str.length();
//            for (int i = 0; i < length; i++) {
//                counts[str.charAt(i) - 'a']++;
//            }
//            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < 26; i++) {
//                if (counts[i] != 0) {
//                    sb.append((char) ('a' + i));
//                    sb.append(counts[i]);
//                }
//            }
//            String key = sb.toString();
//            List<String> list = map.getOrDefault(key, new ArrayList<String>());
//            list.add(str);
//            map.put(key, list);
//        }
//        return new ArrayList<List<String>>(map.values());
//    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
