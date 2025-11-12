//Idea is to use a sliding window with hashset to find unique sub strings.
//Calculate the length of string and track maximum length

//Time Complexity: O(n)
//Space Complexity: O(n)

public class LongestSubString {
    public int LengthOfLongestSubstring(string s) {
        
            string temp = string.Empty;
            int count=0,max = 0;
            int left = 0;
            int len = 1;
        if(s.Length==0)
        {
            return 0;
        }
        
            while ((left + len) <= s.Length)
            {
                count = 0;
                temp = s.Substring(left, len);
                HashSet<char> set = new HashSet<char>();
                foreach (char ch in temp)
                {
                    if (!set.Contains(ch))
                    {
                        count++;
                        set.Add((char)ch);
                    }
                    else 
                    {
                        left++;
                        count = 0;
                        break;
                    }
                
                }
                if (count >= max)
                {
                    len++;
                    max = count;
                }
            
            
            }
            return max;


    }
}