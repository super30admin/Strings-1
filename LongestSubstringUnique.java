// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1) hashmap with 26 characters at max
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Store the characters and their last occurances in the string in the hashmap. We will
have a slow and fast pointer. If the character is seen again in the string and the map contains the character, move the slow pointer, next to the
index of the last occurance of the character to avoid duplicates. Store the index + 1 in the hashmap to support the previous operation. Maintain
a global max to store the max length of the string.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max =0,slow = 0,j;
        HashMap<Character, Integer> store = new HashMap<>();
        if(s == null || s.length() == 0){return 0;}
        for(j = 0; j < s.length(); j++){                                                    // j acts as the fast pointer
            if(store.containsKey(s.charAt(j))){                                             // Character is a repeat?
                slow = Math.max(store.get(s.charAt(j)), slow);                                  // Move the slow pointer to the next position of its previous occurance
            }
            max = Math.max(j-slow+1, max);                                                  // Max length of the unique string we have till now
            store.put(s.charAt(j), j+1);                                                    // Store the max index of the fast pointer to avoid duplicates
        }
        return max;                                                                         // Return the max string length
    }
}