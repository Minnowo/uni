
// define abstract class Cd 
public abstract class Cd 
{
    // private members
    protected String performers;
    protected String label;
    protected int selections;
    protected double playtime;

    // default constructor
    public Cd()
    {
        this.performers = "Unknown";
        this.label = "Unknown";
        this.selections = 0;
        this.playtime = 0;
    }

    // param constructor
    public Cd(String performers, String label, int selections, double playtime)
    {
        this.performers = performers;
        this.label = label;
        this.selections = selections;
        this.playtime = playtime;
    }

    // abstract function Report 
    abstract void Report();
}
