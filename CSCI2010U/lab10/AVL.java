
// node class 
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

// avl class 
public class AVL 
{
    Node root;

    // returns the bigger of the two values 
    public int max(int a, int b)
    {
        if(a > b)
            return a;

        return b;
    }

    // returns the nodes height or 0
    public int getHeight(Node n)
    {
        if(n == null)
            return 0;
        
        return n.height;
    }
    
    // calculates the balance factor for the given node 
    public int getBalanceFactor(Node n)
    {
        if(n == null)
            return 0;

        return getHeight(n.left) - getHeight(n.right);
    }

    // public insertion function
    public void insertion(Logs value)
    {
        this.root = insertNode(this.root, value);
    }

    // private insert function used by the public one 
    private Node insertNode(Node node, Logs logs)
    {
        if(node == null)
        {
            return new Node(logs);
        }
        
        if(logs.year < node.value.year)
        {
            // navigate down the left path
            node.left = insertNode(node.left, logs);
        }
        else if(logs.year > node.value.year)
        {
            // navigate down the right path 
            node.right = insertNode(node.right, logs);
        }
        else // no duplicates 
        {
            return node;
        }

        // update the current nodes height 
        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;

        // get the balance factor 
        int balance = getBalanceFactor(node);

        // rotate left and right as needed 
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

    // rotates the given node left
    public Node rotateLeft(Node n)
    {
        Node newRoot = n.right;
        n.right = newRoot.left;
        newRoot.left = n;
        n.height = max(getHeight(n.left), getHeight(n.right)) + 1;
        newRoot.height = max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }

    // rotates the given node right 
    public Node rotateRight(Node n)
    {
        Node newRoot = n.left;
        n.left = newRoot.right;
        newRoot.right = n;
        n.height = max(getHeight(n.left), getHeight(n.right)) + 1;
        newRoot.height = max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }

    // finds the left most node from the given root 
    private Node minValueNode(Node n)
    {
        Node c = n;

        while(c.left != null)
        {
            c = c.left;
        }

        return c;
    }

    // public delete function 
    public void deletion(int year)
    {
        this.root = deleteNode(this.root, year);
    }

    // private delete function 
    private Node deleteNode(Node node, int year)
    {
        if(node == null)
        {
            return null;
        }
        
        if(year < node.value.year)
        {
            // navigate down the left tree 
            node.left = deleteNode(node.left, year);
        }
        else if(year > node.value.year)
        {
            // navigate down the right tree 
            node.right = deleteNode(node.right, year);
        }
        else // found our value 
        {
            // if the node has 1 or 0 children, special case
            if(node.left == null || node.right == null)
            {
                Node temp = node.left;

                // left node is null, use right
                if(temp == null)
                {
                    temp = node.right;
                }

                // if both children are null, set the node to null
                // this node will now be removed from the tree from the recursive call above 
                if(temp == null)
                {
                    node = null;
                }

                // set the node to it's only child
                // this child will now take it's place in the tree 
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

                // delete the child node instead of the current node in the middle of the tree 
                node.right = deleteNode(node.right, node.value.year);
            }
        }

        // null check
        if(node == null)
            return null;

        // calculate the height of the node
        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;

        // get balance factor 
        int balance = getBalanceFactor(node);

        // rotate left and right as needed 
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

    // simple preOrder display function 
    void preOrder(Node node)
    {
        if(node == null)
            return;

        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }
}
