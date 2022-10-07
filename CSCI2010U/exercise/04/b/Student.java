
public class Student 
{
    String name;
    Integer age;
    
    Student(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    public String toString()
    {
        return "Name: " + this.name + " age: " + this.age;
    }
}
