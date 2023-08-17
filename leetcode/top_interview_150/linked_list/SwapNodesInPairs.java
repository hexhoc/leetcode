package top_interview_150.linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.ListNode;

/**
 * 24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        var s = new SwapNodesInPairs();

        System.out.println(s.swapPairs(new ListNode()));

        var head = new ListNode(1);
        System.out.println(s.swapPairs(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(s.swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode currentNode = head.next;
        ListNode prevNode = head;
        List<ListNode> nodes = new ArrayList<>();
        while(Objects.nonNull(currentNode)) {
            nodes.add(currentNode);
            nodes.add(prevNode);

            prevNode = currentNode.next;
            currentNode = Objects.nonNull(currentNode.next) ? currentNode.next.next : null;
            if (currentNode == null) {
                nodes.add(prevNode);
            }
        }

        if (nodes.size() > 0) {
            head = nodes.get(0);
            currentNode = nodes.get(0);
            if (Objects.nonNull(nodes.get(nodes.size() - 1))) {
                nodes.get(nodes.size() - 1).next = null;
            }
            for (int i = 1; i < nodes.size(); i++) {
                currentNode.next = nodes.get(i);
                currentNode = currentNode.next;
            }
        }
        return head;
    }
}
