import java.util.ArrayList;
import java.util.Arrays;

public class Driver 
{
    public static String[] sortTeams(String[] teams, int[] points)
    {

        // loop through array
        for(int i = 0; i < points.length; i++)
        {
            int smallest = i; 

            // loop through unsorted part of the array
            for(int j = i + 1; j < points.length; j++)
            {
                // using p[j] > p[smallest] so it sort descending
                if(points[j] > points[smallest])
                {
                    smallest = j;
                }
            }

            // swap the strings based on their points
            String tmp1 = teams[i];
            teams[i] = teams[smallest];
            teams[smallest] = tmp1;

            // swap the actual points themselves 
            int tmp2 = points[i];
            points[i] = points[smallest];
            points[smallest] = tmp2;
        }

        // return the array for some reason?? 
        return teams;
    }

    public static void main(String[] args)
    {
        String[] teams = new String[]{"Italy","Argentia", "England", "Brazil", "Belgium",
        "France", "Spain"};
        int[] points = new int[] {1726, 1773, 1728, 1841, 1816, 1759, 1715};
        System.out.println("\nOriginal Teams Array");
        System.out.println("********************");
        System.out.println(Arrays.toString(teams));
        System.out.println("\nOriginal Points Array");
        System.out.println("********************");
        System.out.println(Arrays.toString(points));
        System.out.println("\nTeams Sorted by their points");
        System.out.println("*******************************");
        System.out.println(Arrays.toString(sortTeams(teams, points)));
    }
}
