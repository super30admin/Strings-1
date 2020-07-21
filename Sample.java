// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder st = new StringBuilder(); // to create the string
        HashMap<Character, Integer> map = new HashMap<>(); // to store t string characters with frequency
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < S.length(); i++) { // iterate over string s
            char c = S.charAt(i); // get character

            while (map.containsKey(c)) { // till t has the character
                st.append(c); // append it
                map.put(c, map.get(c) - 1); // decrease frequency
                map.remove(c, 0); // remove when count is zero
            }
        }

        for (char c : map.keySet()) { // iterate over all elements of map
            int count = map.get(c); // get count
            while (count > 0) { // till the count doesnt become zero for the character
                st.append(c); // append it
                count--; // decrease the count
            }

        }

        return st.toString(); // convert the string builder to string
    }
}

// Time Complexity : O(2n)
// Space Complexity : O(1) as 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (fast < s.length()) { // till fast reaches end
            char c = s.charAt(fast); // get character at fast
            if (map.containsKey(c)) { // if map contains the character
                slow = Math.max(slow, map.get(c) + 1); // update slow to the place after index where repeat begins

            }
            map.put(c, fast); // store the character and its index
            max = Math.max(max, fast - slow + 1); // find max distance as max of previous max and distance between slow
                                                  // and fast
            fast++; // update fast

        }

        return max;
    }
}