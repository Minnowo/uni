import java.util.Arrays;

public class Driver 
{
    public static void reverseArray(int[] arr)
    {
        for(int i = 0; i < arr.length / 2; i++)
        {
            int b = arr.length - i - 1;
            int tmp = arr[i];
            arr[i] = arr[b];
            arr[b] = tmp;
        }
    }

    public static void main(String[] args) 
    {
        int[] arr = new int[]{ 1};
        System.out.println(Arrays.toString(arr));
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
