// TC : O(n)
// SC : O(1)

package S30_Codes.Strings_1;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;

        while(end < s.length()){
            char c = s.charAt(end);
            if(set.contains(c)){
                set.remove(s.charAt(start));
                start++;
            }
            else{
                set.add(c);
                maxLen = Math.max(maxLen, end-start+1);
                end++;
            }
        }
        return maxLen;
    }
}
