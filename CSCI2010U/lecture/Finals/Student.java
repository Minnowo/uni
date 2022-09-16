
public class Student 
{
    String name;
    int age;
    final String type = "Undergraduate";
    
    // cannot be override
    public final void display()
    {
        System.out.println(this.name + " " + this.age + " " + this.type);
    }
}
