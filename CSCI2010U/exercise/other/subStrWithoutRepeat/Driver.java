import java.util.HashSet;

public class Driver 
{
    public static int lengthOfLongestSubstring(String s) 
    {
        HashSet<Character> seen = new HashSet<>();

        int maxLen = 0;
        int len = 0;

        for(int i = 0; i < s.length(); i++)
        {
            Character c = s.charAt(i);
            System.out.println(c);

            if(!seen.contains(c))
            {
                seen.add(c);
                len++;
                continue;
            }
            
            if(len > maxLen) 
            {
                maxLen = len;
            }

            seen.remove(c);
            len--;
            i--;
            continue;
        }

        if(len > maxLen)
            return len;

        return maxLen;
    }

    public static void main(String[] args) 
    {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
