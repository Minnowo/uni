
public class Ones implements Series 
{
    int start;
    int value;
    
    Ones()
    {
        this.start = 0;
        this.value = 0;
    }

    public int getNext()
    {
        this.value += 1;

        return this.value;
    }

    public void reset()
    {
        this.value = 0;
        this.start = 0;
    }

    public void setStart(int x)
    {
        this.start = x;
        this.value = x;
    }
}
