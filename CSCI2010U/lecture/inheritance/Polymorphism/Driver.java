
public class Driver 
{
    public static void main(String[] args)
    {
        Shape[] shapes = new Shape[5];

        shapes[0] = new Triangle(5, 3, "Triangle 1");
        shapes[1] = new Triangle(8, 2, "Triangle 2");
        shapes[2] = new Triangle(84, 4, "Triangle 3");
        shapes[3] = new Rectangle(18, 2, "Rectangle 1");
        shapes[4] = new Rectangle(2, 2, "Rectangle 2");

        for(Shape s : shapes)
        {
            System.out.println(s);
        }
    }    
}
