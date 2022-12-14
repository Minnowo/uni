public class Driver 
{
    public static class Employee
    {
        private String name;
        private Double rating;

        public Employee(String name, int rating)
        {
            this.name = name;
            this.rating = (double)rating;
        }

        public String getName()
        {
            return this.name;
        }

        public Double getRating()
        {
            return this.rating;
        }

        public String toString()
        {
            return this.name +" " + this.rating;
        }
    }

    public static class Node 
    {
        Node left;
        Node right;
        Employee data;

        public Node(Employee e)
        {
            this.data = e;
        }
    }

	
    public static Node DeleteLessThan(Node root, double value)
    {
        // time complexity = O(n)
        // space complexity = O(n)
        if(root == null)
        {
            return null;
        }

        // if the root value is less than what we're removing
        // set it to it's smallest child bigger than the value
        if(root.data.getRating() < value)
        {
            // replace root with it's child which meets the requirement
            root = DeleteLessThan(root.right, value);
        }

        if(root == null)
        {
            return null;
        }

        // handle left nodes which are always smaller
        root.left = DeleteLessThan(root.left, value);

        return root;
    }

    public static Node DeleteGreaterThan(Node root, double value)
    {
        // time complexity = O(n)
        // space complexity = O(n)
        if(root == null)
        {
            return null;
        }

        // if the root is bigger than the value,
        // we want to find where it's smaller in the children
        if(root.data.getRating() > value)
        {
            // set root to it's biggers child smaller than our value
            root = DeleteGreaterThan(root.left, value);
        }

        if(root == null)
        {
            return null;
        }

        // handle removing the right values which should always be bigger than our value
        root.right = DeleteGreaterThan(root.right, value);

        return root;
    }

    public static Node highPerformers(Node root, double start, double end) 
    {
        // =================
        // Total Time : O(n)
        // Total Space: O(n)
        // would be 2x these but we drop constants, this is pretty cool
        // =================

        // really simple once you get the delete functions done
        // could condense this to 1 line even
        // just remove nodes less than the start, then remove nodes greater than the end

        // Time : O(n) 
        // Space: O(n)
        root = DeleteLessThan(root, start);

        // Time : O(n) 
        // Space: O(n)
        return DeleteGreaterThan(root, end);
    }

    public static void preOrder(Node root)
    {
        // Time : O(n)
        // Space: O(n)
        if(root == null)
            return;

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void sortDescending(Node root)
    {
        // Time : O(n)
        // Space: O(n)
        if(root == null)
            return;

        // standard in order but swap left and right
        sortDescending(root.right);
        System.out.println(root.data);
        sortDescending(root.left);
    }
    public static void main(String[] args) {
        Node root = new Node(new Employee("John", 85));
        root.left = new Node(new Employee("Steve", 65));
        root.right = new Node(new Employee("Lizzy", 95));
        root.left.left = new Node(new Employee("Bill", 58));
        root.left.right = new Node(new Employee("Salma", 70));
        root.right.right = new Node(new Employee("Tim", 98));
        root.left.left.left = new Node(new Employee("Sheena", 55));
        root.left.left.right = new Node(new Employee("Jeff", 60));
        root.right.right.left = new Node(new Employee("Ben", 96));

        System.out.println("\nOriginal List of Employees");
        System.out.println("****************************");
        preOrder(root);

        System.out.println("\nList of High Performing Employees");
        System.out.println("************************************");
        preOrder(highPerformers(root, 65, 95));

        System.out.println("\nList of High Performing Employees in Sorted Order");
        System.out.println("***************************************************");
        sortDescending(highPerformers(root, 65, 95));
    }
}