// Time Complexity :O(N) -> N - length of  given String
// Space Complexity :O(N) -> Hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Start from first character and for each next element if it is  not present in hash set increment count and add this to hash set ,
//    else break from loop .
// 2. Now if count is greater than max update max . Now do this for characters starting till length-max since after this ,
//    the maximum length will always be less than max  .
import java.util.HashSet;

public class longestSubstring {
    public static int lengthOfLongestSubstring(String S) {
        if(S.length() == 0 || S.length() == 1)  return S.length();
        int max = 0;
        // abcdefagh
        for(int i = 0;i<S.length()-max;i++){
            HashSet<Character> set = new HashSet<>();
            int count = 0;
            for(int j=i;j<S.length();j++){
                if(set.contains(S.charAt(j)))
                    break;
                set.add(S.charAt(j));
                count++;
            }
            if(count>max)
                max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abcabcbb"));
    }
}
