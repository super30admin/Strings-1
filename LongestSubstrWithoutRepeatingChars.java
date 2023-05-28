import java.util.HashSet;

//Leetcode - 3
//Time Complexity - O(2N)
//Space Complexity - O(1) max 26 characters
public class LongestSubstrWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++) {
            char in = s.charAt(i);
            if(set.contains(in)) {
                while(s.charAt(slow) != in) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            } else {
                set.add(in);
            }
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }

    //Sol-2 using HashMap and O(N) time
    /*
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                slow = Math.max(slow, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
     */
}
