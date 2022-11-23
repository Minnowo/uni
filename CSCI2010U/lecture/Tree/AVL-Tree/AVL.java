import java.util.Stack;

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


public class AVL {
    
    Node root;

    public void insert(int value)
    {
        root = insertNode(root, value);
    }

    // using a stack
    public void insert2(int value)
    {
<<<<<<< HEAD
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
=======
        if(this.root == null)
        {
            this.root = new Node(value);
>>>>>>> 780d9828099e26e97bd3fa5a297b747909f1ff6c
            return;
        }

        Stack<Node> s = new Stack<>();
        
        Node c = this.root;
        
        while(true)
        {
        	if(value < c.value) // left
        	{
        		s.push(c);
        		
        		if(c.left == null)
        		{
        			c.left = new Node(value);
        			break;
        		}
        		
        		c = c.left;
        		continue;
        	}
        	
        	if(value > c.value) // right 
        	{
        		s.push(c);
        		
        		if(c.right == null)
        		{
        			c.right = new Node(value);
        			break;
        		}
        		
        		c = c.right;
        		continue;
        	}
        	
            // no duplicates punk
        	return;
        }

        
        while(!s.isEmpty())
        {
        	Node newP = null;
        	Node node = s.pop();
        	
            // apparently you have to do this, for the entire path down
        	node.height = getMax(getHeight(node.left), getHeight(node.right)) + 1;
            int balanceFactor = getBalanceFactor(node);

            if (balanceFactor > 1)
            {
                if (value < node.left.value)
                {
                	
                    newP = rightRotate(node);
                }
                else
                {
                    node.left = leftRotate(node.left);
                    newP = rightRotate(node);
                }
            }
            
            if (balanceFactor < -1)
            {
                if (value > node.right.value)
                {
                    newP = leftRotate(node);
                }
                else
                {
                    node.right = rightRotate(node.right);
                    newP = leftRotate(node);
                }
            }
            
            if(newP == null)
            	continue;
            
            // peek fails on empty stack, assume we're at the root 
            if(s.isEmpty())
            {
            	this.root = newP;
            	return;
            }
            	
            // get the parent of the node
            Node p = s.peek(); 
            
            // check the path it took going down
            if(value < p.value)
            {
            	p.left = newP;
            }
            else 
            {
            	p.right = newP;
            }
        }
    }

    // using recursion 
    private Node insertNode(Node node, int value)
    {
        if (node == null)
        {
            return new Node(value);
        }
        if (value < node.value)
        {
            node.left = insertNode(node.left, value);
        }
        else if (value > node.value)
        {
            node.right = insertNode(node.right, value);
        }
        else
        {
            return node;
        }


        node.height = getMax(getHeight(node.left), getHeight(node.right)) + 1;
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1)
        {
            if (value < node.left.value)
            {
                return rightRotate(node);
            }
            else
            {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1)
        {
            if (value > node.right.value)
            {
                return leftRotate(node);
            }
            else
            {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    Node rightRotate(Node node)
    {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = getMax(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = getMax(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }
    Node leftRotate(Node node)
    {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = getMax(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = getMax(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }

    int getHeight(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return node.height;
    }

    int getMax(int a, int b)
    {
        return (a > b) ? a : b;
    }

    int getBalanceFactor(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void inOrder()
    {
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(Node node)
    {
        if(node == null)
            return;

        inOrder(node.left);
        System.out.print(node.value + ", ");
        inOrder(node.right);
    }

    public void preOrder()
    {
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(Node node)
    {
        if(node == null)
            return;

        System.out.print(node.value + ", ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
}