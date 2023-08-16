package top_liked.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.ListNode;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        var s = new RemoveNthNodeFromEndOfList();
        var head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        s.removeNthFromEnd(head, 2);

        head = new ListNode(1);
        s.removeNthFromEnd(head, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        var currentNode = head;
        while (Objects.nonNull(currentNode)) {
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }
        var prevIndex = nodes.size() - n - 1;
        var nextIndex = nodes.size() - n + 1;
        if (prevIndex < 0) {
            head = nodes.size() > 1 ? nodes.get(1) : null;
        } else if (nextIndex >= nodes.size()) {
            nodes.get(prevIndex).next = null;
        } else {
            nodes.get(prevIndex).next = nodes.get(nextIndex);
        }

        return head;
    }
}

