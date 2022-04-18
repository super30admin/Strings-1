// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0)   return 0;
        int max = 0;
        int low = 0;
        
        
       // int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>(); // To store visited characters in S
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){// If character is in curretn longest string, updating starting point for substring
                low = Math.max(map.get(ch), low);
            }
            // if(max < i - low + 1){
            //     end = i;
            //     start = low;
            // }
            map.put(ch, i + 1); //Added character with its updated index
            max = Math.max(max, i - low + 1); // Maximum length comparision
        }
        
        //System.out.println("Start = " + start + "   End = " + end);
        return max;
    }
}