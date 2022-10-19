package Day14;

/*
 ** @author LiGuanda
 ** @date  PM 6:30:34
 ** @description This is a description of RemoveNthFromEnd
 ** @params
 ** @return
 ** @since version-1.0  */

/*
*
*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

 

示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]
*
* */

import java.util.Arrays;

/**
 * @author Lenovo
 */
public class RemoveNthFromEnd {


    public static void main(String[] args) {

        int[] nums = {1};
        ListNode head = initListNodes(nums);
        ListNode listNode = removeNthFromEnd(head, 1);
        System.out.println("The removed list nodes of nums which is " + Arrays.toString(nums) + " is " + toStringPro(listNode));

    }


    // 初始化链表，模拟环境
    public static ListNode initListNodes(int[] nums) {

        ListNode head = null;
        // 记录当前创建的节点
        ListNode current = null;
        // 记录当前节点的后一个节点
        ListNode next = null;

        // 进行倒序遍历
        for (int i = nums.length - 1; i >= 0; i--) {

            current = new ListNode(nums[i], next);
            next = current;

        }

        return current;

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // 初始化左右的指针
        ListNode left = head;
        ListNode right = head;

        //首先让左右的指针拉开n个步长
        int k = 0;
        while (k < n) {

            right = right.next;
            k++;

        }

        // 排除删除头节点的特殊情况,避免right为null的情况
        if (right == null) {

            return left.next;

        }

        // 开始同时同向遍历链表
        while (right.next != null) {

            left = left.next;
            right = right.next;

        }

        //此时左指针已经到达待删节点的左侧
        left.next = left.next.next;
        return head;

    }


    public static class ListNode {


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


    public static String toStringPro(ListNode head) {

        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        while (head != null) {

            builder.append(head.val).append(" ");
            head = head.next;

        }

        builder.append("]");
        return builder.toString();

    }


}
