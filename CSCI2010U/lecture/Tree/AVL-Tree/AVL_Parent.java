
class Node 
{
    Node left;
    Node right;
    Node parent;
    int height;
    int data;

    public Node()
    {
        this.height = 1;
    }

    public Node(int data)
    {
        this.data = data;
        this.height = 1;
    }
}

public class AVL_Parent
{
    public static void main(String[] args) 
    {
        AVL_Parent p = new AVL_Parent();
        
        p.insert(5);
        p.insert(2);
        p.insert(1);
        p.insert(7);
        p.insert(21);
        p.insert(4);
        p.insert(23);

        p.inOrder();
    }



    Node root;

    public void insert(int data)
    {
        // make a new root and we're done
        if(this.root == null)
        {
            this.root = new Node(data);
            return;
        }

        Node newNode;

        for(Node node = this.root;;)
        {
            if(data < node.data)
            {
                // add our new node and set the parent 
                // we then continue to the next for loop below
                if(node.left == null)
                {
                    newNode = new Node(data);
                    newNode.parent = node;
                    node.left = newNode;
                    break;
                }

                // otherwise continue crawling 
                node = node.left;
            }
            else if(data > node.data)
            {
                // add our new node and set the parent 
                // we then continue to the next for loop below
                if(node.right == null)
                {
                    newNode = new Node(data);
                    newNode.parent = node;
                    node.right = newNode;
                    break;
                }

                // otherwise continue crawling 
                node = node.right;
            }
            else 
            {
                // we're not handling duplicates 
                return;
            }
        }

        // can't rotate if there's only 1 child 
        if(newNode.parent == this.root)
        	return;
        
        // magic happens here,
        // loop back up the tree, and rotate where needed
        for(Node node = newNode.parent, parent = node.parent;;)
        {
            // if the parent is null, `node` is this.root
        	final boolean IS_ROOT = parent == null;
            
        	final int BALANCE = getBalanceFactor(node);
        	
        	// so we know which child to set on the parent
            // if IS_ROOT is true, we don't care if it's left or right 
            final boolean IS_LEFT_NODE = IS_ROOT || parent.left == node;
            
            node.height = getMax(getHeight(node.right), getHeight(node.left)) + 1;

            Node rotated;

            // handle out of balance tree
            if(BALANCE > 1)
            {
                if(data < node.left.data)
                {
                    rotated = rightRotate(node);
                }
                else 
                {
                    node.left = leftRotate(node.left);
                    rotated = rightRotate(node);
                }
                
                // if this is our root node,
                // rotated should be our new root, and there should be no parent
                if(IS_ROOT)
                {
                	this.root = rotated;
                	this.root.parent = null;
                	return;
                }
                
                // otherwise, we need to set the parents child correctly
                if(IS_LEFT_NODE)
                    parent.left = rotated;
                else 
                    parent.right = rotated;
                
                // update our parent ref here
                rotated.parent = parent;
            } 
            
            // handle out of balance tree
            else if(BALANCE < -1)
            {
                if(data > node.right.data)
                {
                    rotated = leftRotate(node);                    
                }
                else 
                {
                    node.right = rightRotate(node.right);
                    rotated =  leftRotate(node);
                }

                // if this is our root node,
                // rotated should be our new root, and there should be no parent
                if(IS_ROOT)
                {
                	this.root = rotated;
                	this.root.parent = null;
                	return;
                }
                
                // otherwise, we need to set the parents child correctly
                if(IS_LEFT_NODE)
                    parent.left = rotated;
                else 
                    parent.right = rotated;
                
                // update our parent ref here
                rotated.parent = parent;
            }
            
            // in case the root is not out of balance, can't loop forever
            else if(IS_ROOT)
            {
            	this.root.parent = null;
            	return;
            }
            
            // continue the crawl up
            node = parent;
            parent = node.parent;
        }
    }


    public Node rightRotate(Node node)
    {
        // same standard rotation
        Node newRoot   = node.left;
        node.left      = newRoot.right;
        newRoot.right  = node;
        node.height    = getMax(   getHeight(node.left),    getHeight(node.right)) + 1;
        newRoot.height = getMax(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

        // BUT, we update the parent here
        node.parent = newRoot;

        return newRoot;
    }

    public Node leftRotate(Node node)
    {
        // same standard rotation
        Node newRoot   = node.right;
        node.right     = newRoot.left;
        newRoot.left   = node;
        node.height    = getMax(   getHeight(node.left),    getHeight(node.right)) + 1;
        newRoot.height = getMax(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

        // BUT, we update the parent here
        node.parent = newRoot;
        
        return newRoot;
    }

    public int getBalanceFactor(Node node)
    {
        if(node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public int getHeight(Node node)
    {
        if(node == null)
            return 0;
        return node.height;
    }

    public int getMax(int a, int b)
    {
        if(a > b)
            return a;
        return b;
    }
    
    public void inOrder()
    {
    	inOrder(this.root);
    }

    public void inOrder(Node root)
    {
        if(root == null)
        return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}