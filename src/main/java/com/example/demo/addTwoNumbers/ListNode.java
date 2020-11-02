package com.example.demo.addTwoNumbers;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    @Override
    public String toString() {

        return _toString(this);
    }


    public int toInt() {

        return Integer.parseInt(_toString(this));
    }

    private String _toString(ListNode l) {

        if (l.next == null) {
            return String.valueOf(l.val);
        }
        return _toString(l.next) + l.val;
    }


    public static void main(String[] args) {
        log.info("{}", new ListNode(2, new ListNode(4, new ListNode(3))));
    }
}
