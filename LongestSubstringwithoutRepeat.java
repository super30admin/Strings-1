import java.util.HashMap;

//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        
        int slow=0;
        int max=0;
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){   //instead of the fast ptr.
            char c=s.charAt(i);
            if(map.containsKey(c)){   //there is a repeat
                slow=Math.max(slow, map.get(c));
            }
            map.put(c,i+1); //HashMap contains character along with its index + 1, for the smoother movement of slow ptr 
            max=Math.max(max, i-slow+1); //max length of substring
        }
        
        return max;
        
        
    }
}