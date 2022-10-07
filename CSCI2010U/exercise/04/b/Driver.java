
public class Driver 
{
    public static Student getOldest(Student[] arr)
    {
        Student oldest = arr[0];

        for(int i = 0; i < arr.length; i++)
        {
            if(oldest.age < arr[i].age)
            {
                oldest = arr[i];
            }
        }

        return oldest;
    }

    public static void main(String[] args) 
    {
        Student students[] = new Student[] 
        { 
            new Student("Steve", 55),  
            new Student("Bill", 65),  
            new Student("Warren", 75),  
            new Student("Elon", 45),  
            new Student("John", 35),  
        }; 

        System.out.println(getOldest(students));
    }
}
