package leetcode;

import java.lang.reflect.Array;

/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
输入：[1,8,6,2,5,4,8,3,7]输出：49
* */
public class maxArea11 {
    public static int maxArea(int[] height) {
        int result = 0;
        for(int i = 0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                result = result>((height[i]<height[j]?height[i]:height[j])*(j-i))?result:((height[i]<height[j]?height[i]:height[j])*(j-i));
            }
        }
        return result;
    }
    public static void main(String[] args) {
 
    }
}
