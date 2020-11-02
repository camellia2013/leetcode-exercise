package com.example.demo.algo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;


/**
 * 单链表反转
 */
@Slf4j
public class ReverseSingleLinkedList {

    public SingleLinkedList reverse(SingleLinkedList list) {

        if (list == null) {
            return null;
        }

        ListNode prev = list.getHead();
        if (prev == null) {
            return list;
        }
        ListNode current = list.getHead().getNext();
        if (current == null) {
            return list;
        }

        prev.setNext(null);
        while (current.getNext() != null) {
            ListNode next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        current.setNext(prev);
        return new SingleLinkedList(current);
    }

    public static void main(String[] args) {

        Assert.isTrue(new ReverseSingleLinkedList().reverse(new SingleLinkedList(3, 7, 8)).toString().equals("873"), "");
        Assert.isTrue(new ReverseSingleLinkedList().reverse(new SingleLinkedList()).toString().equals(""), "");
        Assert.isTrue(new ReverseSingleLinkedList().reverse(new SingleLinkedList(3)).toString().equals("3"), "");
    }
}
