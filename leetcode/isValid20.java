package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class isValid20 {
    public static boolean isValid(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '[') stack.push(']');
                else if (c == '(') stack.push(')');
                else if (c == '{') stack.push('}');
                else if (stack.isEmpty() || c != stack.pop()) return false;
            }
            return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
