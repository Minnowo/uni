
class Node
{
    Country country;
    Node next;
 
    Node(Country country)
    {
        this.country = country;
    }
}

public class Driver 
{
    public static void displayLinkedList(Node node)
    {
        // for loop to print each nodes country
        for(Node n = node; n != null; n = n.next)
        {
            // print the country 
            System.out.println(n.country);
        }
    }

    public static Node sortDescending(Node head)
    {
        // head is null can't do anything with that
        if(head == null)
            return null;

        // head.next is null we can't set it's next to the head
        // so return it here
        if(head.next == null)
            return head;

        // get the new head
        Node n = sortDescending(head.next);
        
        // set the current heads next element to point to the head
        head.next.next = head;

        // remove the current heads pointer to the next node
        head.next = null;

        // return the new head
        return n;
    }

    public static void main(String[] args) 
    {
        Node head = new Node(new Country("Australia", 25499884));
        head.next = new Node(new Country("Canada", 37742154));
        head.next.next = new Node(new Country("United States", 338289857));
        head.next.next.next = new Node(new Country("India", 1417173173));
        head.next.next.next.next = new Node(new Country("China", 1425887337));
        System.out.println("\nOriginal Linked List:");
        System.out.println("*********************");
        displayLinkedList(head);
        System.out.println("\nSorted Linked List:");
        System.out.println("*********************");
        displayLinkedList(sortDescending(head));
    }
}