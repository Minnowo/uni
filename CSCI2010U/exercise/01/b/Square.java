

    public class Square extends Shape
    {
        double length;

        public Square(double length)
        {
            this.length = length;
        }

        public double calcArea()
        {
            return this.length * this.length;
        }

        public String toString()
        {
            return "Area of square: " + this.calcArea();
        }
    }