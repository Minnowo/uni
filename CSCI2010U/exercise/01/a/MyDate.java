
public class MyDate
{
    int month;
    int day;
    int year;

    public MyDate()
    {
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }

    public void setDate(int day, int month, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String toString()
    {
        return day + "-" + month + "-" + year;
    }
}