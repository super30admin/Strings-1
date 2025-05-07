// Time: O(n), Space: O(n)
/*  Approach:
    1. Use a sliding window with two pointers to find substrings without repeating characters.
    2. Move left pointer forward when a duplicate character is found.
    3. Keep updating max length with the size of the current valid window.
*/
import java.util.*;
public class subStringWithoutRepeat 
{
    public int lengthOfLongestSubstring(String s) 
    {
        char[] ch = s.toCharArray();
        int op = 0;
        int len = 0;
        HashSet<Character> set = new HashSet<>();
        int j=0;
        for(int i=0;i<ch.length;i++)
        {
            if(set.contains(ch[i]))
            {
                while(ch[j]!=ch[i])
                {
                    if(set.contains(ch[j]))
                    {
                        set.remove(ch[j]);
                    }
                    j++;
                }
                j++;
            }
            else
            {
                set.add(ch[i]);
            }
            op = Math.max(op,set.size());
        }    
        return op;
    }
}