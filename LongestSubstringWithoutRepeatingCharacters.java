// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach:
1) we use a sliding window approach, in this case
2) we use a hashmap, where we store the position of the occurences of the current character
3) we have 2 pointers slow and i which are left and right respectively
4) if c is already present that means we encounter c again and now we store the latest position of c now 
5) insert the position of the latest occurence of the character
-> map.put(c,i+1); // positions should be i+1 as we deal with indices
            maxLen=Math.max(maxLen,i-slow+1);
6) slow will be the left pointer and i would be the right pointer
    -> idea is to store the position of latest occurence of character if already present in map
    -> else store the position 
*/


public class LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubstring(String s) {
       
        Map<Character,Integer> map = new HashMap();
        
        int slow =0;
        int maxLen = Integer.MIN_VALUE;
        
        if(s==null || s.length()==0)
        {
            return 0;
        }    
        
        
        
        // slow will be the left pointer and i would be the right pointer
        // idea is to store the position of latest occurence of character if already present in map
        // else store the position 
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            
            if(map.containsKey(c)) // if c is already present that means we encounter c again and now we store the latest position of c now and
            {
                slow = Math.max(slow,map.get(c)); // update the left pointer and start moving the pointer to right
            }
            
            // insert the position of the latest occurence of the character
            map.put(c,i+1); // positions should be i+1 as we deal with indices
            maxLen=Math.max(maxLen,i-slow+1);
            
            
        }
        
        
        return maxLen;
    }

}
