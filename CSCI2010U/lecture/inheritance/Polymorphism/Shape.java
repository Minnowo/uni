
public abstract class Shape 
{
    double height;
    double width;
    String name;

    Shape()
    {
        this.height = 0.0;
        this.width = 0.0;
    }

    Shape(double width, double height, String name)
    {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    // abstract function must be in abstract class 
    abstract double calcArea();

    public String toString()
    {
        return "Width: " + this.width + ", Height: " + this.height + ", Name: " + this.name;
    }
}
