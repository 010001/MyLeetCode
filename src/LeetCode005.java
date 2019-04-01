/**
 * @author fangbin
 * @date 19-3-25
 */

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * <p>示例 1：
 *
 * <p>输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
 *
 * <p>示例 2：
 *
 * <p>输入: "cbbd" 输出: "bb"
 */
public class LeetCode005 {
    public String longestPalindrome(String s) {
        String maxLen = "";
        for(int i = 0 ; i < s.length(); i++){
            int len = s.length();
            String result01 = checkStr(s,i,i);
            String result02 = checkStr(s,i,i+1);
            if(maxLen.length() < result01.length()){
                maxLen = result01;
            }
            if(maxLen.length() < result02.length()){
                maxLen = result02;
            }
        }
        return maxLen;
    }

    String checkStr(String str,int start,int end){
        String maxLengthStr = str;
        int len = str.length();
        int i = start,j = end;
        while(true){
            if(i < 0 || j == len){
                break;
            } else {
                if(str.charAt(i) == str.charAt(j)){
                    i--;
                    j++;
                    continue;
                } else {
                    break;
                }
            }
        }
        maxLengthStr = str.substring(i+1,j);
        return maxLengthStr;
    }

  public static void main(String[] args) {
    String str = "cbbd";
    System.out.println(new LeetCode005().longestPalindrome(str));
  }
}
