// approch 1
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 3
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class Main {
    // approch 1 brute force
    public static int lengthOfLongestSubstring1(String s) {
        int max = 0;
        int n = s.length();
        // two for loops for getting all the substrinfs
        for (int i = 0; i < n; i++) {
            // set to check repeating character or not
            HashSet<Character> set = new HashSet<>();
            int j = i;
            for (j = i; j < n; j++) {
                // char at index j
                char c = s.charAt(j);
                // if set already contains char c then count maximum index and break the loop
                if (set.contains(c)) {
                    max = Math.max(max, j - i);
                    break;
                }
                set.add(c);
            }
            // if j is at the end of the string that means there is no repeating characters
            // till now so
            // we count max again
            if (j == n) {
                max = Math.max(max, j - i);
            }
        }

        // return max;
        return max;
    }

    // approch 2 using HashSet and two pointers
    public static int lengthOfLongestSubstring2(String s) {
        // set for checking repeating characters
        HashSet<Character> set = new HashSet<>();
        // max value
        int max = 0;
        // slow pointer
        int slow = 0;
        // fast pointer
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if set contains char c then we remove all the character from the set till
            // character at fast repeating character;
            if (set.contains(c)) {
                while (s.charAt(slow) != c) {
                    char sc = s.charAt(slow);
                    set.remove(sc);
                    slow++;
                }
                slow++;
            }
            // add char in set;
            set.add(c);
            // count max
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }

    // approch 3 using map and two pointers
    public static int lengthOfLongestSubstring3(String s) {
        // map for storing character and its index+1;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        // slow pointer
        int slow = 0;
        // fast pointer
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // update slow pointer
                slow = Math.max(slow, map.get(c));
            }
            // update max value;
            max = Math.max(max, i - slow + 1);
            map.put(c, i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring1(s));
        System.out.println(lengthOfLongestSubstring2(s));
        System.out.println(lengthOfLongestSubstring3(s));

    }
}