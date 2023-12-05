// Time Complexity : O(s) where s is the length of the string.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s)
    {
        if(s.length() == 0)
            return 0;

        int ans = Integer.MIN_VALUE;
        int startIdx = -1;
        HashMap<Character, Integer> map = new HashMap();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                int oldIdx = map.get(c);
                if(startIdx < oldIdx)
                    startIdx = oldIdx;
            }
            map.put(c, i);
            ans = Math.max(ans, i - startIdx);
        }
        return ans;
    }
}
