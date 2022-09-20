
public class Student extends Person 
{
    String status;

    public Student(String name, String address, String phoneNumber, String email, String status)
    {
        super(name, address, phoneNumber, email);

        this.status = status;
    }

    public String toString()
    {
        return super.toString() + ", Status: " + this.status;
    }
}
