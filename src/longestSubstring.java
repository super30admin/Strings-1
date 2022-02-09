import java.util.HashSet;
import java.util.Set;

/*
     // Time Complexity : O(n)
     // Space Complexity : O(n)
*/
public class longestSubstring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //two point
            if(s.length() <=1  ) return s.length();
            int i =0;
            Set<Character> map = new HashSet<>();
            map.add(s.charAt(i));
            int max=0;
            for(int j=1; j<s.length();j++){
                if(map.contains(s.charAt(j))) {
                    while(s.charAt(i) != s.charAt(j) ){
                        map.remove(s.charAt(i));
                        i++;
                    }
                    i++;
                }
                else{
                    map.add(s.charAt(j));
                }
                if(max<map.size()) {
                    max =map.size();
                }
            }
            return max;
        }
    }
}
