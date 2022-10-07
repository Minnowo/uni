import java.util.Scanner;
import java.util.Stack;

public class Driver 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stac = new Stack<>();

        for(int i = 0; i < 5; i++)
        {
            System.out.print("Etner a number: ");
            int in = scan.nextInt();
            stac.push(in);
        }
        scan.close();

        // System.out.println(stac.toString());

        // displayElements(stac);

        // stac.forEach(System.out::println);

        // stac.forEach((x) -> {
        //     System.out.println(x);
        // });

        exercise();
    }    

    public static void checkduplicate(String s)
    {
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray())
        {
            if(st.isEmpty())
            {
                st.push(c);
            }
            else if(c == st.peek())
            {
                st.pop();
            }
            else 
            {
                st.push(c);
            }
        }
    }

    public static boolean isvalid(String stac)
    {
        Stack<Character> st = new Stack<>();

        for(char c : stac.toCharArray())
        {
            if(c == '(' || c == '[' || c == '{')
            {
                st.push(c);
            }
            else if(st.isEmpty())
            {
                return false;
            }
            else if(c == ')' && st.pop() != '(' || 
                    c==']'   && st.pop() !='[' || 
                    c=='}'   && st.pop() !='{')
            {
                return false;
            }
        }

        return true;
    }

    public static void exercise()
    {
        Stack<Character> stac = new Stack<>();

        String s = "(){}[]";

        for(int i = 0; i < s.length(); i++)
        {
            stac.push(s.charAt(i));
        }
        
        System.out.println( isvalid(s));
        
    }


    public static boolean search(Stack<Integer> stac, int x)
    {
        return stac.search(x) != -1;
    }

    public static void displayElements(Stack<Integer> stac)
    {
        while (!stac.isEmpty())
        {
            System.out.println(stac.pop());
        }

        // for(int i : stac)
        // {
        //     System.out.println(i);
        // }
    }
}
