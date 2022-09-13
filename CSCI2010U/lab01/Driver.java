
public class Driver
{
    public static void main(String[] args)
    {
        // make instance of Calculator class 
        Calculator c = new Calculator();
        
        // define input variables 
        double x = 5;
        double y = 6;

        // print output and do calculations 
        System.out.printf("%.1f + %.1f = %.1f\n", x, y, c.add(x, y));
        System.out.printf("%.1f * %.1f = %.1f", x, y, c.multiply(x, y));
    }
}