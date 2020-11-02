package com.example.demo.addTwoNumbers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 5066 👎 0


/**
 * 递归方式
 * 非递归方式, 有递归转化为非递归的规则吗?
 * 注意:
 * <ol>
 *     <li>进位</li>
 *     <li>两个数的位数不一定一样</li>
 * </ol>
 */
@Slf4j
public class RecursionAddTwoNumbers {

    public static void main(String[] args) {

        int actual = new RecursionAddTwoNumbers().addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        ).toInt();
        int expected = 807;
        Assert.isTrue(actual == expected, String.format("%s, should be %s", actual, expected));

        actual = new RecursionAddTwoNumbers().addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6))
        ).toInt();
        expected = 407;
        Assert.isTrue(actual == expected, String.format("%s, should be %s", actual, expected));
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return _add(l1, l2, false);
    }


    private ListNode _add(ListNode l1, ListNode l2, boolean carry) {

        if (l1 == null && l2 == null) {
            if (carry) {
                return new ListNode(1);
            } else {
                return null;
            }
        } else if (l1 == null) {
            if (carry) {
                return new ListNode((l2.val + 1) % 10, _add(null, l2.next, (l2.val + 1 > 9)));
            } else {
                return new ListNode(l2.val, _add(null, l2.next, false));
            }
        } else if (l2 == null) {
            if (carry) {
                return new ListNode((l1.val + 1) % 10, _add(l1.next, null, (l1.val + 1 > 9)));
            } else {
                return new ListNode(l1.val, _add(l1.next, null, false));
            }
        } else {
            if (carry) {
                return new ListNode((l1.val + l2.val + 1) % 10, _add(l1.next, l2.next, (l1.val + l2.val + 1 > 9)));
            } else {
                return new ListNode((l1.val + l2.val) % 10, _add(l1.next, l2.next, (l1.val + l2.val > 9)));
            }
        }
    }
}
