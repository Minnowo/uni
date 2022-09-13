
public class Rectangle extends Shape
{
    Rectangle()
    {
        super();
    }

    Rectangle(double width, double height, String name)
    {
        super(width, height, name);
    }

    double calcArea()
    {
        return width * height;
    }
}
