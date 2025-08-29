package com.aleksgolds.bell.integrator.developer.tests;

import java.util.Map;
import java.util.Stack;

public class Task4 {

    public static void main(String[] args) {
        System.out.println(isBalanced("    "));      // false
        System.out.println(isBalanced(null));        // false
        System.out.println(isBalanced(""));          // false
        System.out.println(isBalanced("()"));        // true
        System.out.println(isBalanced("({[]})"));    // true
        System.out.println(isBalanced("(]"));        // false
        System.out.println(isBalanced("([)]"));      // false
    }

    public static boolean isBalanced(String s) {
        if (s == null || s.isBlank()) return false;

        Map<Character, Character> pairs = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (pairs.containsValue(ch)) { // открывающая
                stack.push(ch);
            } else if (pairs.containsKey(ch)) { // закрывающая
                if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
