import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class uwu 
{
    public static class Customer 
    {
        String name;
        String card;
        int age;
        int money;

        public Customer(String name, int age, String card, int money)
        {
            this.name = name;
            this.age = age;
            this.card = card;
            this.money = money;
        }
    
        public String toString()
        {
            return this.name;
        }
    }

    public static ArrayList<Customer> eligibleCustomers(Customer[] credit_cards, Customer[] checking)
    {
        HashSet<String> hs = new HashSet<>();

        for(Customer c : credit_cards)
        {
            hs.add(c.name);
        }

        ArrayList<Customer> discoutn = new ArrayList<>();

        for(Customer c : checking)
        {
            if(hs.contains(c.name))
            {
                discoutn.add(c);
            }
        }

    	return discoutn;
    }
    public static void main(String[] args) {
        Customer credit_cards[] = new Customer[]{
            new Customer("Steve Jobs", 55, "Credit Card", 5000),
            new Customer("Bill Gates", 65, "Credit Card", 10000),
            new Customer("Elon Musk", 45, "Credit Card", 25000),
            new Customer("Warren Buffet", 75, "Credit Card", 35000),
            new Customer("Eva Jobs", 60, "Credit Card", 8000),
        };

        Customer checking[] = new Customer[]{
            new Customer("Tom Cruise", 55, "Checking", 15000),
            new Customer("Angelina Jolie", 45, "Checking", 12000),
            new Customer("Sara Jones", 35, "Checking", 2000),
            new Customer("Steve Jobs", 50, "Checking", 30000),
            new Customer("Bill Gates", 60, "Checking", 8000),
            new Customer("Laura White", 40, "Checking", 7000),
            new Customer("Warren Buffet", 75, "Checking", 3000),
        };

        System.out.println("\nCustomers with Credit Cards:");
        System.out.println(Arrays.toString(credit_cards));

        System.out.println("\nCustomers with Checking Account:");
        System.out.println(Arrays.toString(checking));

        System.out.println("\nList of Customers Eligible for Discount:");
        System.out.println(eligibleCustomers(credit_cards, checking));
    }    
}
