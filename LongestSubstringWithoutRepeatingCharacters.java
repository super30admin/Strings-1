import java.util.HashMap;
import java.util.Map;

//Time complexity : O(n)
//Space Complexity : O(1)
//Did it run on leetcode : yes

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map= new HashMap<>();
        int i=0, j= 0;

        int result = 0;
        while(j < s.length()){
            char c = s.charAt(j);

            if(map.containsKey(c)){
                //move i to j
                i = Math.max(map.get(s.charAt(j)), i);
            }
            result = Math.max(result,j - i + 1);
            map.put(c, j + 1);
            j++;
        }
        return result;
    }
}
