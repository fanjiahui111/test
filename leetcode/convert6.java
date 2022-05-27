package leetcode;
/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows =4
输出:"LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}


作者：LeetCode
链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */
public class convert6 {
    public static String convert(String s, int numRows) {
        if(s == null||numRows<1){
            return null;
        }
        String[][] str2 = new String[numRows][s.length()];
        char[] str1 = s.toCharArray();
        int flag = 1;//flag为1的时候向下填充，为0的时候向右上填充。刚开始向下填充。
        int m,n;
        m=-1;n=0;
        if(numRows == 1){
            return s;
        }
        for(int i = 0;i<s.length();i++){
            if(flag == 1){
                m++;
                str2[m][n] = ""+str1[i];
                if(m == numRows-1){
                    flag = 0;
                }
            }
            else if(flag == 0){
                m--;n++;
                str2[m][n] = ""+str1[i];
                if(m == 0){
                    flag = 1;
                }
            }
        }
        String fin = "";
        for(int i = 0;i<numRows;i++){
            for(int j = 0;j<s.length();j++){
                if(str2[i][j]!=null){
                    fin = fin+str2[i][j];
                }
            }
        }
        return fin;
    }

    public static void main(String[] args) {
        //String[][] str = new String[2][2];
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s,4));
    }
}
