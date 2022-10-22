

public class LinkedList_ 
{
    Node head, tail;
    int size;

    public LinkedList_()
    {
        this.size = 0;
    }

    public void removeLast()
    {
        if(this.size == 0)
            return;

        _removeLast();
    }

    private void _removeLast()
    {
        this.tail.prev.next = null;
        this.tail = this.tail.prev;
        this.size --;
    }

    public void removeFirst()
    {
        if(this.size == 0)
            return;

        this._removeFirst();
    }

    private void _removeFirst()
    {
        this.head.next.prev = null;
        this.head = this.head.next;
        this.size--;
    }

    public void removeAt(int index)
    {
        if(this.head == null || this.size <= index || index < 0)
            return;

        if(this.size == 1)
        {
            this.head = null;
            this.tail = null;
            this.size = 0;
            
            return;
        }

        if(index == 0)
        {
            _removeFirst();
            return;
        }

        if(index == this.size - 1)
        {
            _removeLast();
            return;
        }

        Node curr = this.head;

        for(int i = 0; i < index; i++)
        {
            curr = curr.next;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        this.size--;
    }


    public void insertElement(int data)
    {
        Node n = new Node(data);

        if(this.head == null)
        {
            this.head = n;
            this.tail = n; // ??? 
            this.size = 1;
            return; 
        }

        this.tail.next = n;
        n.prev = this.tail;
        this.tail = n;

        this.size++;
        // this works??? i think, razi you good 


        // Node curr = this.head;

        // while(curr.next != null)
        // {
        //     curr = curr.next;
        // }

        // this.tail = n;
        // curr.next = tail;
        // this.tail.prev = curr;

    }

    public int getSize()
    {
        return this.size;
    }

    public String toString()
    {
        if(this.head == null)
         return "[]";

        Node n = this.head;

        StringBuilder sb = new StringBuilder("[");

        while(n.next != null)
        {
            sb.append(n.data + ", ");

            n = n.next;
        }

        sb.append(n.data + "]");

        return sb.toString();
    }
}
