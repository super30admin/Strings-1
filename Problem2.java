/*
    LC - 3. Longest Substring Without Repeating Characters
    TC - O(n)
    SC  - O(1)
    Approach - 
        Keep start from zero
        traverse through the string
        if the char not present in map then add it with value of index + 1 
        if the char already present then get the value and to reset the start
        calculate the max length using i - start + 1
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> myMap = new HashMap<>();
        int start = 0;
        int max = 0;
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(myMap.containsKey(c)) {
                start = Math.max(start, myMap.get(c));
            }
            max = Math.max(max, i - start + 1);
            myMap.put(c, i+1);
        }
        return max;
    }
}