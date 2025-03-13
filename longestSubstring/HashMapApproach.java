package longestSubstring;


import java.util.HashMap;

//The approach is to use two pointers to get the substring and get the length between them as we traverse through the String and return the maximum length
//The idea is to store the indices of characters in the String in a Hashmap, so that when we find a repeat when traversing, we jump our slow pointer directly to the next of the repeated character
//Time Complexity: O(n) where n is the length of the string
//Space Complexity: O(1), hashmap contains only 26 characters

class HashMapApproach {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int slow = 0;

        HashMap<Character, Integer> map = new HashMap();
        int maxLength = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(map.containsKey(ch)) {
                slow = Math.max(slow, map.get(ch) + 1);
            }
            map.put(ch, i);

            maxLength = Math.max(maxLength, i- slow + 1 );

        }

        return maxLength;
    }
}