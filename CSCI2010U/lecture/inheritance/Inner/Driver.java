
public class Driver 
{
    public static void main(String[] args)
    {
        Student s = new Student("nyah uwu", 13);

        System.out.println(s);

        Student.StudentDetails sd = s.new StudentDetails();
        System.out.println(sd.getFirstName());
    }
}
