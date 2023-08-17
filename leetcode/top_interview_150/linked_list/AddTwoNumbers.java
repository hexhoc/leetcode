package top_interview_150.linked_list;

import util.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        // var l1 = new ListNode(2);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(3);

        // var l2 = new ListNode(5);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        var l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        var l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        var result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var currentNode1 = l1;
        var currentNode2 = l2;
        var resultNode = new ListNode();
        var currentResultNode = resultNode;
        int shift = 0;

        while (true) {
            int sum = currentNode1.val + currentNode2.val + shift;
            shift = 0;
            if (sum >= 10) {
                shift += 1;
                sum -= 10;
            }

            currentResultNode.val = sum;
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;

            if (currentNode1 == null && currentNode2 == null) {
                if (shift > 0) {
                    currentResultNode.next = new ListNode();
                    currentResultNode.next.val = shift;
                }
                break;
            }

            if (currentNode1 == null) {
                currentNode1 = new ListNode(0);
            }

            if (currentNode2 == null) {
                currentNode2 = new ListNode(0);
            }

            currentResultNode.next = new ListNode();
            currentResultNode = currentResultNode.next;

        }

        return resultNode;
    }

}
