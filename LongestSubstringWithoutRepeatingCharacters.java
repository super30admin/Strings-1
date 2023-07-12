import java.util.HashSet;
import java.util.Set;

//Time complexity: O(N)
//Space complexity: O(1)
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ptr1 = 0;
        int ptr2 = 0;
        int maxLen = 0;
        for(ptr2 = 0; ptr2 < s.length(); ptr2++){
            if(!set.contains(s.charAt(ptr2))){
                set.add(s.charAt(ptr2));
                maxLen = Math.max(maxLen, ptr2 - ptr1 + 1);

            }else{
                while(ptr1 < ptr2 && s.charAt(ptr1) != s.charAt(ptr2)){
                    set.remove(s.charAt(ptr1));
                    ptr1++;
                }
                ptr1++;
            }

        }

        return maxLen;

    }
}
