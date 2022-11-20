import java.util.Stack;

class Node
{
    Student student;
    Node left;
    Node right;
    Node(Student student)
    {
        this.student = student;
    }
}

public class Driver 
{
    static int sum;
    static int count;

    public static void getAverageAge(Node node)
    {
        // time complexity = O(n1) + O(n2) = O(n)
        // space complexity = O(1)

        // init sum and count
        int count = 0;
        int sum = 0;

        // null check
        if(node == null)
            return; 

        // set state for just root node
        count = 1;
        sum = node.student.age;

        // add the count and sum for all the nodes left of root
        for(Node n = node.left; n != null; n = n.left) // O(n1)
        {
            if(n.right != null)
            {
                count++;
                sum += n.right.student.age;
            }

            count++;
            sum += n.student.age;
        }

        // add the count and sum for all the nodes right of root
        for(Node n = node.right; n != null; n = n.right) // O(n2)
        {
            if(n.left != null)
            {
                count++;
                sum += n.left.student.age;
            }

            count++;
            sum += n.student.age;
        }

        // update static variables 
        Driver.count = count;
        Driver.sum = sum;
    }

    public static int getAverage(Node root)
    {
        // time complexity = O(n)
        // space complexity = O(1)

        // calculate the average age
        getAverageAge(root); // O(n)

        // division by zero check
        if(count == 0)
            return -1;

        // return the average
        return sum / count;
    }

    public static Node getMinimum(Node root)
    {
        // time complexity = O(n)
        // space complexity = O(1)
        
        // get the leftmost root in the tree
        for(Node n = root; n != null; n = n.left) // O(n)
        {
            if(n.left == null)
                return n;
        }

        return root;
    }

    public static Node getMaximum(Node root)
    {
        // time complexity = O(n)
        // space complexity = O(1)

        // get the rightmost root in the tree
        for(Node n = root; n != null; n = n.right) // O(n)
        {
            if(n.right == null)
                return n;
        }

        return root;
    }

    public static void printNodes(Node root)
    {
        // time complexity = O(n)
        // space complexity = O(n)

        // implementing in order traversal with a stack
        Stack<Node> s = new Stack<>(); // this makes it O(n) space

        // set our current node
        Node c = root;

        // O(n) time because we're printing all nodes
        while(!s.empty() || c != null)
        {
            // if c is not null add it to the stack,
            // this adds all the left nodes to the stack first
            if(c != null)
            {
                s.push(c);
                c = c.left;
            }

            // once all the leftnodes have been added,
            // we can pop them, print them, and set the curr to their right node
            // so that the loop can traverse down the new branch right node
            else 
            {
                c = s.pop();
                System.out.println(c.student);
                c = c.right;
            }
        }
    }

    public static void main(String[] args) 
    {
        Node root = new Node(new Student("Steve Jobs", 55));
        root.left = new Node(new Student("Elon Musk", 45));
        root.right = new Node (new Student("Bill Gates", 75));
        root.left.left = new Node (new Student("Ben Stokes", 40));
        root.left.right = new Node (new Student("Angelina Jolie", 48));
        root.right.left = new Node(new Student("Warren Buffet", 72));
        root.right.right = new Node(new Student("Lizzy Bank", 80)); 

        System.out.println("\nList of Students");
        System.out.println("***********************");
        printNodes(root);
        System.out.println("\nClass Statistics");
        System.out.println("***********************");
        System.out.println("Youngest Student: " + getMinimum(root).student.toString());
        System.out.println("Oldest Student: " + getMaximum(root).student.toString());
        System.out.println("Average Age of Students: " + getAverage(root));
    }

}