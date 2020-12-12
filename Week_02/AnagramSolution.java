package Week_02;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description
 * @author: zhongwenjian
 * @create: 2020-12-13 00:20
 */
public class AnagramSolution {

    // 排序法
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    // 数组表法
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 创建一个长度为26的频次数组
        int[] table = new int[26];
        // 遍历s字符串，记录每个字母出现的频次
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        // 遍历t字符串，减去出现的字符频次，如果存在频次小于0说明不是字符出现的频次不一致
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
