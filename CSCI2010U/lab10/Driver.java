
public class Driver 
{
    public static void main(String[] args) 
    {
        AVL tree = new AVL();
        tree.insertion(new Logs("Steve", "Create Faculty Table", 2010));
        tree.insertion(new Logs("Bill", "Create Student Table", 2011));
        tree.insertion(new Logs("Elon", "Create Staff Table", 2012));
        tree.insertion(new Logs("John", "Upated Faculty Table", 2013));
        tree.insertion(new Logs("Amen", "Deleted Faculty Table", 2014));
        tree.insertion(new Logs("Juli", "Deleted Faculty Table", 2009));
        tree.insertion(new Logs("Jeff", "Updated Staff Table", 2008));
        tree.insertion(new Logs("Mark", "Deleted Faculty Table", 2015));
        tree.insertion(new Logs("Jack", "Updated Student Table", 2016));
        System.out.println("\nOriginal Log entries");
        System.out.println("***************************************");
        tree.preOrder(tree.root);
        tree.deletion(2014);
        tree.deletion(2009);
        tree.deletion(2015);
        System.out.println("\n\nLogs after clearing duplicate entries");
        System.out.println("***************************************");
        tree.preOrder(tree.root);
    }
}
