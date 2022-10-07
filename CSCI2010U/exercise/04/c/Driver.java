import java.util.ArrayList;
import java.util.Arrays;

public class Driver 
{
    public static ArrayList<Integer> runningSum(ArrayList<Integer> numbers)
    {
        if(numbers.size() < 2)
            return numbers;

        for(int i = 1; i < numbers.size(); i++)
        {
            numbers.set(i, numbers.get(i - 1) + numbers.get(i));
        }

        return numbers;
    }


    public static ArrayList<Integer> runningSumBad(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> sum = new ArrayList<>();

        for(int i = 0; i < numbers.size(); i++)
        {
            if(sum.isEmpty())
            {
                sum.add(numbers.get(i));
            }
            else 
            {
                sum.add(sum.get(i - 1) + numbers.get(i));
            }
        }

        return sum;
    }
    

    public static void main(String[] args) 
    {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        System.out.println(runningSumBad(l));
        System.out.println(runningSum(l));
    }    
}
