import java.util.Arrays;
import java.util.Collections;

public class Driver 
{

    public static void sortDescending(int[] arr)
    {
        Integer[] arr2 = new Integer[arr.length];

        Arrays.setAll(arr2, i -> arr[i]);

        Arrays.sort(arr2, Collections.reverseOrder());

        Arrays.setAll(arr, i -> arr2[i]);
    }

    public static void main(String[] args) 
    {
        
        int[] arr = new int[]{ 1, 2, 3, 4, 5 };
        
        sortDescending(arr);

        System.out.println(Arrays.toString(arr));
    }
}
