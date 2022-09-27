
public class Driver 
{
    public static void main(String[] args)
    {
        System.out.println("\nCalling through Classic Object...");
        System.out.println("*************************************");
        // create an object of Classic class and call Report method. Use the below data:
        Classic c = new Classic("Fantasia in C", "Alfred Brendel", "Philips", 2, 57.17);
        c.Report();

        System.out.println("\nCalling through CD Object...");
        System.out.println("*************************************");
        // create another object of Classic class and assign it to the reference of the
        // parent class (CD class). Finally, call the Report method using the reference of
        // the parent class. Use the below data:
        Cd cd = new Classic(null, "Beatles", "Capitol", 14, 35.5);
        cd.Report();
    }
}