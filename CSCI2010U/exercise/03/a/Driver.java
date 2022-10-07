
public class Driver 
{
    public static int getSecondLargestInt(int[] arr)
    {
        if (arr.length == 0)
            return -1;
        if(arr.length < 2)
            return arr[0];

        int max       = arr[0];
        int secondMax = arr[1];

        for(int i : arr)
        {
            if (i > max)
            {
                secondMax = max;
                max = i;
            }
            else if(i > secondMax)
            {
                secondMax = i;
            }
        }

        return secondMax;
    }
    public static void main(String[] args) 
    {
        int[] arr = new int[]{ 1, 2, 8, 3, 4, 5, 6};

        System.out.println(getSecondLargestInt(arr));
    }    
}
