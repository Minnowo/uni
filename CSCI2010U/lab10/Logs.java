
public class Logs 
{
    // declare members 
    String username;
    String task;
    int year;
    
    // parameterized constructor 
    public Logs(String username, String task, int year)
    {
        this.username = username;
        this.task = task;
        this.year = year;
    }

    // tostring
    public String toString()
    {
        return this.username + ", " + this.task + ", " + this.year;
    }
}
