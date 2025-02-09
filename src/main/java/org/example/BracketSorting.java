package org.example;

import java.util.Map;
import java.util.Stack;

public class BracketSorting {

    private static final Map<Character, Character> BRACKETS = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public static void main(String[] args){

        // true if all brackets are closed in order, otherwise false

        String str1 = "({[}])";
        String str2 = "[{({})}]";

        System.out.println(isBracketsClosedInOrder(str1));
        System.out.println(isBracketsClosedInOrder(str2));

        // using java streams
        System.out.println(isBracketsInOrder(str1));
        System.out.println(isBracketsInOrder(str2));
    }

    private static boolean isBracketsClosedInOrder(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c :str.toCharArray()){
            switch (c){
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
            }
        }

        return true;
    }



    public static boolean isBracketsInOrder(String str) {
        Stack<Character> stack = new Stack<>();

        return str.chars()
                .mapToObj(c -> (char) c)
                .allMatch(c -> processBracket(stack, c));
    }

    private static boolean processBracket(Stack<Character> stack, char c) {
        if (BRACKETS.containsValue(c)) {
            stack.push(c);
        } else if (BRACKETS.containsKey(c)) {
            if (stack.isEmpty() || stack.pop() != BRACKETS.get(c)) {
                return false;
            }
        }
        return true;
    }

}
