/*
Sliding window approach
TC --> O(n)
SC --> O(1)
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int max_size = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (!mp.containsKey(c)) {
                mp.put(c, 1);
                max_size = Math.max(max_size, (j - i + 1));

            }//if
            else {
                while (mp.containsKey(c)) {
                    char ch = s.charAt(i);
                    mp.remove(ch);
                    i++;

                }

            }
            mp.put(s.charAt(j), 1);
            j++;
        }//while

        return max_size;

    }
}
