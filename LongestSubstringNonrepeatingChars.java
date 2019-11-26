/*
Author: Akhilesh Borgaonkar
Problem: LC 3. Longest Substring Without Repeating Characters (Strings-1)
Approach: Using Sliding window approach here. Hashmap is used to keep a track of index that the character appeared previously. Whenever a repeating
    character is found then, seek the slow pointer to the previous occurence index+1 to start new window. Also keep checking the max length between
    fast and slow pointers to find the max length of non-repeating characters.
Time Complexity: O(n) where n is length of input string.
Space complexity: O(1) coz worst you will store 256 characters in HashMap.
LC verified.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int max_len = 0, slow = 0, fast = 0;
        
        while(fast < s.length()){                       //maintain a sliding window to check for non-repeating characters
            if(map.containsKey(s.charAt(fast)))         //if character at index fast is repeating then 
                slow = Math.max(slow, map.get(s.charAt(fast))); //seek the slow pointer to one next to previous occuring index
            map.put(s.charAt(fast), ++fast);            //keep putting characters and their index in the map
            max_len = Math.max(max_len, fast - slow);   //check for max length everytime in the window
        }
    
        return max_len;
    }
}