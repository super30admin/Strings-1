/*
Time: O(n): n is a length of input string
Space: O(1) Set can hold at the max 26 chars for Eng lower case alphabets
*/
import java.util.HashSet;

public class LongestSubStrWithoutRepeatingChars{
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("supers"));
    }
    private static int lengthOfLongestSubstring(String s) {
        int longestSubstringLength = 0;
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        int right = 0;
        
        while(left <= right && right < s.length()){
            if(!charSet.contains(s.charAt(right))){
                charSet.add(s.charAt(right++));    
                longestSubstringLength = Math.max(longestSubstringLength, right - left);
            }else{
                    charSet.remove(s.charAt(left++));
            }            
        }
        return longestSubstringLength;
    }
}