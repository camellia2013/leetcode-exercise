package com.example.demo.minStack;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;


@Slf4j
public class MinStack {

    private int[] v;

    private int min;

    public MinStack() {

    }


    public void push(int x) {

    }


    public void pop() {

    }


    public int top() {

        return 0;
    }


    public int getMin() {

        return 0;
    }


    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.isTrue(minStack.getMin() == -3, "");
        minStack.pop();
        Assert.isTrue(minStack.top() == 0, "");
        Assert.isTrue(minStack.getMin() == -2, "");
    }

}
