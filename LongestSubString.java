import java.util.*;
public class LongestSubString {
    

    public static int Length(String s)
    {
        if(s == null || s.length() == 0)
        {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int start = 0, end = 0, max = 0;


        int si = 0,ei =0;
        while(end<s.length())
        {
            if(!set.contains(s.charAt(end)))
            {
                set.add(s.charAt(end));
                int temp = max;
                max = Math.max(max, set.size());
                if(max>temp)
                {
                    si = start;
                    ei = end;
                }
                end++;
            }
            else{
                set.remove(s.charAt(start));
                start++;
            }
        }

        System.out.println(s.substring(si, ei+1));
        return max;
    }


    public static void main(String args[])
    {
        String s = "bbbbbbbbbb";
        System.out.println(Length(s));
    }


}
