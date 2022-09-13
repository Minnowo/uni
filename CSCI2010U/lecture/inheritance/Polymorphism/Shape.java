
public class Shape 
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

    double calcArea()
    {
        return this.width * this.height;
    }

    public String toString()
    {
        return "Width: " + this.width + ", Height: " + this.height + ", Name: " + this.name;
    }
}
