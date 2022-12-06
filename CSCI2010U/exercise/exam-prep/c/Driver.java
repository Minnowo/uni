
class Student 
{
    public int mark;
    public String name;

    public Student(String n, int a)
    {
        this.name = n;
        this.mark = a;
    }

    public String toString()
    {
        return this.name + ", " + this.mark;
    }
}

class Node 
{
    Node left;
    Node right;
    Student value;

    public Node(Student v)
    {
        this.value = v;
    }
}

public class Driver 
{
   
    public static Node updateMarks(Node root_A, Node root_B)
    {
        // time O(n)
        // space O(n)
        if(root_A == null)
            return null;

        if(root_B == null)
            return null;


        if(root_B.value.mark < root_A.value.mark)
        {
            root_B.value.mark = root_A.value.mark;
        }
        
        updateMarks(root_B.left, root_A.left);
        updateMarks(root_B.right, root_A.right);

        return root_B;
    }
    public static void preOrder(Node root)
    {
        if(root == null)
            return;

        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) 
    {
        Node quiz_A = new Node(new Student("Steve", 85));
        quiz_A.left = new Node(new Student("Bill", 65));
        quiz_A.right = new Node(new Student("Elon", 90));
        quiz_A.left.left = new Node(new Student("Jeff", 55));
        Node quiz_B = new Node(new Student("Steve", 88));
        quiz_B.left = new Node(new Student("Bill", 75));
        quiz_B.right = new Node(new Student("Elon", 90));
        quiz_B.left.right = new Node(new Student("Lizzy", 80));
        quiz_B.right.right = new Node(new Student("Sheena", 95));
        System.out.println("\nQuiz A...");
        preOrder(quiz_A);
        System.out.println("\nQuiz B...");
        preOrder(quiz_B);
        System.out.println("\nResultant Tree");

        preOrder(updateMarks(quiz_A, quiz_B));
    }
}