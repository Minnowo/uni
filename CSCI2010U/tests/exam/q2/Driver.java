public class Driver 
{
    public static class Node 
    {
        String city;
        Node next;

        public Node(String city)
        {
            this.city = city;
        }

        public String toString()
        {
            return this.city;
        }
    }

    public static int countLinkedList(Node head)
    {
        // O(n)

        int count = 0;

        for(; head != null; head = head.next)
        {
            count++;
        }

        return count;
    }

    public static Node reverseRecursive(Node head)
    {
        // O(n) for time ans space

        // glad we did this in a lab, cause it was annoying the first time

        if(head == null)
            return null;

        // next is null, return head
        if(head.next == null)
            return head;

        // get the new head
        Node n = reverseRecursive(head.next);
        
        // set the current heads next element
        head.next.next = head;

        // remove the current heads pointer to the next
        head.next = null;

        return n;
    }

    public static Node reverseList(Node head)
    {
        // =================
        // Total Space: O(n)
        // Total Time : O(n)
        // =================

        // O(n) for time
        // find the count of the list
        int count = countLinkedList(head);

        // O(n) for time and space
        // reverse the list
        Node tail = reverseRecursive(head);

        Node newHead = tail;

        // increment the pointer until the middle of the list
        for(int i = 0; i < count/2; i++) // O(n / 2) = O(n)
        {
            newHead = newHead.next;
        }

        // return the new cut list
        return newHead;
    }

    public static void printList(Node head)
    {
        // =================
        // Total Time : O(n)
        // Total Space: O(1)
        // =================
        
        // Fill in this function
        for(; head != null; head = head.next)
        {
            if(head.next == null)
                System.out.print(head);
            else 
                System.out.print(head + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        // Test Case 1
        Node head = new Node("Toronto");
        head.next = new Node("Ottawa");
        head.next.next = new Node("Oshawa");
        head.next.next.next = new Node("Whitby");
        head.next.next.next.next = new Node("Ajax");
        head.next.next.next.next.next = new Node("Markham");
        head.next.next.next.next.next.next = new Node("Mississauga");
        head.next.next.next.next.next.next.next = new Node("Niagara");
        head.next.next.next.next.next.next.next.next = new Node("London");
        head.next.next.next.next.next.next.next.next.next = new Node("Barrie");

        System.out.println("\nTest Case 1: List with 10 city names");
        System.out.println("******************************");
        printList(head);
        
        System.out.println("\nReversed List:");
        printList(reverseList(head));

        // Test Case 2
        head = null;

        System.out.println("\n\nTest Case 2: List with no city names");
        System.out.println("******************************");
        printList(head);
        
        System.out.println("\nReversed List:");
        printList(reverseList(head));

        // Test Case 3
        head = new Node("Toronto");

        System.out.println("\n\nTest Case 3: List with only one city name");
        System.out.println("******************************");
        printList(head);
        
        System.out.println("\nReversed List:");
        printList(reverseList(head));
    }
}