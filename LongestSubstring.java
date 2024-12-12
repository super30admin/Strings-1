/*
 * TC - O(n)
 * Sc - O(1)
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    //map approach - o(n)
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int slow = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c)+1);
            }
            map.put(c,i);
            max = Math.max(i-slow+1, max);
        }

        return max;
    }

    //set approach - O(2n)
    // public int lengthOfLongestSubstring(String s) {
    //     if(s.length() == 0) return 0;
    //     int n = s.length();
    //     Set<Character> set = new HashSet<>();
    //     int max = 0;
    //     int slow = 0;
    //     for(int i = 0; i < n; i++){
    //         char c = s.charAt(i);
    //         if(set.contains(c)){
    //             while(s.charAt(slow) != c){
    //                 set.remove(s.charAt(slow));
    //                 slow++;
    //             }
    //             slow++;
    //         }
    //         set.add(c);
    //         max = Math.max(i-slow+1, max);
    //     }

    //     return max;
    // }
}
