//tc : O(n)
//sc : O(n)
//run successfull
//no errors

//used hashsets to save the presence of the a character 
//and used two pointers to search for the letter

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int len = s.length();
        if (len < 1)
            return len;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < len) {
            char letter = s.charAt(end);
            if (set.contains(letter)) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(letter);
                end++;
                max = Math.max(max, end - start);
            }
        }
        return max;
    }
}