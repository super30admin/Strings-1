// Time Complexity : O(n) where n is length of string
// Space Complexity :O(1) // Number of characters are limited in given case not more than 256 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class LSWRC {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.length() == 0) return 0;
            int i=0;
            int maxLength = 0;
            Map<Character,Integer> map = new HashMap<>();
            for(int j=0;j<s.length();j++)
            {
                
                if(map.containsKey(s.charAt(j)))
                {
                    i = Math.max(i,map.get(s.charAt(j)));
                }
                map.put(s.charAt(j),j+1);
                maxLength = Math.max(maxLength,j-i+1);
                // System.out.println("Character: "+s.charAt(j)+" MaxLength: "+maxLength);
            }
            return maxLength;
        }
    }
    
}
