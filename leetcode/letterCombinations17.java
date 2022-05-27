package leetcode;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations17 {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        List<String> resultTemp = new ArrayList<>();
        String[] str = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; //i-2   5和7对应四个
        int[] in = new int[digits.length()];
        for(int i=0;i<digits.length();i++){
            in[i] = digits.charAt(i) - '0';
        }
        if(digits.length() == 0){
            return result;
        }
        if(digits.length() == 1){
            for(int i =0;i<str[in[0]-2].length();i++){
                result.add(str[in[0]-2].charAt(i)+"");
            }
            return result;
        }
        for(int i =0;i<str[in[0]-2].length();i++){
            for(int j =0;j<str[in[1]-2].length();j++){
                resultTemp.add(str[in[0]-2].charAt(i)+""+str[in[1]-2].charAt(j));
            }
        }
        if(digits.length() == 2){
            return resultTemp;
        }
        for(int i = 2;i<digits.length();i++){
            result.clear();
            result = help(resultTemp,str[in[i]-2]);
            resultTemp.clear();
            for(int j = 0;j< result.size();j++){
                resultTemp.add(result.get(j));
            }
        }


        return result;
    }
    public static List<String> help(List<String> list,String str){
        List<String> result = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            for(int j = 0;j<str.length();j++){
                result.add(list.get(i)+str.charAt(j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2345"));
    }
}
/**
 * class Solution {
 *     public List<String> letterCombinations(String digits) {
 *         List<String> combinations = new ArrayList<String>();
 *         if (digits.length() == 0) {
 *             return combinations;
 *         }
 *         Map<Character, String> phoneMap = new HashMap<Character, String>() {{
 *             put('2', "abc");
 *             put('3', "def");
 *             put('4', "ghi");
 *             put('5', "jkl");
 *             put('6', "mno");
 *             put('7', "pqrs");
 *             put('8', "tuv");
 *             put('9', "wxyz");
 *         }};
 *         backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
 *         return combinations;
 *     }
 *
 *     public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
 *         if (index == digits.length()) {
 *             combinations.add(combination.toString());
 *         } else {
 *             char digit = digits.charAt(index);
 *             String letters = phoneMap.get(digit);
 *             int lettersCount = letters.length();
 *             for (int i = 0; i < lettersCount; i++) {
 *                 combination.append(letters.charAt(i));
 *                 backtrack(combinations, phoneMap, digits, index + 1, combination);
 *                 combination.deleteCharAt(index);
 *             }
 *         }
 *     }
 * }
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * */