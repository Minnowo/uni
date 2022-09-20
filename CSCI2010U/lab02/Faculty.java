
// define Faculty class, child of Person class
public class Faculty extends Person 
{
    // define member rank  
    String rank;

    // parameterized constructor 
    public Faculty(String name, String address, String phoneNumber, String email, String rank)
    {
        // call parent constructor, and set member value
        super(name, address, phoneNumber, email);
        this.rank = rank;
    }

    // override toString
    public String toString()
    {
        return super.toString() + ", Rank: " + this.rank;
    }
}
