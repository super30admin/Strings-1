import java.util.*;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0,i=0,j=0;
        HashSet<Character> hs = new HashSet<>();
        
        while(i < s.length() && j < s.length()){
            if(!hs.contains(s.charAt(j))){
                hs.add(s.charAt(j));
                j++;
                max = Math.max(max, j-i);
            }
            else {
                hs.remove(s.charAt(i));
                i++;                
            }
        }

        return max;
    }
}
class Solution {
    public static void main(String[] args){
        System.out.println("Longest Substring");
        LongestSubstring obj = new LongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}