
public class Driver 
{
    public static void main(String[] args)
    {
        int[] nums = new int[5];
        try 
        {
            nums[5] = 10;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
    }    
}
