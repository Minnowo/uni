import java.util.ArrayList;

import java.util.Collections;


public class Q2Driver 
{

    public static void sameLengthSelectedWords(ArrayList<String> words)
    {
        // Fill in this function

        // first element
        int shortestWord = words.get(0).length();

        // loop through words to find the shortest
        for(String s : words) // O(n)
        {
            if(shortestWord > s.length()) // O(1)
            {
                shortestWord = s.length(); // O(1)
            }
        }

        // filter out any words longer 
        final int shortest = shortestWord; // O(1) 
        words.removeIf(p -> p.length() > shortest); // O(n^2)

        // runtime = O(n^2)
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("Bye");
        words.add("Apple");
        words.add("Toronto");
        words.add("Eye");
        words.add("Oshawa");
        words.add("Pie");
        words.add("Ontario");

        System.out.println("\nOriginal ArrayList: ");
        System.out.println(words);

        sameLengthSelectedWords(words);
        System.out.println("\nArrayList with words having minimum length:");
        System.out.println(words);
        
        
    }
}