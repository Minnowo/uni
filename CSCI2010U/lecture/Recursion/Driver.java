
public class Driver 
{
    public static int factorial(int x)
    {
        if(x <= 1)
            return 1;

        return x * factorial(x - 1);
    }

    public static int power_iter(int base, int exp)
    {
        if(exp == 0)
            return 1;
        if(exp < 0)
            return 0;

        final int BASE = base;

        for(int i = 1; i < exp; i++)
        {
            base *= BASE;
        }
        return base;

        // time complexity is O(n)
        // space complexity is O(1)
    }

    public static int power_recur(int base, int exp)
    {
        if(exp == 0)
            return 1;

        if(exp <= 1)
            return base;

        return base * power_recur(base, exp - 1);
        // time complexity is O(n)
        // space complexity is O(n)
    }

    public static int fib_rec(int n)
    {
        if(n <= 1)
            return n;

        return fib_rec(n - 1) + fib_rec(n - 2);
        // time complexity = O(2^n - 1 - 1)
        // space complexity = O(n)
    }

    public static int fib_iter(int n)
    {
        if(n < 0)
            return 0;   

        int x = 0;
        int y = 1;
        int num = n;

        for(int i = 1; i < n; i++)
        {
            num = x + y ;
            x = y;
            y = num;
        }

        return num;
    }

    public static void main(String[] args) 
    {
        // System.out.println(factorial(5));
        // System.out.println(power_iter(2, 5));
        // System.out.println(power_recur(2, 5));
        // System.out.println(fib_rec(5));
        // System.out.println(fib_iter(5));


        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insert(6);

        System.out.println( ll.remove(ll.head, 1));
        System.out.println( ll.remove(ll.head, 20));
    }
}
