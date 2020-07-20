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

//

/*

public int lengthOfLongestSubstring(String s) {
        if (s == null  || s.length() == 0 ) return 0;
        
        int low = 0;
        int high = 0;
        int [] index = new int[128];
        int max_upto_date = Integer.MIN_VALUE;
        // Map<Character, Integer> map = new HashMap();
        int n = s.length();
        while(high < n){
            Character c = s.charAt(high);
//          set low to the place where last index of low
            low = Math.max(low, index[c]);
//             get max_upto_date
            max_upto_date = Math.max(max_upto_date, high - low + 1);
//             set index of char to high+1 next time when we get this char we need this index to move
            
            index[c] =  high+1;
            high++;
        }
        return max_upto_date;
    }

*/

/*
    public int lengthOfLongestSubstring(String s) {
        if (s == null  || s.length() == 0 ) return 0;
        
        int low = 0;
        int high = 0;
        int max_upto_date = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap();
        // "abcdeabcedgx"
        int n = s.length();
        while(high < n){
            
            Character c = s.charAt(high);
            // System.out.println("low :"+low);
            if(map.containsKey(c)){
                low =  Math.max(map.get(c), low);
            }
            max_upto_date = Math.max(max_upto_date, high - low + 1);
            
            map.put(c, high+1);
        
            high++;
        }
        return max_upto_date;
    }

*/