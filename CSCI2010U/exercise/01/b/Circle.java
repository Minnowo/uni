
    public class Circle extends Shape
    {
        double radius;

        public Circle(double radius)
        {
            this.radius = radius;
        }

        public double calcArea()
        {
            return 3.14159 * radius * radius;
        }

        public String toString()
        {
            return "Area of circle: " + this.calcArea();
        }
    }