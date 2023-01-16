// Sliding window 
// Maintain left and right pointer
// for the unique char, keep increasing right pointer and add in set
// for repeated char, delete the char from left till repeating char
// at each iteration, take the max length

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left=0, right=0;
        int maxLen = 0;
        while (right<=s.length()-1){
            char ch=s.charAt(right);
            if (!set.contains(ch)){
                set.add(ch);
                right++;
            } else {
                while (s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
                right++;
            }
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}
