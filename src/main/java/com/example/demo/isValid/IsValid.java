package com.example.demo.isValid;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.*;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
// 👍 1924 👎 0

@Slf4j
public class IsValid {

    public boolean solve(String s) {

        HashMap<Character, Character> init = new HashMap<>();
        init.put(')', '(');
        init.put(']', '[');
        init.put('}', '{');

        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if (init.containsValue(c)) {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character p = stack.pop();
                if (p != init.get(c)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    // leetcode上关于栈的题目大家可以先做20,155,232,844,224,682,496.
    public static void main(String[] args) {

        Assert.isTrue(!new IsValid().solve("){"), "");
        Assert.isTrue(!new IsValid().solve("]"), "");
        Assert.isTrue(new IsValid().solve("{[]}"), "");
        Assert.isTrue(!new IsValid().solve("([)]"), "");
        Assert.isTrue(!new IsValid().solve("(]"), "");
        Assert.isTrue(new IsValid().solve("()[]{}"), "");
        Assert.isTrue(new IsValid().solve("()"), "");
    }
}
