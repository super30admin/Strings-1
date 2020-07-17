import java.util.Set;
import java.util.HashSet;
public class Longest_NonRepeating_Substring{
    public int lengthOfLongestSubstring(String s) {
        if (s == null  || s.length() == 0 ) return 0;
        
        int low = 0;
        int high = 0;
        int max_upto_date = Integer.MIN_VALUE;
        Set<Character> set = new HashSet();
        
        while(  high < s.length()){
            char c = s.charAt(high);
            if(!set.contains(c)){
                
                set.add(c);
                high++;
                max_upto_date = Math.max(max_upto_date,high - low );
            }
            else{
                set.remove(s.charAt(low));
                low++;
        }
        
        }
        
        return  max_upto_date;
    }
}