/** Given a string s, find the length of the longest substring without repeating characters.
* TC O(n) SC O(1)
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> index = new HashMap<>();
        int length = 0;
        int j = 0;
        for (int i = 0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            if (index.containsKey(c)){
                j = Math.max(index.get(c), j);
            }
            index.put(c, i+1);
            length = Math.max(i-j+1, length);
        }
        return length;
    }
}
