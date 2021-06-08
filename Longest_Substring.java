class Solution {
    //Time O(N)
    //Space O(N)
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        int slow = 0 , fast = 0 , max = 0;
        while(fast < s.length())
        {
            char c = s.charAt(fast);
            if(map.containsKey(c))
            {
                slow = Math.max(slow , map.get(c)+1);
            }
            map.put(c , fast);
            max = Math.max(max , fast-slow+1);
            fast++;
        }
        return max;
    }
}