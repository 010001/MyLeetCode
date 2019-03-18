/**
 * @author fangbin
 * @date 19-3-18
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * <p>示例 1:
 *
 * <p>输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * <p>示例 2:
 *
 * <p>输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * <p>示例 3:
 *
 * <p>输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode003 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> indexMap = new HashMap<Character,Integer>();
        char[] chars = s.toCharArray();
        int totalNum = 0;
        int j = 0;
        int length = chars.length;
        for(int i = 0 ; i < length ; i++){
            if(indexMap.containsKey(s.charAt(i))){
                j = Math.max(j,indexMap.get(s.charAt(i)));
            }
            totalNum = Math.max(totalNum,i-j+1);
            indexMap.put(s.charAt(i),i+1);
        }
        return  totalNum;
    }

  public static void main(String[] args) {
    String str = " ";
    System.out.println(new LeetCode003().lengthOfLongestSubstring(str));
    ;
  }
}
