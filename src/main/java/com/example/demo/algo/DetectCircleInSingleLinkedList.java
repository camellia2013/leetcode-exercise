package com.example.demo.algo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;


/**
 * 链表中环的检测
 */
@Slf4j
public class DetectCircleInSingleLinkedList {

    public boolean detect(SingleLinkedList list) {

        return false;
    }


    public static void main(String[] args) {

        Assert.isTrue(new DetectCircleInSingleLinkedList().detect(new SingleLinkedList()), "");
        Assert.isTrue(new DetectCircleInSingleLinkedList().detect(new SingleLinkedList()), "");
    }
}
