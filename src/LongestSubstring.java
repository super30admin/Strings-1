// Time Complexity:  O(max(n,m))
// Space Complexity: O(1)
// where n is number of letters in string s, m is number of letters in string order

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0, j = 0;

        while(j < s.length()) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {             // already in map
                int chIndex = map.get(c);
                if(i <= chIndex) {               // previously visited character within window
                    i = chIndex + 1;             // then reducing window
                }
            }
            map.put(c, j);                       // new character
            max = Math.max(j-i+1, max);          // updating length
            j++;
        }
        return max;



//// ****************************** BRUTE FORCE APPROACH ******************************
// Time Complexity:  O(n^2)
// Space Complexity: O(1)
//        Set<Character> set = new HashSet<>();
//        int max = 0;
//
//        for(int i=0; i<s.length(); i++) {
//            for(int j=i; j<s.length(); j++) {
//                char c = s.charAt(j);
//                if(!set.contains(c)) {         // if set doesn't contain character
//                    set.add(c);                // then add it in set
//                    if(set.size() > max) {     // if getting new longest substring with unique characters
//                        max = set.size();      // update max
//                    }
//                }
//                else {                         // if set contains character
//                    set = new HashSet<>();     // then get new set
//                    break;                     // and start again
//                }
//            }
//        }
//        return max;
    }
}