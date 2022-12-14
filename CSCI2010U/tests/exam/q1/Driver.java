import java.util.HashMap;

public class Driver 
{
    public static class Student 
    {
        private String name;
        private char grade;

        public Student(String name, Character grade)
        {
            this.name = name;
            this.grade = grade;
        }

        public String getName()
        {
            return this.name;
        }

        public Character getGrade()
        {
            return this.grade;
        }
    }
    
    public static double getPassingRate(Student[] students)
    {
        // =================
        // Total Space: O(n)
        // Total Time : O(n)
        // =================

        if(students.length <= 0)
            return 0;

        final int totalStudents = students.length;

        // hashmap that counts occurance of each grade
        HashMap<Character, Integer> hm = new HashMap<>();

        // fill the hash map O(n)
        for(int i = 0; i < students.length; i++)
        {
            // if we've seen the grade inc by 1
            if(hm.containsKey(students[i].getGrade()))
            {
                hm.put(students[i].getGrade(), hm.get(students[i].getGrade()) + 1);
            }
            else 
            {
                // else add it 
                hm.put(students[i].getGrade(), 1);
            }
        }

        // find f count
        Integer failed = hm.get('F');

        // nobody failed
        if(failed == null)
            return 100;

        // find students who passed and divide by total students
        return 100d * (totalStudents - failed) / totalStudents;
    }

    public static void main(String[] args) {
        Student[] students  = new Student[]{
            new Student("Steve", 'A'),
            new Student("Bill", 'F'),
            new Student("Elon", 'C'),
            new Student("Lizzy", 'F'),
            new Student("Salma", 'D'),
            new Student("Jeff", 'F'),
            new Student("Warren", 'B'),
            new Student("Julie", 'F'),
            new Student("Shawn", 'A'),
            new Student("Tim", 'C'),
        };

        System.out.println("Passing Rate with 10 students: " + getPassingRate(students) + "%");
        
        students = new Student[]{};
        System.out.println("Passing Rate with 0 students: " + getPassingRate(students) + "%");

       
    }
}