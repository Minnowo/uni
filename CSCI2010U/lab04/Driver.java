import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Driver
{
    public static boolean contains_duplicates(int[] arr)
    {
        for(int i = 0; i < arr.length; i++) // O(n)
        {
            for(int k = 0; k < arr.length; k++) // O(n)
            {
                if(i == k)
                    continue;

                if(arr[i] == arr[k])
                    return false;
            }
        }

        // runtime = O(n^2)
        return true;
    }


    public static boolean contains_duplicates_better(int[] arr)
    {
        // idk if we're allowed to use a hashmap / hashset but this is the best way without sorting the array 
        HashSet<Integer> s = new HashSet<>(); // O(1)
            
        for(int i : arr) // O(n)
        {
            s.add(i); // O(1)
        }

        // runtime = O(n)
        return s.size() == arr.length;
    }

    public static void looptest()
    {
        int n = 10;

        for(int i = 0; i < n; i++)
        {
                System.out.print(0);

            for(int k = i + 1; k <n; k++)
            {
                System.out.print(1);
            }
        }
    }

    public static boolean contains_duplicates_better2(int[] arr)
    {
        for(int i = 0; i < arr.length; i++) // O(n)
        {
            for(int k = i + 1; k < arr.length; k++) // O(n - x)
            {
                if(arr[i] == arr[k])
                    return false;
            }
        }
        
        // runtime = O(n * (n - x)) i think
        return true;
    }

    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 2, 7, 3, 4, 1, 6, 8};
        double time = System.nanoTime();
        System.out.println(contains_duplicates(arr));
        System.out.println(System.nanoTime() - time);
        time = System.nanoTime();
        System.out.println(contains_duplicates_better(arr));
        System.out.println(System.nanoTime() - time);
        time = System.nanoTime();
        System.out.println(contains_duplicates_better2(arr));
        System.out.println(System.nanoTime() - time);
    }
}