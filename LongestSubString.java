import java.util.*;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        // TC:O(2n)
        // SC:O(1)
        int i = 0, max = 0,j=0;
        Set<Character> ans = new HashSet<>();
        while(j<s.length()){
            if(!ans.contains(s.charAt(j))){
                ans.add(s.charAt(j));
                j++;

                max= Math.max(max,ans.size());
            }
            else{
                ans.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring2(String s) {
        // TC:O(n)
        // SC:O(1)
        int left = 0, result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c)+1);
            }
            map.put(c, i);
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
