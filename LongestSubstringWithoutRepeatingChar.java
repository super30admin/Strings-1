import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {

    /*
    TC : O(N) where N is the length of the string
    SC : O(1)
    LC : yes
    Problem : No
     */

    /**
     * The approach used here is that a boolean array of 256 size is maitained for all the characters ASCII codes
     * We use a sliding window technique here where we keep on increasing the window size unless we encounter a previously seen
     * character. Once we encounter it, we move the start of the window ahead till it is out of the window.
     * <p>
     * At every stage, we store the maxLen so that at the end we have the longest substring of unqiue characters
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0 || s == null)
            return 0;

        if (s.length() == 1)
            return 1;


        char[] arr = s.toCharArray();
        int start = 0;
        int end = 1;
        boolean[] present = new boolean[256];
        int maxLen = Integer.MIN_VALUE;
        present[arr[0]] = true;
        while (end < arr.length) {
            if (present[arr[end]]) {

                while (present[arr[end]]) {
                    present[arr[start]] = false;
                    start++;
                }
            }


            maxLen = Math.max(maxLen, end - start + 1);
            present[arr[end]] = true;
            end++;
        }
        return maxLen;
    }


    /*
    TC : O(N) where N is the length of the string
    SC : O(1)
    LC : yes
    Problem : No
     */

    /**
     * We use a set to perform the same thing as above - implementa sliding window and use the hashset to keep a track
     * of previously seen characters
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_using_Set(String s) {

        int res = 0;
        int n = s.length();
        int j = 0;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);


            if (set.contains(c)) {

                while (set.contains(c)) {

                    set.remove(s.charAt(j));
                    j++;
                }


            }
            set.add(c);

            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    /*
    TC : O(N) where N is the length of the string
    SC : O(1)
    LC : yes
    Problem : No
     */

    /**
     * Here also we use a sliding window but the approach is slightly different.
     * We use a hashamp to store the characters and the index at which they are found.
     * If we encounter a previously seen character( denoted by character entry already existing in the map) then
     * we set the starting point of the window by using the index of the character from the map +1.
     * <p>
     * Basically here, we dont have an internal while loop to increment the start index by one everytime, we just use the index from the map
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_Using_Map(String s) {

        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int maxLen = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }

            map.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;

    }
}
