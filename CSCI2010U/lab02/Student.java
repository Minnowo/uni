
// define Student class, child of Person class
public class Student extends Person 
{
    // define members
    String status;

    // parameterized constructor
    public Student(String name, String address, String phoneNumber, String email, String status)
    {
        // call parent contructor and set members
        super(name, address, phoneNumber, email);

        this.status = status;
    }

    // override toString
    public String toString()
    {
        return super.toString() + " Status: " + this.status;
    }
}
