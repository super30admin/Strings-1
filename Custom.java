//Time complexity:- O(n)
//Space complexity:- O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        //HashMap
        //will move only when we need to shrink in case of duplicates
        int slow = 0;
        int maxLen = 0;

        //Store character and index of characters
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            //if the letter already exists then skip all letters upto it.
            //Jump onto next letter
            if(map.containsKey(ch)) {

                //move the slow pointer
                //if the current slow pointer is ahead of earlier duplicate then the character is no longer part of the longest substring
                slow = Math.max(slow, map.get(ch) + 1);
            }

            map.put(ch, i);
            maxLen = Math.max(maxLen, i - slow + 1);
        }
        
        return maxLen;
    }
}