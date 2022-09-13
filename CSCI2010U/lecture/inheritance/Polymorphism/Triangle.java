
public class Triangle extends Shape
{
    Triangle(double width, double height, String name)
    {
        super(width, height, name);
    }

    double calcArea()
    {
        return (this.width * this.height) / 2.0;
    }
}
