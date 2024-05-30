//time O(n) n is the length of string
//space O(n) 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < s.length() && j < s.length()) {
            char c  = s.charAt(j);
            if(!set.contains(c)) {
                set.add(c);
                j++;
            } else {
                while(s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
                set.add(s.charAt(j));
                j++;
            }
            max = Math.max(max, j - i);
        }
        return max;

    }
}
