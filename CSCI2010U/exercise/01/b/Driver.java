
public class Driver 
{
    public static void calcArea(Square s, Circle c)
    {
        System.out.println(s);
        System.out.println(c);
    }
    
    public static void main(String[] args)
    {
        Square s = new Square(5);
        Circle c = new Circle(5);

        calcArea(s, c);
    }
}
