import java.util.*;

public class LongestSubstringWithOutRepetition {

    //TC: O(N) Traversing all the elements in the string. So it will be O(N)
    //SC: O(N) as we are using the hash map to get the index and duplicates.
    public int lengthOfLongestSubstring(String s) {
        // Sanitization
        // Create a hashmap to save the character and the index
        // fast pointer - Move until it didn't find the duplicate
        // slow pointer - If the fast pointer pointed the duplicate, get that index and
        // place it next to it.

        if (s == null || s.length() == 0)
            return 0;
        int slowPointer = 0;
        int fastPointer = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap();
        while (fastPointer < s.length()) {
            char currentChar = s.charAt(fastPointer);
            if (map.containsKey(currentChar)) {
                int currentIndedx = map.get(currentChar);
                if (slowPointer <= currentIndedx) {
                    slowPointer = currentIndedx + 1;
                }
            }
            int difference = fastPointer - slowPointer;
            result = Math.max(result, difference + 1);
            map.put(currentChar, fastPointer);
            fastPointer++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithOutRepetition longestSubString = new LongestSubstringWithOutRepetition();
        int result = longestSubString.lengthOfLongestSubstring("blahandymani");
        System.out.println("The longest length of the non repetitative length is " + result);
    }
}
