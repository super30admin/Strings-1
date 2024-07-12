// Time Complexity : O(n) where n is the length of string s
// Space Complexity : O(1) // Even though we are using a set, consider we have all lower case still we will still be storing only 26 char
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Use Hashmap with key as the character and value as the the latesr index at which the character was found. Use start variable = 0. Start iterating over string, if a character is preset in map then calculate new start to basically ignore the characters before the repeat was found. Then add a char with value i+1 to store the latest index and calculate max
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;

        for(int i =0; i<s.length(); i++){

            char c = s.charAt(i);

            if(map.containsKey(c)){
                start = Math.max(start, map.get(c));
            }

            map.put(c, i +1);
            max = Math.max(max, i - start +1);
        }

        return max;
    }
}