
class Node 
{
    Logs value;
    Node left;
    Node right;
    int height ;

    public Node(Logs l)
    {
        this.value = l;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public String toString()
    {
        return value.toString();
    }
}

public class AVL 
{
    Node root;

    public int max(int a, int b)
    {
        if(a > b)
            return a;

        return b;
    }

    public int getHeight(Node n)
    {
        if(n == null)
            return 0;
        
        return n.height;
    }
    
    public int getBalanceFactor(Node n)
    {
        if(n == null)
            return 0;

        return getHeight(n.left) - getHeight(n.right);
    }

    public void insertion(Logs value)
    {
        this.root = insertNode(this.root, value);
    }

    private Node insertNode(Node node, Logs logs)
    {
        if(node == null)
        {
            return new Node(logs);
        }
        
        if(logs.year < node.value.year)
        {
            node.left = insertNode(node.left, logs);
        }
        else if(logs.year > node.value.year)
        {
            node.right = insertNode(node.right, logs);
        }
        else // no duplicates 
        {
            return node;
        }

        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = getBalanceFactor(node);

        if(balance > 1)
        {
            if(logs.year < node.left.value.year)
            {
                return rotateRight(node);
            }
            else 
            {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if(balance < -1)
        {
            if(logs.year > node.right.value.year)
            {
                return rotateLeft(node);
            }
            else 
            {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }   

    public Node rotateLeft(Node n)
    {
        Node newRoot = n.right;
        n.right = newRoot.left;
        newRoot.left = n;
        n.height = max(getHeight(n.left), getHeight(n.right)) + 1;
        newRoot.height = max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }

    public Node rotateRight(Node n)
    {
        Node newRoot = n.left;
        n.left = newRoot.right;
        newRoot.right = n;
        n.height = max(getHeight(n.left), getHeight(n.right)) + 1;
        newRoot.height = max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }

    private Node minValueNode(Node n)
    {
        Node c = n;

        while(c.left != null)
        {
            c = c.left;
        }

        return c;
    }

    public void deletion(int year)
    {
        this.root = deleteNode(this.root, year);
    }

    private Node deleteNode(Node node, int year)
    {
        if(node == null)
        {
            return null;
        }
        
        if(year < node.value.year)
        {
            node.left = deleteNode(node.left, year);
        }
        else if(year > node.value.year)
        {
            node.right = deleteNode(node.right, year);
        }
        else // found our value 
        {
            if(node.left == null || node.right == null)
            {
                Node temp = node.left;

                if(temp == null)
                {
                    temp = node.right;
                }

                // if both children are null, set the node to null
                if(temp == null)
                {
                    node = null;
                }

                // set the node to it's only child
                else 
                {
                    node = temp;
                }
            }
            else 
            {
                // get the next node larger than the current node
                Node temp = minValueNode(node.right);
                
                // override the current value with the next value
                node.value = temp.value;

                // delete the child node
                node.right = deleteNode(node.right, node.value.year);
            }
        }

        if(node == null)
            return null;

        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = getBalanceFactor(node);

        if(balance > 1)
        {
            if(year < node.left.value.year)
            {
                return rotateRight(node);
            }
            else 
            {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if(balance < -1)
        {
            if(year > node.right.value.year)
            {
                return rotateLeft(node);
            }
            else 
            {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    void preOrder(Node node)
    {
        if(node == null)
            return;

        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }
}
