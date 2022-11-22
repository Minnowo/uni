
class Node 
{
    int value;
    Node left;
    Node right;
    int height;

    public Node(int value)
    {
        this.value = value;

        // has no children so it's height is 1
        this.height = 1;
    }
}

public class AVL 
{
    Node root;

    public int getMax(int a, int b)
    {
        if(a > b)
            return a;

        return b;
    }

    public int getHeight(Node node)
    {
        if(node == null)
            return 0;

        return node.height;
    }


    public int getParentHeight(Node node)
    {
        if(node == null)
            return 0;

        return getMax(getHeight(node.right), getHeight(node.left)) + 1;
    }

    public int getBalanceFactor(Node node)
    {
        if(node == null)
            return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    public void preOrder(Node n)
    {
        if(n == null)
            return;

        System.out.println(n.value + " ");
        preOrder(node.left);
        preOrder(n.right);
    }

    public Node insertNode(Node node, int value)
    {
        if(node == null)
            return new Node(value);

        if(value < node.value)
        {
            node.left = insertNode(node.left, value);
        }
        else if(value > node.value)
        {
            node.right = insertNode(node.right, value);
        }
        else 
        {
            // not taking duplicate values 
            return node;
        }
    }
}
