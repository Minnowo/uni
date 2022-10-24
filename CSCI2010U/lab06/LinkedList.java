import java.util.ArrayList;


// define Node class, NOTE: adding public on this breaks everything!
class Node 
{
    // declare pointer and data
    Node next;
    People people;    

    // basic constructor
    public Node(People p)
    {
        this.people = p;
    }
}

public class LinkedList 
{
    // declare head
    Node head;

    
    public void insertElement(People people)
    {
        // make new Node
        Node n = new Node(people);

        // set head and finish if head doesn't exist
        if(this.head == null)
        {
            this.head = n;
            return;
        }

        // else loop through the list 
        Node curr = this.head;

        while(curr.next != null)
        {
            curr = curr.next;
        }

        // and set the new last element
        curr.next = n;
    }   
    
    public void print()
    {
        // cute little for loop to print out each thing
        for(Node n = this.head; n != null; n = n.next)
        {
            System.out.println(n.people);
        }
    }

    public ArrayList<LinkedList> split(LinkedList list)
    {
        // define array and linked list
        ArrayList<LinkedList> lla = new ArrayList<>();
        LinkedList vax = new LinkedList();
        LinkedList uvax = new LinkedList();

        lla.add(vax);
        lla.add(uvax);

        // another cute little for loop to go through the list
        for(Node n = this.head; n != null; n = n.next)
        {
            // if the status is Vaccinated add it to the vax list
            if(n.people.status.equals("Vaccinated"))
            {
                vax.insertElement(n.people);
            }

            // else add it to the unvaccinated list 
            else 
            {
                uvax.insertElement(n.people);
            }
        }

        // we've done it!
        return lla;
    }
}
