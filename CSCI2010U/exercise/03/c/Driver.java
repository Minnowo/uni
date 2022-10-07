
public class Driver 
{
    public static int missingElement(int[] arr)
    {
        int s = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            if(s + 1 != arr[i])
            {
                return s + 1;
            }
            else 
            {
                s = arr[i];
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2, 3, 4, 5, 6};
        System.out.println( missingElement(arr));
    }    
}
