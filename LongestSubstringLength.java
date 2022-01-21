// Time Complexity : O(n)
// Space Complexity : O(1)



class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // Sliding window with two pointers
        // Hashmap : Key - Character and Value - Next index the pointer should jump to
        HashMap<Character, Integer> map =  new HashMap<>();
        
        int maxLen = 0;
        
        // two pointers
        int slow = 0;
        int fast = 0;
        
        // Iterate through each character
        while (fast < s.length()){
            
            // current character
            char c = s.charAt(fast);
            
            // If hashmap contains the character, go back and modify the slow pointer as per value in the hashmap
            if (map.containsKey(c)){
                
                // check max of it as slow cannot go back
                slow = Math.max(slow, map.get(c));
            }
            
            // indicates where it should jump to
            map.put(c, fast + 1);
            
            // new window as slow updated , so store maxlen
            maxLen = Math.max( maxLen, fast - slow + 1);
            
            
            fast = fast + 1;
        }
        
        return maxLen;
    }
}