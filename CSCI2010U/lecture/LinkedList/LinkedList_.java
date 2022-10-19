
public class Node 
{
    public int data; 
    public Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null; 
    }
}

public class LinkedList_
{
    Node start ;

    public void insert(int data)
    {
        Node n = new Node(data);

        if(start == null)
        {
            this.start = n;
            return;
        }

        Node curr = this.start;
        while(curr.next != null)
        {
            curr = curr.next;
        }

        curr.next = n;
    }

    public boolean search(int number)
    {
        Node n = this.start;

        while(n != null)
        {
            if(n.data == number)
                return true;

            n = n.next;
        }

        return false;
    }
}
