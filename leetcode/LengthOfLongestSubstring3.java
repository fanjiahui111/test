package leetcode;
        //输入: "abcabcbb"
        //输出: 3
        //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
public class LengthOfLongestSubstring3 {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null||s == ""){
            return 0;
        }
        char[] str = s.toCharArray();
        int maxLength=0;
        int i = 0;
        for(int j = 0;j<s.length();j++){
            for(int n = i;n<=j;n++){
                if(j<s.length()-1) {
                    if (str[j + 1] == str[n]) {
                        maxLength = maxLength > (j - i + 1) ? maxLength : (j - i + 1);
                        i = n + 1;
                    }
                }
            }
            maxLength = maxLength>(j-i+1)?maxLength:(j-i+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
/**
 * class Solution {
 *     public int lengthOfLongestSubstring(String s) {
 *         if (s.length()==0) return 0;
 *         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 *         int max = 0;
 *         int left = 0;
 *         for(int i = 0; i < s.length(); i ++){
 *             if(map.containsKey(s.charAt(i))){
 *                 left = Math.max(left,map.get(s.charAt(i)) + 1);
 *             }
 *             map.put(s.charAt(i),i);
 *             max = Math.max(max,i-left+1);
 *         }
 *         return max;
 *
 *     }
 * }
 *
 * 作者：powcai
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
