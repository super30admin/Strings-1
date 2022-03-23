import java.util.HashSet;
/*
Time Complexity: O(n), n is the length of the given string
Space Complexity: O(n), n is the size of the HashSet
Any difficulties: no
Run on Leetcode: Yes

Approach:
1. Taking HashSet to maintain uniqueness in the string characters, I will be adding characters in the set if it come for the
first time, and will increment the size of the count using size of hashset
2. Otherwise, I would remove that character from hashset from its first occurrence
 */
public class LongestSubStringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s){
        char[] cArr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();

        int a = 0;
        int b = 0;
        int count = 0;

        while(b<s.length()){
            if(!set.contains(cArr[b])){
                set.add(cArr[b]);
                b++;
                count = Math.max(set.size(), count);
            }else{
                set.remove(cArr[a]);
                a++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println("Length of longest Substring: "+ lengthOfLongestSubstring("abcabcbb"));
    }
}
