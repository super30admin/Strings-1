//Time Complexity: O(n) where n is the length of string s
//Space Complexity: O(1)

//Successfully runs on leetcode: 4 ms

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        int slow = 0; int max = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(hmap.containsKey(c))
            {
                slow = Math.max(slow, hmap.get(c));
            }
            hmap.put(c, i+1);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
}