package Day18;

import java.util.Arrays;

/**
 * @author LiGuanda
 * @date PM 7:57:12
 * @description This is a description of SwapPairs
 * @since version-1.0
 */

/*
*
* 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

 

示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]
*
* */

public class SwapPairs {


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        ListNode listNode = initListNode(nums);
        ListNode swappedListNode = swapPairs(listNode);
        System.out.println("The result of swapping the listNodes that is " + Arrays.toString(nums) + " is " + toStringPro(swappedListNode));

    }


    public static ListNode swapPairs(ListNode head) {

        // 如果链表深度小于2，则直接返回
        if (head == null || head.next == null) {

            return head;

        }

        // 解决进行第一次交换的额特殊情况
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        // 用于标记该链表的头结点，用于进行返回(第二个节点一定会被移动至头结点的位置)
        ListNode mark = fakeHead.next.next;
        subSwapListNode(fakeHead);
        return mark;

    }

    public static void subSwapListNode(ListNode prevNode) {

        // 如果剩余节点少于2个，则终止递归
        if (prevNode.next == null || prevNode.next.next == null) {

            return;

        }

        // 定义一个临时节点，用于暂时标记head节点
        ListNode tempHead = prevNode.next;

        // 前节点连接当前组的后一个
        prevNode.next = prevNode.next.next;
        // 当前组的前一个连接后节点
        tempHead.next = tempHead.next.next;
        // 当前组的后一个连接当前组的前一个
        prevNode.next.next = tempHead;

        subSwapListNode(prevNode.next.next);

    }


    public static String toStringPro(ListNode node) {

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (node != null) {

            builder.append(node.val).append(" ");
            node = node.next;

        }
        builder.append("]");
        return builder.toString();

    }


    public static ListNode initListNode(int[] nums) {

        ListNode listNode = new ListNode();
        ListNode nodePointer = listNode;
        for (int i : nums) {

            nodePointer.next = new ListNode(i, null);
            nodePointer = nodePointer.next;

        }
        return listNode.next;

    }


}


class ListNode {


    int val;
    ListNode next;


    ListNode() {


    }


    ListNode(int val) {

        this.val = val;

    }


    ListNode(int val, ListNode next) {

        this.val = val;
        this.next = next;

    }


}




