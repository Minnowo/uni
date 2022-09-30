import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Driver 
{
    public static void print(int[] arr)
    {
        for (int i : arr)
        {
            System.out.println(i);
        }
    }

    public static void modify(int[] arr)
    {
        arr[0] = 100;
    }

    public static void display(String[] arr)
    {
        for(String a : arr)
        {
            System.out.println(a);
        }
    }

    public static void getElements()
    {
        int[] a = new int[5];
        Scanner s = new Scanner(System.in);

        for(int i = 0; i < 5; i++)
        {

            System.out.printf("Enter arr[%d]: ", i);
            int sie = s.nextInt();
            a[i] = sie;
        }

        s.close();
        print(a);
    }

    public static void search(String[] cities)
    {
        for(String s : cities)
        {
            if (s.equals("Ottawa"))
            {
                System.out.printf("found %s", s);
            }
        }
    }

    public static void searchStudent(Student[] s)
    {
        for(Student ss : s)
        {
            if(ss == null)
                continue;
                
            if(ss.getName().equals("cat"))
            {
                System.out.println("found cat");
            }
        }
    }

    public static void main(String[] args)
    {
        String[] cities = new String[]{"Toronto", "Oshawa", "Ottawa"};
        // getElements();
        display(
            cities
        );

        System.out.println(Arrays.toString(cities));
        // Arrays.sort(cities);
        Arrays.sort(cities, Collections.reverseOrder());

        System.out.println(Arrays.toString(cities));

        
        Student[] s = new Student[5];
        s[0] = new Student("cat", "lklklklk");
        System.out.println(Arrays.toString(s));
        
        searchStudent(s);
    }    
}
