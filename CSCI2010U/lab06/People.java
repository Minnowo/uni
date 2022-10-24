
public class People 
{
    // public stuff 
    public String name;
    public int age;
    public String status;
    
    // constructor
    public People(String name, int age, String status)
    {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    // tostring  override 
    public String toString()
    {
        return this.name + ", " + this.age + ", " + this.status;
    }
}
