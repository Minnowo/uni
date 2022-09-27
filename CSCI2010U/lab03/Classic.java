
// define Classic class, inherit from Cd
public class Classic extends Cd 
{
    // define private member
    private String primaryWork;

    // default constructor
    public Classic()
    {
        super();
        this.primaryWork = "Unknown";
    }

    // param constructor
    public Classic(String primaryWork, String performers, String label, int selections, double playtime)
    {
        super(performers, label, selections, playtime);

        // null check to match the sample output
        if(primaryWork != null)
        {
            this.primaryWork = primaryWork;
        }
        else 
        {
            this.primaryWork = "Unknown";
        }
        
    }

    // define report function
    public void Report()
    {   
        // big ugly printf that works
        System.out.printf(
            "Performers: %s\nLabel: %s\nSelection: %d\nPlayTime: %.1f\nPrimary Work: %s\n", 
            super.performers, 
            super.label, 
            super.selections, 
            super.playtime, 
            this.primaryWork);
    }
}
