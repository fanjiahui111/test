package leetcode;
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */

public class LongestPalindrome5 {
    public static String longestPalindrome(String s) {
        if(s.length()==0){
            return null;
        }
        char[] str = s.toCharArray();
        int longest = 0;
        String temp = null;
        int i,j;
        for(i = 0;i<s.length();i++){
            for(j = s.length()-1;j>=i;j--){
                if(str[i]==str[j]){
                    if(j-i+1>longest){
                        longest = j-i+1;
                        temp =""+str[i];
                    }
                    break;
                }
            }
        }
        if(temp == null){
            return null;
        }
        char[] fin = temp.toCharArray();
        if(fin.length==0){
            return null;
        }
        else{
            int m = 0;
            String res ="";
            for(m = 0;m<s.length();m++){
                if(str[m] == fin[0]){
                    break;
                }
            }
            for(int n = m;n<m+longest;n++){
                res = res+str[n];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(longestPalindrome(s));
    }
}
