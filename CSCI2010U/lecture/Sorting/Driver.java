import java.util.Arrays;

class Node 
{
    int value;
    Node next;

    Node (int val)
    {
        this.value = val;
    }

    public String toString()
    {
        return this.value + "";
    }
}

public class Driver 
{
    public static void insertionSort(Integer[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            int curr = arr[i];
            int j = i - 1;

            while(j >= 0 && curr < arr[j])
            {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = curr;
        }
    }

    public static void selectionSort(Integer[] arr)
    {
        int smallest = 0;

        for(int k = 0; k < arr.length; k++)
        {
            smallest = k;

            for(int i = k + 1; i < arr.length; i++)
            {
                if(arr[i] < arr[smallest])
                {
                    smallest = i;
                }
            }

            int tmp = arr[k];
            arr[k] = arr[smallest];
            arr[smallest] = tmp;
        }
    }

    // this might just be a bubble sort 
    public static void selectionSort2(Integer[] arr)
    {
        for(int k = 0; k < arr.length; k++)
        {
            for(int i = k + 1; i < arr.length; i++)
            {
                if(arr[i] < arr[k])
                {
                    int tmp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    public static void selectionSort(Node arr)
    {
        Node smallest = arr;

        for(Node k = arr; k != null; k = k.next)
        {
            smallest = k;

            for(Node i = k.next; i != null; i = i.next)
            {
                if(i.value < smallest.value)
                {
                    smallest = i;
                }
            }

            int tmp = k.value;
            k.value = smallest.value;
            smallest.value = tmp;
        }
    }

    public static void printLinked(Node n)
    {
        for(Node k = n; k != null; k = k.next)
        {
            System.out.print(k+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Integer[] arr = new Integer[] { 1, 6, 2, 0, 3, 8, 57, 34};

        System.out.println(Arrays.toString(arr));

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));


        Node n = new Node(5);
        n.next = new Node(7);
        n.next.next = new Node(1);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(2);

        printLinked(n);
        selectionSort(n);
        printLinked(n);
    }
}
