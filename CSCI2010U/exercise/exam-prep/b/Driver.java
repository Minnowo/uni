
class Node 
{
    Node next;
    String value;

    public Node(String v)
    {
        this.value = v;
    }
}

public class Driver 
{
    public static Node removeCitiesWithO(Node head)
    {
        // time  = O(n^2) (contains is o(n))
        // space = O(n)
        if(head == null)
            return null;

        head.next = removeCitiesWithO(head.next);

        // contains is o(n)
        if(head.value.contains("o") || head.value.contains("O"))
        {
            return head.next;
        }

        return head;
    }

    public static void printList(Node head)
    {
        for(Node n = head; n != null; n = n.next)
        {
            System.out.print(n.value + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Node head = new Node("Toronto");
        head.next = new Node("Oshawa");
        head.next.next = new Node("Ajax");
        head.next.next.next = new Node("Whitby");
        head.next.next.next.next = new Node("Markham");
        System.out.println("\nOriginal Linked List...");
        printList(head);
        System.out.println("\n\nModified Linked List...");
        printList(removeCitiesWithO(head));
    }
}