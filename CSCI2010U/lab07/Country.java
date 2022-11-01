
public class Country 
{
    // members 
    String name;
    Double population;

    // constructor
    public Country(String name, double population)
    {
        this.name = name;
        this.population = population;
    }

    // toString
    public String toString()
    {
        // format the numbers good 
        return "%s : %(,.0f".formatted(this.name, this.population);
    }
}
