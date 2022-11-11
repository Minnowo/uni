import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Node 
{
    public Node left;
    public Node right;
    public int data;

    public Node(int data)
    {
        this.data = data;
    }

    public String toString()
    {
        return this.data + "";
    }
}


class Driver 
{
    /**
     * inserts element into given binary tree
     * @param root the root node in the tree 
     * @param value the value to insert
     * @return true if the element was inserted, else false
     */
    public static boolean insert(Node root, int value)
    {
        // while loop ^w^
        for(Node n = root; ;)
        {
            // value greator so it belongs on right side
            if(value > n.data)
            {
                // if the right node is null, add a new node with the data
                if(n.right == null)
                {
                    n.right = new Node(value);
                    return true;
                }

                // keep going
                n = n.right;
                continue;
            }
            
            // value less so it belongs on the left side
            if (value < n.data)
            {
                // if the left node is null, add a new node with the data
                if(n.left == null)
                {
                    n.left = new Node(value);
                    return true;
                }

                // keep going 
                n = n.left;
                continue;
            }

            // data was already in the tree, doesn't support duplicate elements 
            return false;
        }
    }

    public static void levelOrderTraversal(Node root)
    {
        // time complexity = O(n)
        // space complexity = O(n)
        if(root == null)
            return;

        // this is actuall a queue, thanks java
        LinkedList<Node> ll = new LinkedList<>();

        // add the root to begin the loop
        ll.add(root);

        while(!ll.isEmpty())
        {
            // get the first in item
            Node n = ll.remove(); // could use ll.poll() here but we know the list isn't empty

            // check and add left and right nodes
            if(n.left != null)
            {
                ll.add(n.left);
            }

            if(n.right != null)
            {
                ll.add(n.right);
            }

            // display 
            System.out.print(n.toString() + " ");
        }

        System.out.println();
    }


    public static void preOrder(Node root)
    {
        // runtime = O(n)
        // space   = O(n)
        if(root == null)
            return;

        System.out.print(root.toString() + " ");

        preOrder(root.left);
        preOrder(root.right);
    }


    public static void inOrderRecur(Node root)
    {
        if(root == null)
            return;

        // time complexity = O(n)
        // space complexity = O(n)
        inOrderRecur(root.left);
        System.out.print(root.toString() + " ");
        inOrderRecur(root.right);
    }

    public static void inOrder(Node root)
    {
        if(root == null)
            return;

        // time complexity = O(n)
        // space complexity = O(n)
        Stack<Node> stack = new Stack<>();

        Node curr = root;

        while(curr != null ||!stack.empty())
        {
            if(curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else 
            {
                curr = stack.pop();
                System.out.print(curr.toString() + " ");
                curr = curr.right;
            }
        }
    }


    public static void postOrder(Node root)
    {
        if(root == null)
            return;

        // time complexity = O(n)
        // space complexity = O(n)
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.toString() + " ");
    }

    public static boolean deleteNode(Node root, int value)
    {
        if(root == null)
            return false;

        Node curr = root;
        Node parent = root;
        boolean isleft = false;

        while(curr.data != value)
        {
            parent = curr;

            if(value < curr.data)
            {
                curr = curr.left;
                isleft = true;
            }
            else if(value > curr.data) 
            {
                curr = curr.right;
                isleft = false;
            }

            if(curr == null)
                return false;

            if(curr.left == null && curr.right == null)
            {
                if(isleft)
                {
                    parent.left = null;
                }
                else 
                {
                    parent.right = null;
                }

                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) 
    {
        Node root = new Node(5);

        insert(root, 5);
        insert(root, 3);
        insert(root, 15);
        insert(root, 2);
        insert(root, 4);
        insert(root, 12);
        insert(root, 25);

        System.out.println("level order traversal");
        levelOrderTraversal(root);

        System.out.println("pre order traversal");
        preOrder(root);
        System.out.println();

        System.out.println("in order recursive");
        inOrderRecur(root);
        System.out.println();

        System.out.println("in order");
        inOrder(root);
        System.out.println();

        System.out.println("post order");
        postOrder(root);
        System.out.println();

        inOrder(root);
        System.out.println();
        deleteNode(root, 25);
        inOrderRecur(root);
    }
}