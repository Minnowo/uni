import java.util.HashMap;

public class Map 
{
    public static class Student
    {
        int age;
        String name;

        public Student(int age, String name)
        {
            this.age = age;
            this.name = name;
        }

        public String toString()
        {
            return this.name + " " + this.age;
        }
    }
    public static void main(String[] args) 
    {
        HashMap<Integer, Student> hm = new HashMap<>();

        Student[] names = new Student[] {
            new Student(1, "dumb"), 
            new Student(5, "idiot"), 
            new Student(6, "uwu"), 
            new Student(85, "dickface"),
            new Student(43, "cheyanen")
        };

        for(int i = 0; i < names.length; i++)
        {
            hm.put(names[i].age, names[i]);
        }

        System.out.println(hm);
    }    
}
