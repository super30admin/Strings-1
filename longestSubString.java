//Time Complexity: O(n) - string length
//Space Complexity: O(n) - non repeating char of string
//Did it run on leetcode: yes
/** Approach: We will iterate the string and store the charcaters in hashmap along with it's index+1 value
    if we see  a repeating character then we will start again from the repeating character and update its 
    value in the hasmap, in the end we will return the max value **/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        int start = 0;
        int end = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int max = Integer.MIN_VALUE;
        
        while(end<s.length()){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                start = Math.max(start, map.get(ch));  
            }
            map.put(ch, end+1);
            max = Math.max(max, end-start+1);
            end += 1;
        }
        
        return max;
        
    }
}
