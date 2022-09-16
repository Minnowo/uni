
public class Driver {
    public static void main(String[] args)
    {
        Ones ones = new Ones();


        for(int i  = 0; i < 5; i++)
        {
            System.out.println(ones.getNext());
        }

        ones.setStart(100);
        for(int i  = 0; i < 5; i++)
        {
            System.out.println(ones.getNext());
        }
    }
}
