// Time Complexity - O(n) where n is the number of characters in the String
// Space Complexity - O(1) since the hashmap will contain at the max 26 mappings in case of lowercase or 52 in case of all lowercase and uppercase characters
// This solution worked on LeetCode
// We are using 2 pointer solution which will make the brute force solution of n^2 time complexity to O(n). The slow pointer will be the start of the substring and the fast pointer will iterate to check for no repeatation with the help of hashmap. The Hashmap will contain the mapping of the character and the index where the character appearerd. once the character repeatation appears, The slow pointer needs to start from the index next to the first repeated character. 


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0)   return 0;
        int slow =0;
        int fast =0;
        int max =0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(fast < s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(map.get(c),slow); // There will be an edge case where the first occurance of the repeated character has appeared before the slow pointer which is why we take the max of the slow and the index from the hashmap of the character
            }
            map.put(c,fast+1);
            max = Math.max(max,fast-slow+1); 
            fast++;
        }
        return max;
    }
}
