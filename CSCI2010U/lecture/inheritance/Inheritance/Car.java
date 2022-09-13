
public class Car extends Vehicle 
{
    String type;
    
    public Car()
    {
        this.type = "";
    }

    public Car(String name, int kms, String type)
    {
        super(name, kms);
        
        this.type = type;
    }

    public String toString()
    {
        return super.toString() + ", Type: " + this.type;
    }
}
