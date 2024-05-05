package problems.linked_list;

import java.util.Objects;

import util.ListNode;

/**
 * 21. Merge Two Sorted Lists
 */
public class _21_MergeTwoSortedLists {

    public static void main(String[] args) {
        var s = new _21_MergeTwoSortedLists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = s.mergeTwoLists(list1, list2);

        list1 = new ListNode(5);

        list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(4);

        list3 = s.mergeTwoLists(list1, list2);
        System.out.println(list3);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode currentNode = null;
        while (Objects.nonNull(list1) || Objects.nonNull(list2)) {
            if (currentNode == null) {
                currentNode = new ListNode();
                head = currentNode;
            } else {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }

            if (Objects.nonNull(list1) && Objects.nonNull(list2)) {
                if (list1.val < list2.val) {
                    currentNode.val = list1.val;
                    list1 = list1.next;
                } else {
                    currentNode.val = list2.val;
                    list2 = list2.next;
                }
            } else {
                if (Objects.nonNull(list1)) {
                    currentNode.val = list1.val;
                    list1 = list1.next;
                } else {
                    currentNode.val = list2.val;
                    list2 = list2.next;
                }
            }
        }

        return head;
    }

}
