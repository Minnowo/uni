import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Driver 
{
    public static void DisplayMN(int[][] arr)
    {
        // O(N)
        for(int[] i : arr)
        {
            // O(M)
            for(int ii : i)
            {
                System.out.println(ii);
            }
        }

        // runtime = O(N * M)
    }

    public static void DisplayLinear(int[][] arr)
    {
        for(int[] i : arr)
        {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void DisplayArrayList(ArrayList a)
    {
        for(int i = 0; i < a.size(); i++)
        {
            System.out.println(a.get(i));
        }

        // or 

        // for(Object i : a)
        // {
        //     System.out.println(i);
        // }
    }

    public static void Exercise()
    {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Toronto");
        cities.add("Oshawa");
        cities.add("Whitby");

        ArrayList<String> cities2 = new ArrayList<>();
        cities2.add("Toront1o");
        cities2.add("Oshawa");
        cities2.add("Whitby");

        System.out.println(comparArray1(cities, cities2));
    }

    public static void Exercise2()
    {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(7);

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < a.size(); i++)
        {
            int item = a.get(i);

            if(i - 1 >= 0)
            {
                result.add(result.get(i - 1) + item);
            }
            else 
            {
                result.add(item);
            }
        }
        System.out.println(result);
    }

    public static boolean comparArray2(ArrayList<String> a, ArrayList<String> b)
    {
        return String.join("", a).equals(String.join("", b));
    }

    public static Boolean comparArray1(ArrayList a, ArrayList b)
    {
        
        for(int i = 0; i < a.size(); i++) // O(N)
        {
            for(int j = 0; j < b.size(); j++) // O(M)
            {
                if(!a.get(i).equals(b.get(j)))
                {
                    return false;
                }
            }
        }
        // total runtime = O(N M)
        return true;
    }

    public static void main(String[] args)
    {
        Exercise2();
        // ArrayList<String> fruits = new ArrayList<>();
        // fruits.add("Apple");
        // fruits.add("Banana");
        // fruits.add("Peach");

        // System.out.println(fruits.toString());

        // fruits.remove("Apple");
        
        // System.out.println( fruits.contains("Apple") );

        // System.out.println(fruits.toString());

        // fruits.set(0, "Pineapple");
        // System.out.println(fruits.toString());

        // DisplayArrayList(fruits);


        // ArrayList<Integer> numbersagain = new ArrayList<>();
        // numbersagain.add(8);
        // numbersagain.add(1);
        // numbersagain.add(6);
        // numbersagain.add(2);
        // numbersagain.add(5);

        // System.out.println(numbersagain);
        
        // numbersagain.sort(null);
        
        // System.out.println(numbersagain);
        
        // numbersagain.sort(Comparator.reverseOrder());
        
        // System.out.println(numbersagain);

        // // Collections.sort(numbersagain); // this also sorts it 
        // // Collections.sort(numbersagain, Comparator.reverseOrder()); // this works for descending
        
        // int[][] numbers = new int[][]{ 
        //     { 1, 2, 3 },
        //     { 4, 5, 6 }
        // };

        // Display(numbers);
    }    
}
