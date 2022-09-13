
public class Vehicle
{
    String name;
    int kms;

    public Vehicle()
    {
        this.name = "";
        this.kms = 0;
    }

    public Vehicle(String name, int kms)
    {
        this.name = name;
        this.kms = kms;
    }

    public String toString()
    {
        return "Name: " + this.name + ", KMsS: " + this.kms;
    }
}