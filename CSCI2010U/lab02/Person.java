
// define base Person class 
public class Person 
{
    // define member variables 
    String name;
    String address;
    String phoneNumber;
    String email;
    
    // parameterized constructor 
    public Person(String name, String address, String phoneNumber, String email)
    {
        // set member values 
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // override toString
    public String toString()
    {
        return "Name: " + this.name + " Address: " + this.address + " PhoneNUmber: " + this.phoneNumber + " Email: " + this.email;
    }
}
