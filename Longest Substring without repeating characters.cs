/*
  Time complexity: O(n)
  Space complexity: O(1)

  Code ran successfully on leetcode: Yes

*/

public class Solution {
    public int LengthOfLongestSubstring(string s) {
        int left = 0;
        int right = 0;
        int length = 0;
        HashSet<char> hs = new();

        while(right<s.Length)
        {
            if(!hs.Contains(s[right]))
            {
                hs.Add(s[right]);
                right++;
            }
            else
            {
                hs.Remove(s[left]);
                left++;
            }
            length = Math.Max(length, right-left);
        }

        return length;
    }
}
