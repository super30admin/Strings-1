// TC: SC: O(n)

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int n = s.length();
        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        // // HashSet<Character> set = new HashSet<>();
        // int[] set = new int[256];
        // Arrays.fill(set, -1);

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){ 
                slow = Math.max(slow, map.get(c)+1);
            }
            // set.add(c);
            map.put(c,i);
            max = Math.max(max,i-slow+1);
        }

        return max;
    }
}