import java.util.Arrays;

public class Driver {
    // Quick Sort
    // space complexity = O(n) because it uses recursion
    // runtime = O(nlogn)

    /*
     * Uses a pivot, typically the last element but it can be the first
     * Divide array into different parts based on the pivot
     * Items that are less than the pivot are on the left
     * Items that are greater than the pivot are on the right
     * 
     * Repeat above on the left array, picking the last element in the array as the pivot,
     * create 2 new arrays, less than pivot goes in left, greater goes in right
     * 
     * repeat this until each array is only 1 element long
     * NOTE: the pivot is not included in each array
     * 
     * 
     * after every array is only 1 element long, merge them all together and it will be sorted
     * when merging, start from the left towards right, sorts in increasing order
     */

    // divide the array into partitions
    public static int partition(int[] numbers, int start, int end)
    {
        // start not referencing any point in the array
        int i = start - 1;

        // start at the start of the array
        int j = start;

        // set the pivot to the last element in the array
        int pivot = numbers[end];

        for (j = start; j < end; j++)
        {
            if (numbers[j] < pivot)
            {
                // increment i if j's associated value is < pivot
                i++;
                // swap values i and j are pointing to
                int tj = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = tj;
            }
        }
        // finally, increment i and j then swap them
        i++;
        int tj = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = tj;


        return i;
    }

    // recursive func
    public static void quickSort(int[] numbers, int start, int end)
    {
        if (start >= end)
            return;

        // partition = split up / divide the array
        int pivotIndex = partition(numbers, start, end);

        // recursive call to sort the smaller arrays (left side)
        quickSort(numbers, start, pivotIndex - 1);

        // right side
        quickSort(numbers, pivotIndex + 1, end);
    }

    


    public static int partitionStr(String[] str, int start, int end)
    {
        // start not referencing any point in the array
        int i = start - 1;

        // start at the start of the array
        int j = start;

        // set the pivot to the last element in the array
        String pivot = str[end];

        for (j = start; j < end; j++)
        {
            // if (numbers[j] < pivot)
            if (str[j].compareTo(pivot) < 0)
            {
                // increment i if j's associated value is < pivot
                i++;
                // swap values i and j are pointing to
                String tj = str[j];
                str[j] = str[i];
                str[i] = tj;
            }
        }
        // finally, increment i and j then swap them
        i++;
        String tj = str[j];
        str[j] = str[i];
        str[i] = tj;

        return i;
    }
    public static void quickSortStr(String[] str, int start, int end)
    {
        if (start >= end)
            return;

        // partition = split up / divide the array
        int pivotIndex = partitionStr(str, start, end);

        // recursive call to sort the smaller arrays (left side)
        quickSortStr(str, start, pivotIndex - 1);

        // right side
        quickSortStr(str, pivotIndex + 1, end);
    }


     public static void main(String[] args)
    {
        int[] numbers = new int[] { 2,3,99,8,47,5,32,9,8,87,6,700,49,5,73,64,86,7,12,14,16,24,345,1324,123,135,26,34,78,1,2,2,3,4,5,4};
        String[] words = new String[] { "words", "nha", "fsdj", "abc" };
        int[] numbers = new int[] {4,3,2,1};

        System.out.println("UNSORTED:");
        System.out.println(Arrays.toString(numbers));

        quickSort(numbers, 0, numbers.length - 1);

        
        System.out.println("\nSORTED:");
        System.out.println(Arrays.toString(numbers));


        System.out.println("\nUNSORTED:");
        System.out.println(Arrays.toString(words));

        quickSortStr(words, 0, words.length - 1);

        
        System.out.println("\nSORTED:");
        System.out.println(Arrays.toString(words));


    }
    



}
