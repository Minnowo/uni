
class Node 
{
    Node next;
    Integer data;

    public String toString()
    {
        return this.data.toString();
    }
}

public class LinkedList 
{
    Node head;

    public void insert(int data)
    {
        Node n = new Node();
        n.data = data;

        if(head == null)
        {
            head = n;
            return;
        }

        Node curr = this.head;
        for(; curr.next != null; curr = curr.next);

        curr.next = n;
    }

    public Node remove(Node head, int value)
    {
        if(head == null)
            return null;

        if(head.data == value)
        {
            this.head = head.next;
            head.next = null;
            return head;
        }

        if(head.next == null)
            return null;

        if(head.next.data == value)
        {
            Node n = head.next;
            head.next = head.next.next;
            n.next = null;
            return n;
        }

        return remove(head.next, value);
    }
}
