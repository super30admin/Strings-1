//used 2 pointers. One is start and other is end, push the pointers until the charcters are unique and if not then push start until unique is not found. keep max at the global scope to check if current max is greater than the previous one and if yes update it

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }

        int max = 0;
        int start = 0;
        int end = 0;
        HashSet<Character> hs = new HashSet<>();

        while (end < s.length()) {
            char ch = s.charAt(end);
            while (hs.contains(ch)) {
                hs.remove(s.charAt(start));
                start++;
            }

            hs.add(ch);
            max = Math.max(max, end - start + 1);

            end++;
        }

        return max;
    }
}