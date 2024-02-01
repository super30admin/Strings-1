// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : Hashing

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap();

        int length = s.length(), left = 0, right = 0, maxCount = 0;

        while(right < length)
        {
            if(map.containsKey(s.charAt(right)))
            {
                int index = map.get(s.charAt(right));
                if(index >= left && index <= right) left = index + 1;
            }
            
            map.put(s.charAt(right), right);
            ++right;
            maxCount = Math.max(maxCount, right - left);
        }

        return maxCount;
    }
}