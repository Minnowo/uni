
public class Driver 
{
    public static void main(String[] args)
    {
        Number n = new Number(3.141596);

        Number.Precision p = n.new Precision();
        System.out.println( p.setPrecision());
    }
}
