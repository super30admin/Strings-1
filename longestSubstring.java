//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character,Integer> map = new HashMap<>();
       int start = 0, max = 0;
       for(int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);

            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }

            max = Math.max(max, i - start + 1);
            map.put(c, i+1);
       }

       return max;
    }
}