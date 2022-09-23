

public class Driver
{
    public static void pair(int[] arr1, int[] arr2)
    {
        for(int i = 0; i < arr1.length; i++) // O(n)
        {
            for(int j = 0; j < arr2.length; j++) // O(m)
            {
                System.out.printf("%d %d, ", arr1[i], arr2[j]); // O(1)
            }
        }
        // runtime = O(n) * O(m) * O(1) = O(n*m)
    }

    public static void paris(int[] arr)
    {
        for(int i = 0; i < arr.length; i++) // O(n)
        {
            for(int j = 0; j < arr.length; j++) // O(n)
            {
                System.out.printf("%d %d", i, j); // O(1)
            }
        }

        // total runtime = O(n) * O(n) * O(1) = O(n^2)
    }

    public static int sum_product(int arr[])
    {
        int sum = 0;  // O(1)
        for (int i = 0; i < arr.length; i++)   // this runs n times
        {
            sum += arr[i];   // O(1)
        }

        int product = 1;  // O(1)
        for (int i = 0; i < arr.length; i++)   // this runs n times
        {
            product *= arr[i];   // O(1)
        }

        return sum;   // O(1)
        // total runtime = O(1) + O(n)*O(1) + O(1) + O(n)*O(1) + O(1) = O(n)

        // O(1) + O(2)*O(1) + O(1) + O(n)*O(1) + O(1)
    }

    public static int linear_function(int arr[])
    {
        int sum = 0;  // O(1)
        for (int i = 0; i < arr.length; i++)   // this runs n times
        {
            sum += arr[i];   // O(1)
        }
        return sum;   // O(1)
        // total time = O(1) + O(n) x O(1) + O(1) = O(n)
    }
    
    public static int constant_function(int arr[])
    {
        int number = 0;  // O(1)
        return number;   // O(1)
 
        // total time = O(1) + O(1) = O(2) which is constant
    }

    public static void main(String[] args) 
    {
        int arr1[] = {1, 2, 3, 4, 5 };
        int arr2[] = {1, 2, 3, 4, 5 };
        pair(arr1, arr2);
    }
    
}