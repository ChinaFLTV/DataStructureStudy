package Day16;

/*
 ** @author LiGuanda
 ** @date  PM 4:23:57
 ** @description This is a description of MergeTwoLists
 ** @params
 ** @return
 ** @since version-1.0  */

/*
*
* 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

示例 1：


输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]
*
* */

/**
 * @author Lenovo
 */
public class MergeTwoLists {


    public static void main(String[] args) {

        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode list1 = initListNode(nums1);
        ListNode list2 = initListNode(nums2);
        ListNode listNode = mergeTwoLists(list1, list2);
        System.out.println("The merge of the two listNodes which are " + toStringPro(list1) + " and " + toStringPro(list2) + " is " + toStringPro(listNode));


    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 若一方为空，则直接返回另一方，同时也可以处理二者全为空的情况
        if (list1 == null) {

            return list2;

        }
        if (list2 == null) {

            return list1;

        }
        // 初始化专门指向原数组的指针
        ListNode nodePointer1 = list1;
        ListNode nodePointer2 = list2;

        //初始化储存合并后的结果的数组
        ListNode mergeListNode = new ListNode();
        // 初始化专门指向合并数组的指针
        ListNode nodePointer = mergeListNode;

        // 开始双指针同向遍历(全不为空的情况)
        while (nodePointer1 != null && nodePointer2 != null) {

            if (nodePointer1.val <= nodePointer2.val) {

                nodePointer.next = new ListNode(nodePointer1.val, null);
                nodePointer = nodePointer.next;
                nodePointer1 = nodePointer1.next;

            } else {

                nodePointer.next = new ListNode(nodePointer2.val, null);
                nodePointer = nodePointer.next;
                nodePointer2 = nodePointer2.next;

            }

        }

        // 说明此时list1已经遍历到尾了，则把list2剩余的直接添加到合并数组的末尾即可，反之亦然
        if (nodePointer1 == null) {

            while (nodePointer2 != null) {

                nodePointer.next = new ListNode(nodePointer2.val, null);
                nodePointer = nodePointer.next;
                nodePointer2 = nodePointer2.next;

            }

        } else {

            while (nodePointer1 != null) {

                nodePointer.next = new ListNode(nodePointer1.val, null);
                nodePointer = nodePointer.next;
                nodePointer1 = nodePointer1.next;

            }

        }

        // 因为第一个元素在初始化时为空，所以数据应从第二个元素开始
        return mergeListNode.next;

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
