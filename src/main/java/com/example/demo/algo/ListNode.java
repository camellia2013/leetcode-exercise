package com.example.demo.algo;


import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class ListNode {

    @NonNull
    private int val;

    @Setter
    private ListNode next;


    public static void main(String[] args) {

        log.info("{}", new ListNode(2, new ListNode(4, new ListNode(3))));
    }


    @Override
    public String toString() {

        return _toString(this);
    }


    public int toInt() {

        return Integer.parseInt(_toString(this));
    }


    private String _toString(ListNode l) {

        if (l == null) {
            return "";
        }
        if (l.next == null) {
            return String.valueOf(l.val);
        }
        return l.val + _toString(l.next);
    }
}
