// TC : O(N)
// N --> length of the string

// SC : O(1)
// 26 characters only -- map of size 26

// Approach:
// Iterate over the array and check if the map contains the current character
// if the map contains it and the index at that location is greater than or equal to the left part of the window Then change the left value to left +1
// for every iteration chech the max length. Return max length at the end.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left =0;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right = 0; right < n; ++right){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                if(map.get(c) >= left)
                    left = map.get(c)+1;
            }
            map.put(c,right);
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
