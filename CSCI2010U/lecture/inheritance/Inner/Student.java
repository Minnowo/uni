
public class Student 
{
    String name ;
    int age;

    Student()
    {
        this.name = "";
        this.age = 0;
    }

    Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    String getName()
    {
        return this.name;
    }

    int getAge()
    {
        return this.age;
    }

    public String toString()
    {
        return "Name: " + this.name + ", Age: " + this.age;
    }

    class StudentDetails
    {
        String[] names;

        String getFirstName()
        {
            this.names = name.split(" ", 2);
            return this.names[0];
        }
    }
}
