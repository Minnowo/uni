import java.util.Arrays;
import java.util.Comparator;

public class Lambda 
{
    public static class UwU
    {
        int data;
        public UwU(int v)
        {
            this.data =v;
        }

        public String toString()
        {
            return Integer.toString(this.data);
        }
    }

    public static void main(String[] args) 
    {
        // sorting objects 
        UwU[] uwu = new UwU[] { new UwU(1), new UwU(5), new UwU(2), new UwU(-5)};
        UwU[] uwu2 = Arrays.copyOf(uwu, uwu.length);
        UwU[] uwu3 = Arrays.copyOf(uwu, uwu.length);
        UwU[] uwu4 = Arrays.copyOf(uwu, uwu.length);

        // arrays.sort with lambda
        System.out.println(Arrays.toString(uwu));
        Arrays.sort(uwu, (x, y) -> (x.data - y.data));
        System.out.println(Arrays.toString(uwu));


        // using custom  comparator instance 
        Comparator<UwU> c = new Comparator<UwU>() 
        {
            @Override
            public int compare(UwU a, UwU b)
            {
                return a.data - b.data;
            }
        };

        System.out.println("\n" + Arrays.toString(uwu2));
        Arrays.sort(uwu2, c);
        System.out.println(Arrays.toString(uwu2));
    }    
}
