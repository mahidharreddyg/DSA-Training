import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthFromEnd {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first n+1 places ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both first and second until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;

        return dummy.next; // Return the head of the modified list
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoveNthFromEnd solution = new RemoveNthFromEnd();

        // Input the linked list
        System.out.println("Enter the linked list elements (space separated, end with -1):");
        ListNode head = null;
        ListNode tail = null;
        
        while (true) {
            int value = scanner.nextInt();
            if (value == -1) break;
            ListNode newNode = new ListNode(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Input the value of n
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        // Removing the nth node
        ListNode modifiedHead = solution.removeNthFromEnd(head, n);

        // Printing the modified linked list
        System.out.println("Modified linked list:");
        ListNode current = modifiedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
