
public class Number 
{
    double number;

    public Number(int number)
    {
        this.number = (double)number;
    }

    public Number(double number)
    {
        this.number = number;
    }

    public class Precision
    {
        public double setPrecision()
        {
            long t = (long)(number * 100);
            return t / 100d;
        }
    }
}
