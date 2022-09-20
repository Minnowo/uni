
public class Driver 
{
    public static void main(String[] args)
    {
        double start = System.nanoTime();
        double res;

        summationForLoop();

        res = (System.nanoTime() - start) / 1000_000_000d;
        System.out.printf("%.6f\n", res );

        start = System.nanoTime();

        summationInduction();

        res = (System.nanoTime() - start) / 1000_000_000d;
        System.out.printf("%.6f\n\n", res );


        summation2ForLoop();

        res = (System.nanoTime() - start) / 1000_000_000d;
        System.out.printf("%.6f\n", res );

        start = System.nanoTime();

        summation2Induction();

        res = (System.nanoTime() - start) / 1000_000_000d;
        System.out.printf("%.6f\n", res );


    }    

    public static void summationForLoop()
    {
        int n = 100000;
        int sum = 0;

        for(int i = 0; i <= n; i++)
        {
            sum += i;
        }

        System.out.println(sum);
    }


    public static void summationInduction()
    {
        int n = 100000;
        int sum = n*(n + 1) / 2;
        System.out.println(sum);
    }



    public static void summation2ForLoop()
    {
        int n = 1000;
        int sum = 0;

        for(int i = 0; i <= n; i++)
        {
            sum += i*i;
        }

        System.out.println(sum);
    }

    public static void summation2Induction()
    {
        int n = 1000;
        int sum = n*(n + 1)*(2*n + 1) / 6;
        System.out.println(sum);
    }
}
