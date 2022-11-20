
public class Student 
{
    String name;
    int age;

    // constructor
    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    // make tostring
    public String toString()
    {
        return this.name + ": " + this.age;
    }
}
