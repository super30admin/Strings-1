import java.util.HashMap;
import java.util.Map;
/*
Longest Substring without repeating characters
approach: take fast and slow pointers, check if curr element exists in map, if yes, place slow pointer at existing index+1(check if existing index is <current slow)
time: O(n)
space: O(1)
 */
public class Problem2 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int maxLen = 0;
        int fast = 0, slow = 0;

        while (fast<s.length()) {
            char c = s.charAt(fast);
            //always check if existing index is less than current slow so that we don't go back
            if (freq.containsKey(c)) {
                slow = Math.max(slow, freq.get(c)+1);
            }
            freq.put(c, fast);
            maxLen = Math.max(maxLen, fast-slow+1);
            fast++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        problem2.lengthOfLongestSubstring("pwwkew");
    }
}
