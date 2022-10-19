
import java.util.*;

public class Athlete implements Comparable<Athlete> 
{
    public Integer wins;
    public String name;

    public Athlete()
    {
        this.wins = 0;
        this.name = "unknown";
    }

    public Athlete(String name, int wins)
    {
        this.name = name;
        this.wins = wins;
    }
    
    public String toString()
    {
        return "name: " + this.name + ", wins: " + this.wins;
    }

    @Override
    public int compareTo(Athlete b)
    {
        return this.wins.compareTo(b.wins);
    }
}