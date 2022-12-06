import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Driver 
{
    public static String[] sortByWins(String[] players, Integer[] wins)
    {
        // runtime = O(n log(n))
        // space   = O(n)

        HashMap<Integer, String> hm = new HashMap<>(); // O(1)

        for(int i = 0; i < players.length; i++) // O(n)
        {
            hm.put(wins[i], players[i]); // O(1)
        }

        Arrays.sort(wins, Collections.reverseOrder()); // O(n log(n))

        String[] output = new String[players.length]; // O(1)

        for(int i = 0; i < wins.length; i++) // O(n)
        {
            output[i] = hm.get(wins[i]) + ", " + wins[i];
        }

        return output;
        // for(int i = 0; i < players.length; i++)
        // {
        //     int sh = i;

        //     for(int j = i + 1; j < players.length; j++)
        //     {
        //        if(wins[j] > wins[sh]) 
        //        {
        //             sh = j;
        //        }
        //     }

        //     {
        //         String tmp = players[sh];
        //         players[sh] = players[i];
        //         players[i]  = tmp;
        //     }

        //     int tmp = wins[sh];
        //     wins[sh] = wins[i];
        //     wins[i]  = tmp;
        // }
        // return players;
    }
    public static void main(String[] args) 
    {
        String[] players = new String[]{ "Pete Sampras", "Novak Djokovic", "Roger Federer", 
                                         "Roy Emerson", "Rafael Nadal", "Bjorn Borg" };
        Integer[] wins = new Integer[] { 14, 21, 20, 12, 22, 11 };

        for (String result: sortByWins(players, wins))
        {
            System.out.println(result);
        }
    }
}