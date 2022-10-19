import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Driver 
{
    public static ArrayList<String> classifyAthletes(Athlete[] athletes)
    {
        // make queue
        PriorityQueue<Athlete> q = new PriorityQueue<>(Collections.reverseOrder());

        // fill the queue
        for(Athlete a : athletes)
        {
            q.add(a); 
        }

        // make output list
        ArrayList<String> wins = new ArrayList<>();

        if(!q.isEmpty())
        {
            // add the highest wins
            wins.add(q.poll().name + ": Highest Wins");
        }

        // empty the queue while filling the output list
        int i = 2;
        while(!q.isEmpty())
        {
            // check for 10th 11th 12th 13th which are exceptions 
            if(i % 100 > 10 && i % 100 < 14)
            {
                wins.add(q.poll().name + ": %dth Highest Wins".formatted(i ));
                i++;
                continue;
            }

            // otherwise handle the last digit with the saying 
            switch(i % 10)
            {
                // ends in 1
                case 1:

                    wins.add(q.poll().name + ": %dst Highest Wins".formatted(i ));
                    break;

                // ends in 2
                case 2:

                    wins.add(q.poll().name + ": %dnd Highest Wins".formatted(i ));
                    break;

                // ends in 3
                case 3:

                    wins.add(q.poll().name + ": %drd Highest Wins".formatted(i ));
                    break;

                // ends in anything else 
                default:

                    wins.add(q.poll().name + ": %dth Highest Wins".formatted(i ));
                    break;
            }

            // increment counter
            i++;
        }

        // return 
        return wins;
    }
    
    public static void main(String[] args) 
    {
        Athlete[] athletes = new Athlete[]{
        new Athlete("Pete Sampras", 14),
        new Athlete("Novak Djokovic", 21),
        new Athlete("Roger Federer", 20),
        new Athlete("Roy Emerson", 12),
        new Athlete("Rafael Nadal", 22),
        new Athlete("Bjorn Borg", 11)

        };
        for (String rank: classifyAthletes(athletes))
        {
            System.out.println(rank);
        }
    }
}