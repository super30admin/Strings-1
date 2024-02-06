import java.util.HashSet;
//TC :-On SC On
class longestSubString {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        HashSet<Character> hs = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            if (!hs.contains(s.charAt(i))) {
                hs.add(s.charAt(i));
            } else {
                while (s.charAt(slow) != s.charAt(i)) {
                    hs.remove(s.charAt(slow));
                    slow++;

                }
                slow++;
            }
            max = Math.max(max, i - slow + 1);
        }

        return max;
    }
}