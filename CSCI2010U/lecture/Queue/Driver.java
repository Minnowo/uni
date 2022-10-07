import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Driver 
{
    public static void display(int[] arr)
    {
        for(int i : arr)
        {
            System.out.print(i + ", ");
        }
    }
    public static int largestProduct(int[] arr)
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : arr)
        {
            queue.add(i);
        }

        return queue.poll() * queue.poll();
    }
    public static void main(String[] args) 
    {
        int[] arr = new int[] { 5, 3, 2, 1 };
        System.out.println( largestProduct(arr));


        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue);

        // remove from queue
        queue.poll();
        
        System.out.println(queue);
    }    
}
