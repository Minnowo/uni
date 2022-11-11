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
}

public class Driver 
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

    // space complexity for tree = O(n)
    public static class BinarySearchTree 
    {
        Node root;

        public void insert(int value)
        {
            // time = O(n)
            // space = O(1)
            if(this.root == null)
            {
                this.root = new Node(value);
                return;
            }

            Node curr = this.root;

            while(true)
            {
                if(value < curr.data)
                {
                    if(curr.left == null)
                    {
                        curr.left = new Node(value);
                        return;
                    }

                    curr = curr.left;
                    continue;
                }

                if(value > curr.data)
                {
                    if(curr.right == null)
                    {
                        curr.right = new Node(value);
                        return;
                    }

                    curr = curr.right;
                    continue;
                }

                return;
            }
        }

        public Node search(int value)
        {
            // time complexity = O(n)
            // space complexity = O(1)
            if(this.root == null)
            {
                return null;
            }

            for(Node n = this.root ;;)
            {
                if(value > n.data)
                {
                    if(n.right == null)
                    {
                        return null;
                    }

                    n = n.right;
                    continue;
                }

                if(value < n.data)
                {
                    if(n.left == null)
                    {
                        return null;
                    }

                    n = n.left;
                    continue;
                }

                return n;
            }
        }

        public void insertionRecur2(int value)
        {
            root = insertNode_recursion(root, value);
        }

        private Node insertionRecur2(Node root, int value)
        {
            if (root == null)
            {
                root = new Node(value);
                return root;
            }
            else if (value < root.value)
            {
                root.left = insertionRecur2(root.left, value);
            }
            else
            {
                root.right = insertionRecur2(root.right, value);
            }
            return root;
        }

        public void insertRecur(int value)
        {
            if(this.root == null)
            {
                this.root = new Node(value);
                return;
            }
            insertRecur(root, value);
        }

        private void insertRecur(Node r, int value)
        {
            if(r == null)
                return;

            if(value > r.data)
            {
                if(r.right == null)
                {
                    r.right = new Node(value);
                    return;
                }

                insertRecur(r.right, value);
                return;
            }

            if(value < r.data)
            {
                if(r.left == null)
                {
                    r.left = new Node(value);
                    return;
                }

                insertRecur(r.left, value);
            }
        }

        public void printNode()
        {
            // time complexity = O(n)
            // space complexity = O(n)
            Stack<Node> stack = new Stack<>();

            Node curr = this.root;

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
                    System.out.println(curr.data);
                    curr = curr.right;
                }
            }
        }

        public void display()
        {
            this.display(this.root, "");
        }

        private void display(Node r, String spaces)
        {
            if(r == null)
                return;
            
            System.out.println(spaces + r.data);
            display(r.left, spaces + " ");
            display(r.right, spaces + " ");
        }
    }

    public static void display(Node root, String spaces)
    {
        if(root == null)
            return;
        
        System.out.println(spaces + root.data);
        display(root.left, spaces + " ");
        display(root.right, spaces + " ");
    }

    public static void main(String[] args) 
    {
        // 5 10 2 11 1 3 20 15 90
        
        // Node root = new Node(5);

        // insert(root, 5);
        // insert(root, 10);
        // insert(root, 2);
        // insert(root, 11);
        // insert(root, 1);
        // insert(root, 3);
        // insert(root, 20);
        // insert(root, 15);
        // insert(root, 90);

        // display(root, "");

        BinarySearchTree bst = new BinarySearchTree();

        bst.insertRecur2(5);
        bst.insertRecur2(10);
        bst.insertRecur2(2);
        bst.insertRecur2(11);
        bst.insertRecur2(1);
        bst.insertRecur2(3);
        bst.insertRecur2(20);
        bst.insertRecur2(15);
        bst.insertRecur2(90);

        // bst.display();
        bst.printNode();

        System.out.println(bst.search(5));
        System.out.println(bst.search(9999));
    }
}
