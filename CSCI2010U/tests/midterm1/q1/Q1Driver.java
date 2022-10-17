import java.util.ArrayList;

public class Q1Driver 
{

    public static int getLongestBookNameLength(ArrayList<String> books)
    {
        // Fill in this function
        int longestWord = 0;

        // loop through books
        for(String book : books) // O(n)
        {
            // search each name for number of spaces, count the words
            int count = 1; // O(1)
            for(Character c : book.toCharArray()) // O(m)
            {
                if(c == ' ') // O(1)
                {
                    count++; // O(1)
                }
            }

            // find and update the count 
            if(longestWord < count) // O(1)
            {
                longestWord = count; // O(1)
            }
        }

        // return found count
        return longestWord;

        // runtime = O(n*m)
    }
    public static void main(String[] args) 
    {

        ArrayList<String> books = new ArrayList<>();
        books.add("Introduction to Programming");
        books.add("Data Structures and Algorithms");
        books.add("Software Development");
        books.add("Programming in Java");
        books.add("Data Structures");
        books.add("Programming in C++");
        books.add("Java for Beginners");
        System.out.printf("Longest Book Name has %d words.", getLongestBookNameLength(books));
  
    }
}