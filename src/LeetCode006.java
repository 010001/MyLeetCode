/**
 * @author fangbin
 * @date 19-4-1
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * <p>比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * <p>L C I R E T O E S I I G E D H N
 *
 * <p>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * <p>请你实现这个将字符串进行指定行数变换的函数：
 *
 * <p>string convert(string s, int numRows);
 *
 * <p>示例 1:
 *
 * <p>输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRETOESIIGEDHN"
 *
 * <p>示例 2:
 *
 * <p>输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG" 解释:
 *
 * <p>L D R E O E I I E C I H N T S G
 *
 * <p>分析 比如有一个字符串 “0123456789ABCDEF”，转为zigzag
 *
 * <p>当 n = 2 时：
 *
 * <p>0 2 4 6 8 A C E
 *
 * <p>1 3 5 7 9 B D F
 *
 * <p>当 n = 3 时：
 *
 * <p>0 4 8 C
 *
 * <p>1 3 5 7 9 B D F
 *
 * <p>2 6 A E
 *
 * <p>当 n = 4 时：
 *
 * <p>0 6 C
 *
 * <p>1 5 7 B D
 *
 * <p>2 4 8 A E
 *
 * <p>3 9 F
 *
 * <p>我们发现，除了第一行和最后一行没有中间形成之字型的数字外，其他都有，而首位两行中相邻两个元素的index之差跟行数是相关的，为 2*nRows - 2,
 * 根据这个特点，我们可以按顺序找到所有的黑色元素在元字符串的位置，将他们按顺序加到新字符串里面。对于红色元素出现的位置也是有规律的，每个红色元素的位置为 j + 2*nRows-2 - 2*i,
 * 其中，j为前一个黑色元素的列数，i为当前行数。 比如当n = 4中的那个红色5，它的位置为 1 + 2*4-2 - 2*1 =
 * 5，为原字符串的正确位置。当我们知道所有黑色元素和红色元素位置的正确算法，我们就可以一次性的把它们按顺序都加到新的字符串里面。
 */
public class LeetCode006 {

    String convert(String s, int nRows) {
        if(nRows <= 1){
            return s;
        }
        String res = "";
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; ++i) {
            for (int j = i; j < s.length(); j += size) {
                res += s.charAt(j);
                int tmp = j + size - 2 * i;
                if (i != 0 && i != nRows - 1 && tmp < s.length()){
                    res += s.charAt(tmp);
                }
            }
        }
        return res;
    }

    /*public String convert(String s, int numRows) {
        List<List<Character>> strs = new ArrayList<List<Character>>();

        for(int i = 0 ; i < numRows ; i++){
            ArrayList<Character> list = new ArrayList<Character>();
            for(int j = 0 ; j < s.length();j++){
                list.add(null);
            }
            strs.add(list);
        }
        char[] chars = s.toCharArray();
        int count = 1;
        for(int i = 0,j = 0,k = 0 ; k < chars.length ; k++){
            if(count <= numRows){
                List<Character> mid = strs.get(i);
                mid.set(j,chars[k]);
                strs.set(i,mid);
                count++;
                if(count <= numRows){
                    i++;
                }

            } else {
                i--;
                j = numRows - count % numRows -1;
                List<Character> mid = strs.get(i);
                mid.set(j,chars[k]);
                strs.set(i,mid);
                if(count == numRows * 2 -1){
                    count = 0;
                    i = 0;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < strs.size();i++){
            for(int j = 0;j < strs.get(i).size();j++){
                if(null != strs.get(i).get(j)){
                    stringBuffer.append(strs.get(i).get(j));
                }
            }
        }
        return stringBuffer.toString();
    }*/

  public static void main(String[] args) {
    String str = "LEETCODEISHIRING";
    System.out.println(new LeetCode006().convert(str,4));
  }
}
