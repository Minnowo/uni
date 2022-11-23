

public class Driver 
{
    public static void main(String[] args) 
    {
        AVL a = new AVL();

        a.insert2(0);
        a.insert2(2);
        a.insert2(8);
        a.insert2(5);
        a.insert2(7);
        a.insert2(20);

        a.inOrder();
        a.preOrder();
    }
}
