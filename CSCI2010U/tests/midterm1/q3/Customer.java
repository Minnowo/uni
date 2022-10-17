
public class Customer
{
	public String name;
	public int age;
	public String product;
	public double balance;
	
	public Customer(String name, int age, String product, double balance)
	{
		this.name = name;
		this.age = age;
		this.product = product;
		this.balance = balance;
	}
	
	public String toString()
	{
		return this.name + ", " + this.age;
	}
}
