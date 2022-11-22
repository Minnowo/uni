
public class Logs 
{
    String username;
    String task;
    int year;
    
    public Logs(String username, String task, int year)
    {
        this.username = username;
        this.task = task;
        this.year = year;
    }

    public String toString()
    {
        return this.username + ", " + this.task + ", " + this.year;
    }
}
