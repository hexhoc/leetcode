package top_liked;

import java.math.BigInteger;

public class AddTwoNumbers {
    public static void main(String[] args) {
        var l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next =  new ListNode(3);

        var l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next =  new ListNode(4);

        var result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //TODO: Плохое решение. Нужно решить без конвертации в число
        var l1num = nodeToNum(l1);
        var l2num = nodeToNum(l2);

        return numToNode(l1num.add(l2num));
    }

    public static BigInteger nodeToNum(ListNode node) {
        var currentNode = node;
        var sb = new StringBuilder();
        while (currentNode != null) {
            sb.append(currentNode.val);
            currentNode = currentNode.next;
        }

        return new BigInteger(sb.reverse().toString());
    }

    public static ListNode numToNode(BigInteger num) {
        var numStr = new StringBuilder(num.toString()).reverse();
        var rootNode = new ListNode(Character.getNumericValue(numStr.charAt(0)));
        var currentNode = rootNode;
        for (int i = 1; i < numStr.length(); i++) {
            currentNode.next = new ListNode(Character.getNumericValue(numStr.charAt(i)));
            currentNode = currentNode.next;
        }

        return rootNode;
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
}
