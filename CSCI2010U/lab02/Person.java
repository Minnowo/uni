
public class Person 
{
    String name;
    String address;
    String phoneNumber;
    String email;
    
    public Person(String name, String address, String phoneNumber, String email)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString()
    {
        return "Name: " + this.name + ", Address: " + this.address + ", PhoneNUmber: " + this.phoneNumber + ", Email: " + this.email;
    }
}
