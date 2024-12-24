// Time Complexity: O(n) for both inner and outer loop which makes it overall as O(2N) but 2 is constant so O(n)
// Space Complexity: O(n) due to set
import java.util.HashSet;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s){
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int max =0;
        int slow = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(slow) != c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow ++;
            }
            set.add(c);
            max = Math.max(max, i - slow +1);
        }
        return max;
    }
    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();
        String input = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(input);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
}
