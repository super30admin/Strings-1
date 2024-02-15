import java.util.HashSet;
import java.util.Set;
//TC - O(n)
// SC - O(N) - N is length of resultant longest substring

//Using sliding window approach with start and end pointers. THe end pointer fills a set with the result substring,
//whenever, there is a repeating char, the start pointer moves forward until the char is removed.
//maxLen keeps calculating local maximum
public class LongestSubstring {

    public int longestSubstring(String s){
        int st = 0, end = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;

        while(st<s.length() && end < s.length()){
            char ch = s.charAt(end);

            while(set.contains(ch)){
                set.remove(s.charAt(st++));
            }
            set.add(ch);
            maxLen = Math.max(maxLen, set.size());
            end++;
        }
        return maxLen;
    }
    public static void main(String[] args) {

    }
}
