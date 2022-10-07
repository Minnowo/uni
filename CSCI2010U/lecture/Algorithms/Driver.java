
public class Driver 
{

    public static void sumOfZeroToNBad(int n)
    {
        int sum = 0;

        for(int i = 0; i <= n; i++)
        {
            sum += i;
        }

        System.out.println("Sum from 0-n: " + sum);
    }

    public static void sumOfZeroToNGood(int n)
    {
    
        System.out.println("Sum from 0-n: " + (n*(n + 1))/2);
    }


    public static void sumOfZeroToNSquareBad(int n)
    {
        int sum = 0;

        for(int i = 0; i <= n; i++)
        {
            sum += i*i;
        }

        System.out.println("Sum from 0-n: " + sum);
    }

    public static void sumOfZeroToNSquareGood(int n)
    {
    
        System.out.println("Sum from 0-n: " + (n*(n + 1)*(2*n + 1))/6);
    }


    public static void main(String[] args) 
    {
        sumOfZeroToNBad(10);
        sumOfZeroToNGood(10);
        sumOfZeroToNSquareBad(10);
        sumOfZeroToNSquareGood(10);
    }
}
