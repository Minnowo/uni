

public class HashMap 
{
    Node[] table;
    int size;

    public HashMap(int size)
    {
        this.size = size;
        this.table = new Node[size];
    }

    protected int hashValue(int value)
    {
        return value % this.size;
    }

    public void put(int key, int value)
    {
        int hash = hashValue(value);

        Node node = this.table[hash];

        if(node == null)
        {
            this.table[hash] = new Node(key, value);
            return;
        }
        
        for(node.next != null; node = node.next)
        {
            if(node.key == key)
            {
                node.value = value;
                return;
            }
        }

        // if there is only 1 node in the list, node.next is null, so we need to check the key
        if(node.key == key)
        {
            node.value = value;
            return;
        }

        node.next = new Node(key, value);
    }
}
