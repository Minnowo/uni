
class Animal
{
    public static int nyaa = 1;

    String eyeColor;
    protected Integer numberOfLimbs;
}

class Cat extends Animal
{
    String name;
    String color;
    Integer age;

    public Cat(String name, String color, Integer age)
    {
        this.name = name;
        this.color = color;
        this.age = age;

        numberOfLimbs = 1;
    }

    public String toString()
    {
        return "name: " + name + ", color: " + color + ", age: " +age ;
    }
}

public class Driver 
{
    public static void main(String[] args) 
    {
       
    }

    public void uwu()
    {
        System.out.println("uwu");

    }
}