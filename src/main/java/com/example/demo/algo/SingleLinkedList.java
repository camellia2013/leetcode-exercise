package com.example.demo.algo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@AllArgsConstructor
public class SingleLinkedList {

    private ListNode head = null;


    public SingleLinkedList(int... arrays) {

        if (arrays.length == 0) {
            return;
        }

        for (int i = arrays.length - 1; i > -1; i--) {
            head = new ListNode(arrays[i], head);
        }
    }


    public static void main(String[] args) {

        System.out.println(new SingleLinkedList(1, 2, 3));
        System.out.println(new SingleLinkedList());
        System.out.println(new SingleLinkedList(1));
    }


    @Override
    public String toString() {

        if (head == null) {
            return "";
        }
        return head.toString();
    }
}
